/**
 * 
 */
package com.enuminfo.cloud.rest.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SIVA KUMAR
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserOrderDto implements Serializable {

	/**
	 * 
	 */
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
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddrValue1() {
		return addrValue1;
	}

	public void setAddrValue1(String addrValue1) {
		this.addrValue1 = addrValue1;
	}

	public String getAddrValue2() {
		return addrValue2;
	}

	public void setAddrValue2(String addrValue2) {
		this.addrValue2 = addrValue2;
	}

	public String getAddrValue3() {
		return addrValue3;
	}

	public void setAddrValue3(String addrValue3) {
		this.addrValue3 = addrValue3;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean isCreateAnAccount() {
		return createAnAccount;
	}

	public void setCreateAnAccount(boolean createAnAccount) {
		this.createAnAccount = createAnAccount;
	}

	public boolean isShipToDifferent() {
		return shipToDifferent;
	}

	public void setShipToDifferent(boolean shipToDifferent) {
		this.shipToDifferent = shipToDifferent;
	}

	public List<UserOrderedItemDto> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<UserOrderedItemDto> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public double getShipValue() {
		return shipValue;
	}

	public void setShipValue(double shipValue) {
		this.shipValue = shipValue;
	}

	public double getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(double taxValue) {
		this.taxValue = taxValue;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
