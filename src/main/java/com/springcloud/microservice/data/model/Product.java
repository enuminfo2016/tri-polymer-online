/**
 * 
 */
package com.springcloud.microservice.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.springcloud.microservice.data.IColumnType;
import com.springcloud.microservice.data.ITableType;

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
@Table(name = ITableType.PRODUCT)
public class Product extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = IColumnType.NAME)
	private String name;
	
	@Column(name = IColumnType.DESCRIPTION)
	private String description;

	@Column(name = IColumnType.CATEGORY)
	private Long category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
}
