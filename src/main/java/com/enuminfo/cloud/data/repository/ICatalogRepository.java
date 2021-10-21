/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.Catalog;

/**
 * @author SIVA KUMAR
 */
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Long> {

	Optional<Catalog> findByStartDateAndEndDate(String startDate, String endDate);

	Iterable<Catalog> findByStatus(Boolean status);
}
