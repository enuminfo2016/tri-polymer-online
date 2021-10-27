/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.UserOrderDeliveryLocation;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderDeliveryLocationRepository
		extends PagingAndSortingRepository<UserOrderDeliveryLocation, Long> {

	Optional<UserOrderDeliveryLocation> findByUserOrder(Long userOrder);
}
