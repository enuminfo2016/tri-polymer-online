package com.enuminfo.cloud.rest.dto;

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
public class CategoryDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	private String fullName;
	private String fullDescription;
	private String htmlValue;
}
