/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.util.Optional;

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
	public boolean save(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(StringUtil.getInstance().generatePassword());
		user.setAccess(AccessEnum.USER.name());
		user.setPhone(dto.getPhone());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMiddleName(dto.getMiddleName());
		try {
			userRepository.save(user);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}

	@Override
	public UserDto getDetailByUsernameAndPassword(String username, String password) {
		UserDto userDto = new UserDto();
		Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setAccess(user.getAccess());
			userDto.setPhone(user.getPhone());
			userDto.setFirstName(user.getFirstName());
			userDto.setMiddleName(user.getMiddleName());
			userDto.setLastName(user.getLastName());
			userDto.setLoggedIn(Boolean.TRUE);
		}
		return userDto;
	}
}
