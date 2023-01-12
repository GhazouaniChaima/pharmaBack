package com.pharmatunisie.pharmatunisie.security.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.pharmatunisie.pharmatunisie.security.entity.UserEntity;
import com.pharmatunisie.pharmatunisie.security.repository.UserRepository;
import com.pharmatunisie.pharmatunisie.security.service.Iuser;
@Service
public class UserService implements Iuser{
	
private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		
		List<UserEntity>	x  = userRepository.findAll();
		//System.out.print(x.get(0).getName());
		return x;
	}

	@Override
	public UserEntity createUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity updateUser(int id, UserEntity userRequest) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow();
		
		user.setUsername(userRequest.getUsername());
		user.setFullName(userRequest.getFullName());
		user.setPhone(userRequest.getPhone());
		user.setAddress(userRequest.getAddress());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setEmail(userRequest.getEmail());
		return userRepository.save(user);
	}
	
	public UserEntity activateUser(int id, UserEntity userRequest) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow();
		
		user.setEnable(true);
			return userRepository.save(user);
	}
	
	public UserEntity deactivateUser(int id, UserEntity userRequest) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow();
		
		user.setEnable(false);
			return userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow();
		
		userRepository.delete(user);
	}

	@Override
	public UserEntity getUserById(int id) {
		UserEntity result = userRepository.findById(id).orElseThrow();
		
			return result;
		
		

	}
}
