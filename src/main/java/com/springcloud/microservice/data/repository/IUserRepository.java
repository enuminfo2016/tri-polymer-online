/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.User;

/**
 * @author SIVA KUMAR
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	User findByEmail(String email);
	User findByPhone(Long phone);
}
