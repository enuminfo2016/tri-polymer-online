package com.enuminfo.cloud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.cloud.rest.RequestPath;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.service.IAdminService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.REST_ENDPOINT)
public class AdminController {
	@Autowired IAdminService adminService;

	@GetMapping(value = RequestPath.CATEGORIES)
	public ResponseEntity<Flux<CategoryDto>> handleInternalRequestForAllCategories() {
		log.info("### AdminController.handleInternalRequestForAllCategories ... ");
		Flux<CategoryDto> fluxCategoryDtos = adminService.getAllCategories();
        HttpStatus httpStatus = (fluxCategoryDtos != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxCategoryDtos, httpStatus);
	}
}
