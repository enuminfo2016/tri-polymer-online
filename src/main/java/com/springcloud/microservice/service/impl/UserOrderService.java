/**
 * 
 */
package com.springcloud.microservice.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.microservice.data.model.DeliveryLocation;
import com.springcloud.microservice.data.model.Location;
import com.springcloud.microservice.data.model.Product;
import com.springcloud.microservice.data.model.User;
import com.springcloud.microservice.data.model.UserDetail;
import com.springcloud.microservice.data.model.UserOrder;
import com.springcloud.microservice.data.model.UserOrderDeliveryLocation;
import com.springcloud.microservice.data.model.UserOrderedItem;
import com.springcloud.microservice.data.model.UserOrderedPayment;
import com.springcloud.microservice.data.repository.IDeliveryLocationRepository;
import com.springcloud.microservice.data.repository.ILocationRepository;
import com.springcloud.microservice.data.repository.IProductRepository;
import com.springcloud.microservice.data.repository.IUserDetailRepository;
import com.springcloud.microservice.data.repository.IUserOrderDeliveryLocationRepository;
import com.springcloud.microservice.data.repository.IUserOrderRepository;
import com.springcloud.microservice.data.repository.IUserOrderedItemRepository;
import com.springcloud.microservice.data.repository.IUserOrderedPaymentRepository;
import com.springcloud.microservice.data.repository.IUserRepository;
import com.springcloud.microservice.rest.dto.UserOrderDto;
import com.springcloud.microservice.rest.dto.UserOrderedItemDto;
import com.springcloud.microservice.service.IUserOrderService;
import com.springcloud.microservice.util.AccessEnum;
import com.springcloud.microservice.util.Constants;
import com.springcloud.microservice.util.StatusTypeEnum;
import com.springcloud.microservice.util.StringUtil;

/**
 * @author SIVA KUMAR
 */
@Service
public class UserOrderService implements IUserOrderService {
	
	private static final Logger log = LoggerFactory.getLogger(UserOrderService.class);
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired IProductRepository productRepository;
	@Autowired IDeliveryLocationRepository deliveryLocationRepository;
	@Autowired IUserOrderDeliveryLocationRepository userOrderDeliveryLocationRepository;
	@Autowired IUserRepository userRepository;
	@Autowired IUserOrderedPaymentRepository userOrderedPaymentRepository;
	@Autowired ILocationRepository locationRepository;

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
	public void saveUserOrder(UserOrderDto dto) throws ParseException {
		log.info("### UserOrderService.confirmedUserOrder ... ");
		UserDetail modelUserDetail = null;
		UserOrder modelUserOrder = new UserOrder();
		modelUserOrder.setDeliveryStatus(dto.getDeliveryStatus());
		modelUserOrder.setDraftedDate(new Date());
		modelUserOrder.setOrderedDate(new Date());
		modelUserOrder.setStatus(dto.getStatus());
		
		Optional<UserDetail> optionalUserDetail = userDetailRepository.findByPhoneAndEmail(dto.getPhone(), dto.getEmail());
		if (optionalUserDetail.isPresent()) {
			modelUserDetail = optionalUserDetail.get();
			modelUserOrder.setUser(modelUserDetail.getId());
		} else {
			modelUserDetail = new UserDetail();
			modelUserDetail.setEmail(dto.getEmail());
			modelUserDetail.setFirstName(dto.getFirstName());
			modelUserDetail.setMiddleName(dto.getMiddleName());
			modelUserDetail.setLastName(dto.getLastName());
			modelUserDetail.setPhone(dto.getPhone());
			modelUserDetail.setCreatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			modelUserDetail.setCreatedOn(new Date());
			modelUserDetail.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			modelUserDetail.setUpdatedOn(new Date());
			userDetailRepository.save(modelUserDetail);
		}
		
		if (dto.isCreateAnAccount()) {
			User modelUser = new User();
			modelUser.setUsername(String.valueOf(dto.getPhone()));
			modelUser.setPassword(StringUtil.getInstance().generatePassword());
			modelUser.setAccess(AccessEnum.USER.name());
			userRepository.save(modelUser);
		}
		
		modelUserOrder.setUser(modelUserDetail.getId());
		final UserOrder savedUserOrder = userOrderRepository.save(modelUserOrder);
		
		dto.getCartProducts().forEach(cartProduct -> {
			UserOrderedItem modelUserOrderItem = new UserOrderedItem();
			modelUserOrderItem.setUserOrder(savedUserOrder.getId());
			Optional<Product> optionalProduct = productRepository.findByName(cartProduct.getProduct());
			if (optionalProduct.isPresent())
				modelUserOrderItem.setProduct(optionalProduct.get().getId());
			modelUserOrderItem.setQuantity(cartProduct.getQuantity());
			modelUserOrderItem.setPrice(cartProduct.getPrice());
			userOrderedItemRepository.save(modelUserOrderItem);
		});
		
		if (dto.getStatus().equals(StatusTypeEnum.ORDERED.toString()) && dto.getDeliveryStatus().equals(StatusTypeEnum.DELIVERY_SCHEDULED.toString())) {
			UserOrderedPayment modelUserOrderedPayment = new UserOrderedPayment();
			modelUserOrderedPayment.setUserOrder(savedUserOrder.getId());
			modelUserOrderedPayment.setCartValue(dto.getCartTotal());
			modelUserOrderedPayment.setShipValue(dto.getShipValue());
			modelUserOrderedPayment.setTaxValue(dto.getTaxValue());
			userOrderedPaymentRepository.save(modelUserOrderedPayment);
			
			DeliveryLocation modelDeliveryLocation = null;
			Optional<Location> optionalLocation = locationRepository.findByName(dto.getLocation());
			if (optionalLocation.isPresent()) {
				Location modelLocation = optionalLocation.get();
				Optional<DeliveryLocation> optionalDeliveryLocation = deliveryLocationRepository.findByStreetAndLandmark1AndLandmark2AndLocation(dto.getAddrValue1(), dto.getAddrValue2(), dto.getAddrValue3(), modelLocation.getId());
				if (optionalDeliveryLocation.isPresent()) {
					modelDeliveryLocation = optionalDeliveryLocation.get();
				} else {
					modelDeliveryLocation = new DeliveryLocation();
					modelDeliveryLocation.setUser(modelUserDetail.getId());
					modelDeliveryLocation.setStreet(dto.getAddrValue1());
					modelDeliveryLocation.setLandmark1(dto.getAddrValue2());
					modelDeliveryLocation.setLandmark2(dto.getAddrValue3());
				}
				DeliveryLocation savedDeliveryLocation = deliveryLocationRepository.save(modelDeliveryLocation);
				UserOrderDeliveryLocation modelUserOrderDeliveryLocation = new UserOrderDeliveryLocation();
				modelUserOrderDeliveryLocation.setUserOrder(savedUserOrder.getId());
				modelUserOrderDeliveryLocation.setDeliveryLocation(savedDeliveryLocation.getId());
				userOrderDeliveryLocationRepository.save(modelUserOrderDeliveryLocation);
			}
		}
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
}
