/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.Location;

/**
 * @author SIVA KUMAR
 */
public interface ILocationRepository extends PagingAndSortingRepository<Location, Long> {

	Iterable<Location> findByCountry(Long country);

	Iterable<Location> findByState(String state);

	Iterable<Location> findByCity(String city);

	Optional<Location> findByName(String name);
}
