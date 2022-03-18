package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.CatalogProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICatalogProductRepository extends ReactiveCrudRepository<CatalogProduct, Long> {
	Flux<CatalogProduct> findByCatalog(Long catalog);
	Mono<CatalogProduct> findByProduct(Long product);
}
