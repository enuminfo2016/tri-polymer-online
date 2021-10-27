/**
 * 
 */
package com.enuminfo.cloud.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.cloud.rest.RequestPath;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.SECURED_REST_ENDPOINT)
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired IAdminService adminService;

	@GetMapping(value = RequestPath.CATEGORIES)
	public List<CategoryDto> handleInternalRequestForAllCategories() {
		log.info("### AdminController.handleInternalRequestForAllCategories ... ");
		return adminService.getAllCategories();
	}
}
