/**
 * 
 */
package com.springcloud.microservice.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springcloud.microservice.data.ColumnType;
import com.springcloud.microservice.data.TableType;

/**
 * @author SIVA KUMAR
 */
@Entity
@Table(name = TableType.DELIVERY_LOCATION)
public class DeliveryLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.VALUE1)
	private String street;

	@Column(name = ColumnType.VALUE2)
	private String landmark1;

	@Column(name = ColumnType.VALUE3)
	private String landmark2;

	@Column(name = ColumnType.LOCATION)
	private Long location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark1() {
		return landmark1;
	}

	public void setLandmark1(String landmark1) {
		this.landmark1 = landmark1;
	}

	public String getLandmark2() {
		return landmark2;
	}

	public void setLandmark2(String landmark2) {
		this.landmark2 = landmark2;
	}

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}
}
