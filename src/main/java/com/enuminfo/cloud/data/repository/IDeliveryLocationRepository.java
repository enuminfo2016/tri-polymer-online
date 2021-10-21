/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.DeliveryLocation;

/**
 * @author SIVA KUMAR
 */
public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Long> {

	Iterable<DeliveryLocation> findByLocation(Long location);
	Optional<DeliveryLocation> findByStreetAndLandmark1AndLandmark2AndLocation(String street, String landmark1, String landmark2, Long location);
}
