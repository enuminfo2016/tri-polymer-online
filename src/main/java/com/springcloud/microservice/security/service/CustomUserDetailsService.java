/**
 * 
 */
package com.springcloud.microservice.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.repository.IUserRepository;

/**
 * @author SIVA KUMAR
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired IUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		return CustomUserDetails.build(user);
	}
}
