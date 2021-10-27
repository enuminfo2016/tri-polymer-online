/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.Country;

/**
 * @author SIVA KUMAR
 */
public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {

	Optional<Country> findByName(String name);

	Iterable<Country> findByStatus(Boolean status);
}
