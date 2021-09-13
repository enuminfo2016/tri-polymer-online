/**
 *
 */
package com.springcloud.microservice.data.model;

import com.springcloud.microservice.data.ColumnType;
import com.springcloud.microservice.data.TableType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = TableType.COUNTRY)
public class Country extends Base {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ColumnType.NAME)
	private String name;

	@Column(name = ColumnType.ISO)
	private String iso;

	@Column(name = ColumnType.ISD)
	private String isd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIsd() {
		return isd;
	}

	public void setIsd(String isd) {
		this.isd = isd;
	}
}
