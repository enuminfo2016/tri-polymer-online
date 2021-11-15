package com.enuminfo.cloud.service;

import com.enuminfo.cloud.rest.dto.CategoryDto;

import java.util.List;

public interface IAdminService {
	List<CategoryDto> getAllCategories();
}
