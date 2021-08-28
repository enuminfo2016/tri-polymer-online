/**
 * 
 */
package com.springcloud.microservice.data;

/**
 * @author SIVA KUMAR
 */
public class ColumnType {
	
	private static ColumnType instance = null;
	private ColumnType() { }
	public static ColumnType getInstance() {
		if (instance == null)
			instance = new ColumnType();
		return instance;
	}

	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String CREATED_BY = "created_by";
	public static final String CREATED_ON = "created_on";
	public static final String UPDATED_BY = "updated_by";
	public static final String UPDATED_ON = "updated_on";

	public static final String PASSWORD = "password";
	public static final String ACCESS = "access";
	public static final String NAME = "name";
	public static final String USERNAME = "username";
	
	public static final String FIRST_NAME = "first_name";
	public static final String MIDDLE_NAME = "middle_name";
	public static final String LAST_NAME = "last_name";

	public static final String VALUE1 = "value_1";
	public static final String VALUE2 = "value_2";
	public static final String VALUE3 = "value_3";

	public static final String ISD = "isd";
	public static final String ISO = "iso";
	public static final String STATE = "state";
	public static final String CITY = "city";
	public static final String COUNTRY = "country_id";
	public static final String PIN = "pin";
	public static final String LOCATION = "location_id";

	public static final String DESCRIPTION = "description";
	public static final String PRICE = "price";
	public static final String CATEGORY = "category_id";
	public static final String PRODUCT = "product_id";
	public static final String CATALOG = "catalog_id";
	public static final String START = "start_date";
	public static final String END = "end_date";

	public static final String PHONE = "phone_number";
	public static final String EMAIL = "email_address";
	public static final String QUANTITY = "quantity";

	public static final String USER_ORDER = "user_order_id";
	public static final String DELIVERY_LOCATION = "delivery_location_id";

	public static final String DRAFTED_DATE = "drafted_date";
	public static final String ORDERED_DATE = "ordered_date";
	public static final String CANCELLED_DATE = "cancelled_date";
	public static final String DELIVERY_STATUS = "delivery_status";
	public static final String USER = "user_id";
	public static final String IMG_DATA = "img_data";
	public static final String IMG_NAME = "img_name";
	public static final String IMG_TYPE = "img_type";
	public static final String MAIN_IMG = "main_img";
}
