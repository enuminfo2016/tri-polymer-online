/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.UserDetail;

/**
 * @author SIVA KUMAR
 */
public interface IUserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {

	Optional<UserDetail> findByPhone(Long phone);
	Optional<UserDetail> findByPhoneAndEmail(Long phone, String email);
}
