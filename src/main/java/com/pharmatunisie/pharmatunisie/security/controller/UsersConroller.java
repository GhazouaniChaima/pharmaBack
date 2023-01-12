package com.pharmatunisie.pharmatunisie.security.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmatunisie.pharmatunisie.dto.MedicamentDto;

import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;
import com.pharmatunisie.pharmatunisie.security.config.JwtUtils;
import com.pharmatunisie.pharmatunisie.security.dto.UserDTO;
import com.pharmatunisie.pharmatunisie.security.entity.UserEntity;
import com.pharmatunisie.pharmatunisie.security.payload.request.LoginRequest;
import com.pharmatunisie.pharmatunisie.security.payload.request.SignupRequest;
import com.pharmatunisie.pharmatunisie.security.payload.response.JwtResponse;
import com.pharmatunisie.pharmatunisie.security.payload.response.MessageResponse;
import com.pharmatunisie.pharmatunisie.security.repository.UserRepository;
import com.pharmatunisie.pharmatunisie.security.service.Iuser;
import com.pharmatunisie.pharmatunisie.security.service.UserDetailsImpl;
import com.pharmatunisie.pharmatunisie.service.Imedicament;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UsersConroller {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Iuser iuser;
	
	public UsersConroller(Iuser iuser) {
		super();
		this.iuser = iuser;
	}
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> ajouterUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account

		UserEntity user = new UserEntity(signUpRequest.getUsername(), signUpRequest.getFullName(), signUpRequest.getPhone(), signUpRequest.getAddress(),
				signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),encoder.encode(signUpRequest.getRawPassword()));
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("add useris successfully!"));
	}
	
	
	@GetMapping
	public List<UserDTO> getAllUser() {
		System.out.println("iuser.getAllUsers()"+iuser.getAllUsers());
		return iuser.getAllUsers().stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") int id) {
		UserEntity user = iuser.getUserById(id);

		// convert entity to DTO
		UserDTO userResponse = modelMapper.map(user, UserDTO.class);

		//return ResponseEntity.ok().body(userResponse);
		return new ResponseEntity<UserDTO>(userResponse, HttpStatus.OK);
	}

//
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO UserDto) {

		// convert DTO to Entity
		UserEntity userRequest = modelMapper.map(UserDto, UserEntity.class);

		UserEntity user = iuser.updateUser(id, userRequest);

		// entity to DTO
		UserDTO userResponse = modelMapper.map(user, UserDTO.class);

		return ResponseEntity.ok().body(userResponse);
	}
	
	@PutMapping("activate/{id}")
	public ResponseEntity<UserDTO> activateUser(@PathVariable int id, @RequestBody UserDTO UserDto) {

		// convert DTO to Entity
		UserEntity userRequest = modelMapper.map(UserDto, UserEntity.class);
		

	
		UserEntity user = iuser.activateUser(id, userRequest);
		
		// entity to DTO
		UserDTO userResponse = modelMapper.map(user, UserDTO.class);

		return ResponseEntity.ok().body(userResponse);
	}	
	
	@PutMapping("deactivate/{id}")
	public ResponseEntity<UserDTO> deactivateUser(@PathVariable int id, @RequestBody UserDTO UserDto) {

		// convert DTO to Entity
		UserEntity userRequest = modelMapper.map(UserDto, UserEntity.class);

		UserEntity user = iuser.deactivateUser(id, userRequest);

		// entity to DTO
		UserDTO userResponse = modelMapper.map(user, UserDTO.class);

		return ResponseEntity.ok().body(userResponse);
	}	
	
}

