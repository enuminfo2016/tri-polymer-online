/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.IRequestPath;
import com.springcloud.microservice.rest.dto.MessageResponseDto;
import com.springcloud.microservice.rest.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = IRequestPath.SECURITY_REST_ENDPOINT)
public class SecurityController {

	private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
	
	@PostMapping(value = IRequestPath.USER_AUTHENTICATION)
	public ResponseEntity<?> handleInternalRequestForUserAuthentication(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserAuthentication ... ");
		return ResponseEntity.ok(new MessageResponseDto("User logged successfully!"));
	}
	
	@PostMapping(value = IRequestPath.USER_REGISTRATION)
	public ResponseEntity<?> handleInternalRequestForUserRegistration(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserRegistration ... ");
		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
	}
}
