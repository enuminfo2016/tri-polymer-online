/**
 *
 */
package com.springcloud.microservice.data.model;

import com.springcloud.microservice.data.ColumnType;
import com.springcloud.microservice.data.TableType;
import lombok.*;

import javax.persistence.*;

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
@Table(name = TableType.LOCATION)
public class Location extends Base {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ColumnType.NAME)
	private String name;

	@Column(name = ColumnType.PIN)
	private Long pin;

	@Column(name = ColumnType.CITY)
	private String city;

	@Column(name = ColumnType.STATE)
	private String state;

	@Column(name = ColumnType.COUNTRY)
	private Long country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}
}
