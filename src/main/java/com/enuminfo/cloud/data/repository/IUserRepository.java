/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.User;

/**
 * @author SIVA KUMAR
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);
}
