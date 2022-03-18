package com.enuminfo.cloud.service.impl;

import org.springframework.stereotype.Service;

import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

import reactor.core.publisher.Flux;

@Service
public class AdminService implements IAdminService {

	@Override
	public Flux<CategoryDto> getAllCategories() {
		return null;
	}
}
