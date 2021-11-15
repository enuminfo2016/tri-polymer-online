package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {
	Optional<Country> findByName(String name);
	Iterable<Country> findByStatus(Boolean status);
}
