package com.enuminfo.cloud.rest.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CatalogProductDto implements Serializable {
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
