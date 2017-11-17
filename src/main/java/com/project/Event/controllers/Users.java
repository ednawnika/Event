package com.project.Event.controllers;

import java.util.ArrayList;
import com.project.Event.models.User;
import com.project.Event.models.Event;
import antlr.collections.List;
import com.project.Event.models.Comment;
import com.project.Event.repositories.RoleRepository;
import com.project.Event.repositories.UserRepository;
import com.project.Event.services.CommentService;
import com.project.Event.services.EventService;
import com.project.Event.services.UserService;
import com.project.Event.validators.UserValidator;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import com.project.Event.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.Event.models.Role;


@Controller
public class Users {
	private UserService userService;
	private UserValidator userValidator;
	private EventService eventService;
	private CommentService commentService;

	
	
	public Users(UserService userService, UserValidator userValidator, CommentService commentService, EventService eventService){
		this.userService= userService;
		this.userValidator=userValidator;
		this.commentService=commentService;
		this.eventService=eventService;


	}


	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			
			return "loginPage";
		}else{
			userService.saveWithUserRole(user);
				
			return "redirect:/";
		}
	}	

			
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		
		model.addAttribute("currentUser", userService.findByUsername(username));
		model.addAttribute("users", userService.findAll());
		model.addAttribute("users_roles", userService.findAlls());
		
		return "adminPage";
	}
	

// renders page
	@RequestMapping("/loginuser")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successfull!");
		}
		return "loginPage";	
	}
	


	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		User currentuser = userService.findByUsername(principal.getName());
		for(Role role: currentuser.getRoles()){
			if(role.getName().equals("ROLE_ADMIN")){
				return "redirect:/admin";
			}else{
			
			}
		}return "redirect:/events";
	}


	@RequestMapping(path ="admin/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}


	
	@RequestMapping(path ="/admin/upgrade/{id}")
	public String promote(@PathVariable("id") Long id) {
		userService.saveUserWithAdminRole(userService.get(id));
		return "redirect:/admin";
	}



	@RequestMapping("/events")
	public String eventshome(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model){
		model.addAttribute("events", eventService.findAll());
		model.addAttribute("users", userService.findAll());
		return "events";
	}


	@PostMapping("/event")
	public String eventnew(@Valid @ModelAttribute("event") Event event, Principal principal,  BindingResult result, Model model){
		String username = principal.getName();
		User usr = userService.findByUsername(username);

		
		event.getUsers().add(usr);
		eventService.create(event); 


		return "redirect:/events";

		
	}

	@RequestMapping("/events/profile/{id}")
	public String profile(@PathVariable("id") int id, Model model){
		Event event = eventService.showbyIndex(id);
		model.addAttribute("event", event);
		model.addAttribute("events", eventService.findAll());
		model.addAttribute("users", userService.findAll());
		
		return "profile";

	
}


	@RequestMapping("/events/edit/{id}")
	public String editEvent(@ModelAttribute("event") Event event,@PathVariable("id") Long id, Model model) {
		Event even = eventService.showbyIndex(id);
		model.addAttribute("even", even);
			return "editEvent";
		
		}
	

	@PostMapping("/events/edit/{id}")
	public String updateEvent(Principal principal, @PathVariable("id")Long id, @Valid @ModelAttribute("even") Event even, BindingResult result) {
		if (result.hasErrors()) {
			return "editEvent";
		} else {
			
			eventService.updateEvent(even);
			return "redirect:/events";
			
		}
}	

	@RequestMapping(path = "events/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}

}
