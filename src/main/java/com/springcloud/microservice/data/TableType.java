/**
 * 
 */
package com.springcloud.microservice.data;

/**
 * @author SIVA KUMAR
 */
public class TableType {
	
	private static TableType instance = null;
	private TableType() { }
	public static TableType getInstance() {
		if (instance == null)
			instance = new TableType();
		return instance;
	}

	public static final String USER = "user_detail";
	public static final String ACCESS = "access_detail";

	public static final String COUNTRY = "country_detail";
	public static final String LOCATION = "location_detail";
	public static final String DELIVERY_LOCATION = "delivery_location_detail";

	public static final String CATEGORY = "category_detail";
	public static final String PRODUCT = "product_detail";

	public static final String CATALOG = "catalog_detail";
	public static final String CATALOG_PRODUCT = "catalog_product_detail";

	public static final String USER_ORDER = "user_order_detail";
	public static final String USER_ORDERED_ITEM = "user_ordered_item_detail";
	public static final String USER_ORDERED_DELIVERY_LOCATION = "user_ordered_delivery_location_detail";
	public static final String PRODUCT_IMAGES_DETAIL = "product_image_detail";
}
