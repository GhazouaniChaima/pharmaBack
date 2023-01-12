package com.pharmatunisie.pharmatunisie.security.service;

import com.pharmatunisie.pharmatunisie.security.entity.UserEntity;
import java.util.List;

public interface Iuser {
   
	List<UserEntity> getAllUsers();

	UserEntity createUser(UserEntity user);

	UserEntity updateUser(int id, UserEntity user);
	UserEntity activateUser(int id, UserEntity user);
	UserEntity deactivateUser(int id, UserEntity user);

	
	void deleteUser(int id);

	UserEntity getUserById(int id);
}

