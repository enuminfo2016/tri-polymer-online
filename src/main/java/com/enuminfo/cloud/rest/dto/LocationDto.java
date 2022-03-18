package com.enuminfo.cloud.rest.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class LocationDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	private String value1;
	private String value2;
	private String value3;
	private String name;
	private String state;
	private String city;
	private String country;
	private long pin;
}
