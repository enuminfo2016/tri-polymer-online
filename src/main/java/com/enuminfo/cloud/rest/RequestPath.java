package com.enuminfo.cloud.rest;

public class RequestPath {
	private static RequestPath instance = null;
	private RequestPath() { }
	public static RequestPath getInstance() {
		if (instance == null)
			instance = new RequestPath();
		return instance;
	}
	
	public static final String REST_ENDPOINT = "/api";

	public static final String USER_AUTHENTICATION = "/user/authentication";
    public static final String USER_REGISTRATION = "/user/registration";
    
    public static final String SAVE_USER_DRAFTED_ITEMS = "/user/draftedItems";
    public static final String USER_DRAFTED_ITEMS = "/user/draftedItems/{value}";
    public static final String SAVE_USER_ORDERED_ITEMS = "/user/orderedItems";
    public static final String USER_ORDERED_ITEMS = "/user/orderedItems/{value}";
    public static final String USER_CANCELLED_ITEMS = "/user/cancelledItems";    
    public static final String USER_SELECTED_PRODUCT_ITEMS = "/user/selectedProductItemsById/{value}";
    
    public static final String COUNTRIES = "/countries";
    public static final String STATES_BY_COUNTRY = "/statesByCountry/{value}";
    public static final String CITIES_BY_STATE = "/citiesByState/{value}";
    public static final String LOCATIONS_BY_CITY = "/locationsByCity/{value}";
    public static final String PIN_BY_LOCATION = "/pinByLocation/{value}";
    
    public static final String DELIVERY_LOCATIONS = "/deliveryLocations";
    public static final String DELIVERY_LOCATIONS_BY_LOCATION = "/deliveryLocationsByLocation/{value}";
    
    public static final String CATALOG_PRODUCTS_BY_CATEGORY = "/catalogProductsByCategory/{value}";
    public static final String CATALOG_PRODUCTS = "/catalogProducts";
    public static final String CATALOG_PRODUCT_DETAIL_BY_PRODUCT = "/catalogProductDetailByProduct/{value}";
    
    public static final String CATEGORIES = "/category";
    public static final String PRODUCTS = "/product";
    public static final String PRODUCTS_BY_CATEGORY = "/productByCategory/{value}";
    public static final String CATALOG = "/catalog";
}
