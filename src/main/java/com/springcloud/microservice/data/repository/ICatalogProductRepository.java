/**
 * 
 */
package com.springcloud.microservice.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcloud.microservice.data.model.CatalogProduct;

/**
 * @author SIVA KUMAR
 */
public interface ICatalogProductRepository extends PagingAndSortingRepository<CatalogProduct, Long> {

	Iterable<CatalogProduct> findByCatalog(Long catalog);
	
	CatalogProduct findByProduct(Long product);
}
