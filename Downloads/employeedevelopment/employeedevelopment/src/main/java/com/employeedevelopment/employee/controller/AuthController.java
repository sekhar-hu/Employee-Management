package com.employeedevelopment.employee.controller;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeedevelopment.employee.entity.User;
import com.employeedevelopment.employee.repository.RoleRepository;
import com.employeedevelopment.employee.repository.UserRepository;
import com.employeedevelopment.employee.security.JwtUtill;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository repository;
	private JwtUtill jwtUtill;
	private PasswordEncoder encoder;
	@PostMapping("/register")
	public String rigster(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(Set.of(repository.findByRoleName("ROLE_EMPLOYEE").get()));
		userRepository.save(user);
		return "User register";
		
	}
	public String login(@RequestBody User user) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		return jwtUtill.generateToken(user.getUsername());
	}
	

}
