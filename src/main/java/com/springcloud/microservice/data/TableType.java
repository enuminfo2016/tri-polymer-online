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

	public static final String USER = "user";
	public static final String ACCESS = "access";
	public static final String USER_DETAIL = "user_detail";

	public static final String COUNTRY = "country";
	public static final String LOCATION = "location";
	public static final String DELIVERY_LOCATION = "delivery_location";

	public static final String CATEGORY = "category";
	public static final String PRODUCT = "product";

	public static final String CATALOG = "catalog";
	public static final String CATALOG_PRODUCT = "catalog_product";

	public static final String USER_ORDER = "user_order";
	public static final String USER_ORDERED_ITEM = "user_ordered_item";
	public static final String USER_ORDERED_DELIVERY_LOCATION = "user_ordered_delivery_location";
	public static final String PRODUCT_IMAGE = "product_image";
}
