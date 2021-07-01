/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.DeliveryLocation;

/**
 * @author SIVA KUMAR
 */
public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Long> {

	Iterable<DeliveryLocation> findByLocation(Long location);
}
