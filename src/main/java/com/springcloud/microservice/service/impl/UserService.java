/**
 * 
 */
package com.springcloud.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.repository.IUserRepository;
import com.springcloud.microservice.rest.dto.UserDto;
import com.springcloud.microservice.service.IUserService;

/**
 * @author SIVA KUMAR
 */
@Service
public class UserService implements IUserService {
	
	@Autowired IUserRepository userRepository;

	@Override
	public boolean save(UserDto dto) {
		return Boolean.FALSE;
	}

	@Override
	public UserDto getDetailByUsernameAndPassword(String username, String password) {
		UserDto userDto = new UserDto();
		return userDto;
	}
}
