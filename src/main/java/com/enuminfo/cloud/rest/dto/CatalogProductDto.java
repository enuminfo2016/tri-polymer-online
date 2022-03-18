package com.enuminfo.cloud.rest.dto;

import java.io.Serializable;
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
public class CatalogProductDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String title;
	private String description;
	private double newPrice;
	private double oldPrice;
	private String sale;
	private String outOfStock;
	private double quantity;
	private String category;
	private List<String> images;
	private String mainImg;
	private String detailsLink;
}
