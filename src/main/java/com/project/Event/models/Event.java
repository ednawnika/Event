package com.project.Event.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.project.Event.services.CommentService;

@Entity
@Table(name = "events")
public class Event{
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String comment;
	private String date;
	private String location;
	private String host;



	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_events",
	joinColumns = @JoinColumn(name = "event_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))

	private List<User> users;


	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	private List<Comment> comments;




	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	


	
	public Event(){

		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		if(this.users == null){
			this.users= new ArrayList<User>();
		}

		return (List<User>) users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}



	// public List<Host> getHosts() {
	// 	if(this.hosts == null){
	// 		this.hosts= new ArrayList<Host>();
	// 	}

	// 	return (List<Host>) hosts;
	// }
	

	}

