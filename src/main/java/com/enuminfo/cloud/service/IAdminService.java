package com.enuminfo.cloud.service;

import com.enuminfo.cloud.rest.dto.CategoryDto;

import reactor.core.publisher.Flux;

public interface IAdminService {
	Flux<CategoryDto> getAllCategories();
}
