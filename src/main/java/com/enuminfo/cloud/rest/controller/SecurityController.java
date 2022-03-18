package com.enuminfo.cloud.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.cloud.rest.RequestPath;

@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.REST_ENDPOINT)
public class SecurityController {	
}
