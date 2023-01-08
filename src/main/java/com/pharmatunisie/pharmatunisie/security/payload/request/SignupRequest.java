package com.pharmatunisie.pharmatunisie.security.payload.request;


import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
   /* @NotBlank
    @Size(max = 50)
    @Email
    private String email;*/
    
   // private Set<String> role;
    
 	
	
	private String fullName;
	

	private String phone;

	private String fixe;


	private String address;

	@Email
	private String email;


	private String rawPassword;

    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 

 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
    

}

