/**
 * 
 */
package com.springcloud.microservice.service;

import java.text.ParseException;
import java.util.List;

import com.springcloud.microservice.rest.dto.UserOrderDto;
import com.springcloud.microservice.rest.dto.UserOrderedItemDto;

/**
 * @author SIVA KUMAR
 */
public interface IUserOrderService {

	void saveUserOrder(UserOrderDto dto) throws ParseException;
	
	List<UserOrderDto> getAllUserOrders(String status);
	
	List<UserOrderDto> getUserConfirmedOrders(long user, String status, String deliveryStatus);
	
	List<UserOrderedItemDto> getAllUserOrderedItemsByProduct(String product);
	
	List<UserOrderDto> getUserOrderByStatus(long user, String status);
}
