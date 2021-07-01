/**
 * 
 */
package com.springcloud.microservice.service;

import com.springcloud.microservice.rest.dto.UserDto;

/**
 * @author SIVA KUMAR
 */
public interface IUserService {

	void save(UserDto dto);
}
