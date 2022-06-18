package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.DeliveryLocation;

@Repository
public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Long> {
	List<DeliveryLocation> findByLocation(Long location);
	DeliveryLocation findByStreetAndLandmark1AndLandmark2AndLocation(String street, String landmark1, String landmark2, Long location);
}
