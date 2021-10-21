/**
 * 
 */
package com.enuminfo.cloud.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;

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
@Entity
@Table(name = TableType.USER_ORDER)
public class UserOrderedPayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.USER_ORDER)
	private Long userOrder;
	
	@Column(name = ColumnType.CART_VALUE)
	private Double cartValue;
	
	@Column(name = ColumnType.SHIP_VALUE)
	private Double shipValue;
	
	@Column(name = ColumnType.TAX_VALUE)
	private Double taxValue;
	
	@Column(name = ColumnType.PAYMENT_METHOD)
	private String paymentMethod;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(Long userOrder) {
		this.userOrder = userOrder;
	}

	public Double getCartValue() {
		return cartValue;
	}

	public void setCartValue(Double cartValue) {
		this.cartValue = cartValue;
	}

	public Double getShipValue() {
		return shipValue;
	}

	public void setShipValue(Double shipValue) {
		this.shipValue = shipValue;
	}

	public Double getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(Double taxValue) {
		this.taxValue = taxValue;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
