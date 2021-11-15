package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.DeliveryLocation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Long> {
}
