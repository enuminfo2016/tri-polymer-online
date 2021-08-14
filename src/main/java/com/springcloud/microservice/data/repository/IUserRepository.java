/**
 * 
 */
package com.springcloud.microservice.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.User;

/**
 * @author SIVA KUMAR
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);
	Optional<User> findByPhone(Long phone);
}
