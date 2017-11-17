package com.project.Event.services;


import com.project.Event.models.Event;
import com.project.Event.models.Comment;
import com.project.Event.models.Role;
import com.project.Event.models.User;
import com.project.Event.repositories.UserRepository;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	private UserRepository userRepository;

	public UserDetailsServiceImplementation(UserRepository userRepository) {
		this.userRepository= userRepository;
	}

	// 1
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user));
	}

	// 2
	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
}
