package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.Catalog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICatalogRepository extends ReactiveCrudRepository<Catalog, Long> {
	Mono<Catalog> findByStartDateAndEndDate(String startDate, String endDate);
	Flux<Catalog> findByStatus(Boolean status);
}
