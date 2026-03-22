package com.employeedevelopment.employee.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employeedevelopment.employee.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {
		@Autowired
		private JwtUtill jwtUtill;
		@Autowired
		private CustomUserDetailsService customUserDetailsService;
		
		
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		String username=null;
		String jwt=null;
		
		if(authHeader !=null && authHeader.startsWith("Bearer")) {
			jwt =authHeader.substring(7);
			username = jwtUtill.extractUsername(jwt);
		}
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
			var userDetails = customUserDetailsService.loadUserByUsername(username);
			if(jwtUtill.validateToken(jwt,userDetails.getUsername())) {
				var authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
			filterChain.doFilter(request, response);
		}
}


