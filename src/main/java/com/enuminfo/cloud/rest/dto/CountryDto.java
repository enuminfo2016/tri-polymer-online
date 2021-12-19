package com.enuminfo.cloud.rest.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@SuppressWarnings("serial")
public class CountryDto extends BaseDto {
	private String name;
	private String iso;
	private String isd;
}
