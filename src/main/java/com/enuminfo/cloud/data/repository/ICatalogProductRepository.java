package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.CatalogProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogProductRepository extends PagingAndSortingRepository<CatalogProduct, Long> {
	Iterable<CatalogProduct> findByCatalog(Long catalog);

	CatalogProduct findByProduct(Long product);
}
