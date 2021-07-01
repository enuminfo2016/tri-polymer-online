/**
 * 
 */
package com.springcloud.microservice.data;

/**
 * @author SIVA KUMAR
 */
public interface ITableType {

	String USER = "user_detail";
	String ACCESS = "access_detail";

	String COUNTRY = "country_detail";
	String LOCATION = "location_detail";
	String DELIVERY_LOCATION = "delivery_location_detail";

	String CATEGORY = "category_detail";
	String PRODUCT = "product_detail";

	String CATALOG = "catalog_detail";
	String CATALOG_PRODUCT = "catalog_product_detail";

	String USER_ORDER = "user_order_detail";
	String USER_ORDERED_ITEM = "user_ordered_item_detail";
	String USER_ORDERED_DELIVERY_LOCATION = "user_ordered_delivery_location_detail";
}
