package com.project.Event.models;

import java.util.Date;
import java.util.List;
import com.project.Event.models.User;
import com.project.Event.models.Role;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users_roles")
public class User_Role {
    @Id
    @GeneratedValue
    private long id;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User user;


    @DateTimeFormat(pattern = "MM:dd:yyyy HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "MM:dd:yyyy HH:mm:ss")
    private Date updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }

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


    public User_Role () {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

 }
