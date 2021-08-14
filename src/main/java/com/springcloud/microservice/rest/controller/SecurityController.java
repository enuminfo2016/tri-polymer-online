/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.RequestPath;
import com.springcloud.microservice.rest.dto.MessageResponseDto;
import com.springcloud.microservice.rest.dto.UserDto;
import com.springcloud.microservice.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.SECURITY_REST_ENDPOINT)
public class SecurityController {

	private static final Logger log = LoggerFactory.getLogger(SecurityController.class);
	@Autowired IUserService userService;
	
	@PostMapping(value = RequestPath.USER_AUTHENTICATION)
	public ResponseEntity<?> handleInternalRequestForUserAuthentication(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserAuthentication ... ");
		MessageResponseDto messageResponseDto = null;
		UserDto userDto = userService.getDetailByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		if (userDto.isLoggedIn()) {
			messageResponseDto = new MessageResponseDto("User logged successfully!");
			messageResponseDto.setObject(userDto);
		} else {
			messageResponseDto = new MessageResponseDto("User unable to logged!");
		}
		return ResponseEntity.ok(messageResponseDto);
	}
	
	@PostMapping(value = RequestPath.USER_REGISTRATION)
	public ResponseEntity<?> handleInternalRequestForUserRegistration(@Valid @RequestBody UserDto dto) {
		log.info("### SecurityController.handleInternalRequestForUserRegistration ... ");
		MessageResponseDto messageResponseDto = null;
		boolean result = userService.save(dto);
		if (result) {
			messageResponseDto = new MessageResponseDto("User registered successfully!");
		} else {
			messageResponseDto = new MessageResponseDto("User unable to registered!");
		}
		return ResponseEntity.ok(messageResponseDto);
	}
}
