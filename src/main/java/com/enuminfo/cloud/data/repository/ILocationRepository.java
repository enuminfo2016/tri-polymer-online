package com.enuminfo.cloud.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Location;

@Repository
public interface ILocationRepository extends PagingAndSortingRepository<Location, Long> {
	List<Location> findByCountry(Long country);
	List<Location> findByState(String state);
	List<Location> findByCity(String city);
	Location findByName(String name);
}
