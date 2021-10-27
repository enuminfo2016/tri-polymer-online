package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ILocationRepository extends PagingAndSortingRepository<Location, Long> {
	Iterable<Location> findByCountry(Long country);

	Iterable<Location> findByState(String state);

	Iterable<Location> findByCity(String city);

	Optional<Location> findByName(String name);
}
