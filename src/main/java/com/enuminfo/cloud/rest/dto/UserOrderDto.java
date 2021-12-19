package com.enuminfo.cloud.rest.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@SuppressWarnings("serial")
public class UserOrderDto implements Serializable {
	private String country;
	private String firstName;
	private String middleName;
	private String lastName;
	private String companyName;
	private String adderValue1;
	private String adderValue2;
	private String adderValue3;
	private String state;
	private String city;
	private long pin;
	private String email;
	private long phone;
	private boolean createAnAccount;
	private boolean shipToDifferent;
	private List<UserOrderedItemDto> cartProducts;
	private double cartTotal;
	private double shipValue;
	private double taxValue;
	private String payment;
	private String notes;
	private String status;
	private String deliveryStatus;
	private String location;
}
