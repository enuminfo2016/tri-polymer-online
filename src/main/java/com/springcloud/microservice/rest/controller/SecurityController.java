/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.IRequestPath;
import com.springcloud.microservice.rest.dto.JwtResponseDto;
import com.springcloud.microservice.rest.dto.MessageResponseDto;
import com.springcloud.microservice.rest.dto.UserDto;
import com.springcloud.microservice.security.jwt.JwtUtils;
import com.springcloud.microservice.security.service.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@RequestMapping(value = IRequestPath.SECURITY_REST_ENDPOINT)
public class SecurityController {

	private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
	@Autowired AuthenticationManager authenticationManager;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired JwtUtils jwtUtils;
	
	@PostMapping(value = IRequestPath.USER_AUTHENTICATION)
	public ResponseEntity<?> handleInternalRequestForUserAuthentication(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserAuthentication ... ");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		List<String> roles = customUserDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponseDto(jwt, customUserDetails.getId(), customUserDetails.getUsername(),
				customUserDetails.getEmail(), roles, customUserDetails.getPhone()));
	}
	
	@PostMapping(value = IRequestPath.USER_REGISTRATION)
	public ResponseEntity<?> handleInternalRequestForUserRegistration(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserRegistration ... ");
		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
	}
}
