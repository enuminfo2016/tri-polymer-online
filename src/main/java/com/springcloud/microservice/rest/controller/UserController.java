/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.IRequestPath;
import com.springcloud.microservice.rest.dto.UserOrderDto;
import com.springcloud.microservice.rest.dto.UserOrderedItemDto;
import com.springcloud.microservice.service.IUserOrderService;
import com.springcloud.microservice.service.IUserService;
import com.springcloud.microservice.util.StatusTypeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = IRequestPath.SECURED_REST_ENDPOINT)
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired IUserService userService;
    @Autowired IUserOrderService userOrderService;

	@GetMapping(value = IRequestPath.USER_DRAFTED_ITEMS)
	public List<UserOrderDto> handleInternalRequestForUserDraftedItems(@PathVariable long value) {
		return userOrderService.getUserOrderByStatus(value, StatusTypeEnum.DRAFTED.toString());
	}

	@PostMapping(value = IRequestPath.SAVE_USER_ORDERED_ITEMS)
	public void handleInternalRequestForSaveUserOrderedIteams(@RequestBody UserOrderDto[] dtos) {
		for (UserOrderDto dto : dtos) {
			dto.setStatus(StatusTypeEnum.ORDERED.toString());
			dto.setDeliveryStatus(StatusTypeEnum.DELIVERY_SCHEDULED.toString());
			try {
				log.info("### UserController.handleInternalRequestForSaveUserOrderedIteams ... ");
				userOrderService.confirmedUserOrder(dto);
			} catch (ParseException e) {
				log.error("### UserController.handleInternalRequestForSaveUserOrderedIteams ... {}", e.getMessage());
			}
		}
	}

	@GetMapping(value = IRequestPath.USER_ORDERED_ITEMS)
	public List<UserOrderDto> handleInternalRequestForUserOrderedItems(@PathVariable long value) {
		log.info("### UserController.handleInternalRequestForUserOrderedItems ... ");
		return userOrderService.getUserConfirmedOrders(value, StatusTypeEnum.ORDERED.toString(), StatusTypeEnum.DELIVERY_SCHEDULED.toString());
	}

	@PostMapping(value = IRequestPath.USER_CANCELLED_ITEMS)
	public void handleInternalRequestForCancelledUserOrderedItems(@RequestBody UserOrderDto[] dtos) {
		for (UserOrderDto dto : dtos) {
			dto.setStatus(StatusTypeEnum.CANCELLED.toString());
			dto.setDeliveryStatus(StatusTypeEnum.DELIVERY_REVERTED.toString());
			try {
				log.info("### UserController.handleInternalRequestForCancelledUserOrderedItems ... ");
				userOrderService.cancelledUserOrder(dto);
			} catch (ParseException e) {
				log.error("### UserController.handleInternalRequestForCancelledUserOrderedItems ... {}", e.getMessage());
			}
		}
	}

	@GetMapping(value = IRequestPath.USER_SELECTED_PRODUCT_ITEMS)
	public List<UserOrderedItemDto> handleInternalRequestForUserOrderedItemsByProductId(@PathVariable String value) {
		log.info("### UserController.handleInternalRequestForUserOrderedItemsByProductId ... ");
		return userOrderService.getAllUserOrderedItemsByProduct(value);
	}
}
