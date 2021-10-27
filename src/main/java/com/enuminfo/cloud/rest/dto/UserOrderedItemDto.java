package com.enuminfo.cloud.rest.dto;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserOrderedItemDto implements Serializable {
	private int id;
	private String product;
	private String description;
	private String category;
	private double quantity;
	private double price;
}
