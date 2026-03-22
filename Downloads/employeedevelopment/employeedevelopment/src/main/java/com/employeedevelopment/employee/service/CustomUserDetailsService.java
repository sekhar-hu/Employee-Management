package com.employeedevelopment.employee.service;

	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employeedevelopment.employee.entity.User;
	import com.employeedevelopment.employee.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
	public class CustomUserDetailsService implements UserDetailsService {
		private  UserRepository userrepository;
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userrepository.findByUsername(username)
					.orElseThrow(()-> new UsernameNotFoundException("User not found"));
					
			return new CustomUserDetails();
		}
		

		

}
