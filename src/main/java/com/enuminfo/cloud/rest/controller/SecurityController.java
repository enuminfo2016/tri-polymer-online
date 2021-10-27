package com.enuminfo.cloud.rest.controller;

import com.enuminfo.cloud.rest.RequestPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.SECURITY_REST_ENDPOINT)
public class SecurityController {
}
