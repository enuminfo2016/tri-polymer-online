package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.DeliveryLocation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Long> {
	Iterable<DeliveryLocation> findByLocation(Long location);

	Optional<DeliveryLocation> findByStreetAndLandmark1AndLandmark2AndLocation(String street, String landmark1, String landmark2, Long location);
}
