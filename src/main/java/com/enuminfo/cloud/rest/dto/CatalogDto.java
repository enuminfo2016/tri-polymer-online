package com.enuminfo.cloud.rest.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@SuppressWarnings("serial")
public class CatalogDto extends BaseDto {
	private String name;
	private List<CatalogProductDto> products;
	private String start;
	private String end;
}
