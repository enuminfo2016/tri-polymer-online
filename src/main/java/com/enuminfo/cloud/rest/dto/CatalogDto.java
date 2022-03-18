package com.enuminfo.cloud.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CatalogDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	private String name;
	private List<CatalogProductDto> products;
	private String start;
	private String end;
}
