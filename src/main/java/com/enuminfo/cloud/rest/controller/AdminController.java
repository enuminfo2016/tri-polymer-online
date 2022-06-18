package com.enuminfo.cloud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.cloud.rest.RequestPath;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
public class AdminController {
	@Autowired IAdminService adminService;

	@GetMapping(value = RequestPath.REST_ENDPOINT + RequestPath.CATEGORIES)
	public List<CategoryDto> handleInternalRequestForAllCategories() {
		log.info("### AdminController.handleInternalRequestForAllCategories ... ");
        return adminService.getAllCategories();
	}
}
