/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.Product;
import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.model.UserOrder;
import com.springcloud.microservice.data.model.UserOrderedItem;
import com.springcloud.microservice.data.repository.IDeliveryLocationRepository;
import com.springcloud.microservice.data.repository.IProductRepository;
import com.springcloud.microservice.data.repository.IUserDetailRepository;
import com.springcloud.microservice.data.repository.IUserOrderDeliveryLocationRepository;
import com.springcloud.microservice.data.repository.IUserOrderRepository;
import com.springcloud.microservice.data.repository.IUserOrderedItemRepository;
import com.springcloud.microservice.rest.dto.UserOrderDto;
import com.springcloud.microservice.rest.dto.UserOrderedItemDto;
import com.springcloud.microservice.service.IUserOrderService;

/**
 * @author SIVA KUMAR
 */
@Service
public class UserOrderService implements IUserOrderService {
	
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IProductRepository productRepository;
	@Autowired IDeliveryLocationRepository deliveryLocationRepository;
	@Autowired IUserOrderDeliveryLocationRepository userOrderDeliveryLocationRepository;

	@Override
	public void saveDraftedUserOrder(UserOrderDto dto) throws ParseException {
		User user = userDetailRepository.findByPhone(dto.getMobile()).get();
		UserOrder userOrder = new UserOrder();
		userOrder.setUser(user.getId());
		userOrder.setStatus(dto.getStatus());
		userOrder.setDeliveryStatus(dto.getDeliveryStatus());
		userOrder.setDraftedDate(new Date());
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);
		for (Iterator<UserOrderedItemDto> iterator = dto.getOrderedItems().iterator(); iterator.hasNext();) {
			UserOrderedItemDto dtoUserorderedItem = iterator.next();
			UserOrderedItem userOrderedItem = new UserOrderedItem();
			userOrderedItem.setUserOrder(savedUserOrder.getId());
			Optional<Product> optionalProduct = productRepository.findByName(dtoUserorderedItem.getProduct());
			Product product = (optionalProduct.isPresent() ? optionalProduct.get() : null);
			if (product != null)
				userOrderedItem.setProduct(product.getId());
			userOrderedItem.setQuantity(dtoUserorderedItem.getQuantity());
			userOrderedItem.setPrice(dtoUserorderedItem.getPrice());
			userOrderedItemRepository.save(userOrderedItem);
		}
	}

	@Override
	public List<UserOrderDto> getAllUserOrders(String status) {
		List<UserOrderDto> dtoUserOrders = new ArrayList<>();
		return dtoUserOrders;
	}

	@Override
	public List<UserOrderDto> getUserConfirmedOrders(long user, String status, String deliveryStatus) {
		List<UserOrderDto> dtoUserOrders = new ArrayList<>();
		return dtoUserOrders;
	}

	@Override
	public void confirmedUserOrder(UserOrderDto dto) throws ParseException {
		
	}

	@Override
	public List<UserOrderedItemDto> getAllUserOrderedItemsByProduct(String product) {
		List<UserOrderedItemDto> dtoUserOrderedItems = new ArrayList<>();
		return dtoUserOrderedItems;
	}

	@Override
	public List<UserOrderDto> getUserOrderByStatus(long user, String status) {
		List<UserOrderDto> dtoUserOrders = new ArrayList<>();
		return dtoUserOrders;
	}

	@Override
	public void cancelledUserOrder(UserOrderDto dto) throws ParseException {
		
	}
}
