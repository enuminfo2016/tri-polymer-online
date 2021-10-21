/**
 * 
 */
package com.enuminfo.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.cloud.data.repository.ICategoryRepository;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

/**
 * @author SIVA KUMAR
 */
@Service
public class AdminService implements IAdminService {
	
	@Autowired ICategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> dtos = new ArrayList<>();
		categoryRepository.findByStatus(Boolean.TRUE).forEach(model -> {
			CategoryDto dto = new CategoryDto();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setDescription(model.getDescription());
			dtos.add(dto);
		});
		return dtos;
	}	
}
