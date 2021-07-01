/**
 * 
 */
package com.springcloud.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.repository.IUserRepository;
import com.springcloud.microservice.rest.dto.UserDto;
import com.springcloud.microservice.service.IUserService;
import com.springcloud.microservice.util.AccessEnum;
import com.springcloud.microservice.util.StringUtil;

/**
 * @author SIVA KUMAR
 */
@Service
public class UserService implements IUserService {
	
	@Autowired IUserRepository userRepository;

	@Override
	public void save(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(StringUtil.getInstance().generatePassword());
		user.setAccess(AccessEnum.USER.name());
		user.setPhone(dto.getPhone());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMiddleName(dto.getMiddleName());
		userRepository.save(user);
	}
}
