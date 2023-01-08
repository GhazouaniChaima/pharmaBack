package com.pharmatunisie.pharmatunisie.security.entity;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name= "username",unique = true, nullable = false)
	private String username;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "fixe")
	private String fixe;

	@Column(name = "address", length = 200)
	private String address;

	@Column(name = "have_avatar", columnDefinition = "tinyint(1) default 0")
	private boolean haveAvatar;

	@Column(name="email",unique = true, nullable = true)
	private String email;

	@Column(name="password")
	@JsonIgnore
	private String password;
	
	@Column(name="raw_password")
	private String rawPassword;

	@Column(name="avatar")
	private String avatar;
	
	@Column(name = "created_at")
	
	private LocalDateTime createdAt;

	/*@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	List<Role> roles;*/

	@Column(name = "enable", columnDefinition = "tinyint(1) default 1")
	private boolean enable;
	
	@Column(name="theme")
	private String theme;

	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public UserEntity(String username, String fullName, String phone, String fixe, String address,
			 String email, String password, String rawPassword) {
		super();
	
		this.username = username;
		this.fullName = fullName;
		this.phone = phone;
		this.fixe = fixe;
		this.address = address;
		this.email = email;
		this.password = password;
		this.rawPassword = rawPassword;
		this.createdAt = LocalDateTime.now();
		
	}




	/* public UserEntity( String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}*/


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public List<Role> getRoles() {
		return roles;
	}*/

	/*public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFixe() {
		return fixe;
	}

	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isHaveAvatar() {
		return haveAvatar;
	}

	public void setHaveAvatar(boolean haveAvatar) {
		this.haveAvatar = haveAvatar;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	

}

