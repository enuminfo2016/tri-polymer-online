package com.enuminfo.cloud.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.enuminfo.cloud.data.model.ProductImage;

import reactor.core.publisher.Flux;

@Repository
public interface IProductImageRepository extends ReactiveCrudRepository<ProductImage, Long> {
	Flux<ProductImage> findByProductAndMainImg(Long product, Boolean mainImg);
}
