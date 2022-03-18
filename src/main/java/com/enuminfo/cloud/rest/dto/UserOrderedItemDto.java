package com.enuminfo.cloud.rest.dto;

import java.io.Serializable;

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
public class UserOrderedItemDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String product;
	private String description;
	private String category;
	private double quantity;
	private double price;
}
