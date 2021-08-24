package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.models.AuthenticationReponse;
import com.vn.models.AuthenticationRequest;
import com.vn.service.MyUserDetailService;
import com.vn.utils.JwtUtils;

@RestController
public class HelloJwt {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@RequestMapping({"/hello"})
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
			
		} catch (BadCredentialsException e) {
			throw new Exception("Incorect username or password ",e);
		}
		final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationReponse(jwt));
	}
}
