package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {
	Optional<Country> findByName(String name);

	Iterable<Country> findByStatus(Boolean status);
}
