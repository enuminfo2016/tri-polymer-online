package com.enuminfo.cloud.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.cloud.data.model.Category;
import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired ICategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> dtos = new ArrayList<>();
		List<Category> models = categoryRepository.findByStatus(Boolean.TRUE);
		models.stream().forEach(model ->  {
			CategoryDto dto = new CategoryDto();
			dto.setId(model.getId());
			dto.setFullName(model.getName());
			dto.setFullDescription(model.getDescription());
			dto.setLastModifiedBy(model.getUpdatedBy());
			dto.setLastModifiedOn(DateFormat.getDateInstance().format(model.getUpdatedOn()));
			dtos.add(dto);
		});
		return dtos;
	}
}
