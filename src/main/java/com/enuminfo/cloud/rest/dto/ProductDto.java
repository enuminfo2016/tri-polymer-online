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
public class ProductDto extends BaseDto {
	private String name;
	private String description;
	private String category;
}
