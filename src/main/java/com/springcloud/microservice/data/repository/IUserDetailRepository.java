/**
 * 
 */
package com.springcloud.microservice.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.model.UserDetail;

/**
 * @author SIVA KUMAR
 */
public interface IUserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {

	Optional<User> findByPhone(Long phone);
}
