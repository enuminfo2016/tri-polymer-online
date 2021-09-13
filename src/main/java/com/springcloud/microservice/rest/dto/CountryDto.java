/**
 *
 */
package com.springcloud.microservice.rest.dto;

import lombok.*;

/**
 * @author SIVA KUMAR
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CountryDto extends BaseDto {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String iso;
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
