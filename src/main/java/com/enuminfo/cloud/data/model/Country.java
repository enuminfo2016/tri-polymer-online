/**
 *
 */
package com.enuminfo.cloud.data.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;

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
