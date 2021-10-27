package com.enuminfo.cloud.data.repository;

import com.enuminfo.cloud.data.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
