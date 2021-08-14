/**
 * 
 */
package com.springcloud.microservice.service;

import com.springcloud.microservice.rest.dto.UserDto;

/**
 * @author SIVA KUMAR
 */
public interface IUserService {

	boolean save(UserDto dto);
	
	UserDto getDetailByUsernameAndPassword(String username, String password);
}
