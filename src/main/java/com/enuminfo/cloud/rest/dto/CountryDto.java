package com.enuminfo.cloud.rest.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CountryDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	private String name;
	private String iso;
	private String isd;
}
