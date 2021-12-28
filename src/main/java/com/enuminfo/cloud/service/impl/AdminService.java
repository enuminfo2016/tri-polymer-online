package com.enuminfo.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> categoryDtos = new ArrayList<>();
		categoryRepository.findByStatus(Boolean.TRUE).forEach(model -> {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(model.getId());
			categoryDto.setName(model.getName());
			categoryDto.setDescription(model.getDescription());
			categoryDtos.add(categoryDto);
		});
		return categoryDtos;
	}
}
