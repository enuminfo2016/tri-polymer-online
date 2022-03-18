package com.enuminfo.cloud.rest.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserOrderDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String country;
	private String firstName;
	private String middleName;
	private String lastName;
	private String companyName;
	private String addrValue1;
	private String addrValue2;
	private String addrValue3;
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
