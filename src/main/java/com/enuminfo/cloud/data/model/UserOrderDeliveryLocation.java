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
@Table(name = TableType.USER_ORDERED_DELIVERY_LOCATION)
public class UserOrderDeliveryLocation implements Serializable {

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

	@Column(name = ColumnType.DELIVERY_LOCATION)
	private Long deliveryLocation;

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

	public Long getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(Long deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
}
