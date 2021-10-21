/**
 * 
 */
package com.enuminfo.cloud.service;

import java.util.List;

import com.enuminfo.cloud.rest.dto.CategoryDto;

/**
 * @author SIVA KUMAR
 */
public interface IAdminService {
	
	List<CategoryDto> getAllCategories();
}
