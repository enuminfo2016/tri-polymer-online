/**
 * 
 */
package com.springcloud.microservice.rest.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SIVA KUMAR
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CatalogProductDto implements Serializable {

	/**
	 * 
	 */
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

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(String outOfStock) {
		this.outOfStock = outOfStock;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
}
