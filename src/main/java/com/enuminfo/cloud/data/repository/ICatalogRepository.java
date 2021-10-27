package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Catalog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Long> {
	Optional<Catalog> findByStartDateAndEndDate(String startDate, String endDate);
}
