/**
 * 
 */
package com.springcloud.microservice.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.springcloud.microservice.data.ColumnType;
import com.springcloud.microservice.data.TableType;

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
@Table(name = TableType.CATEGORY)
public class Category extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ColumnType.NAME)
	private String name;
	
	@Column(name = ColumnType.DESCRIPTION)
	private String description;

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
}
