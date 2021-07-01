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

	void saveDraftedUserOrder(UserOrderDto dto) throws ParseException;
	
	List<UserOrderDto> getAllUserOrders(String status);
	
	List<UserOrderDto> getUserConfirmedOrders(long user, String status, String deliveryStatus);
	
	void confirmedUserOrder(UserOrderDto dto) throws ParseException;
	
	List<UserOrderedItemDto> getAllUserOrderedItemsByProduct(String product);
	
	List<UserOrderDto> getUserOrderByStatus(long user, String status);
	
	void cancelledUserOrder(UserOrderDto dto) throws ParseException;
}
