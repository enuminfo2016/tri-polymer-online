/**
 * 
 */
package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.cloud.data.model.CatalogProduct;

/**
 * @author SIVA KUMAR
 */
public interface ICatalogProductRepository extends PagingAndSortingRepository<CatalogProduct, Long> {

	Iterable<CatalogProduct> findByCatalog(Long catalog);
	
	CatalogProduct findByProduct(Long product);
}
