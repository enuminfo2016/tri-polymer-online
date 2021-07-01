/**
 * 
 */
package com.springcloud.microservice.data.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.Catalog;

/**
 * @author SIVA KUMAR
 */
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Long> {

	@Query("SELECT model FROM Catalog model WHERE model.startDate BETWEEN ?1 AND ?2 AND model.endDate BETWEEN ?1 AND ?2")
	Optional<Catalog> findByDatesBetween(Date startDate, Date endDate);

	Iterable<Catalog> findByStatus(Boolean status);
}
