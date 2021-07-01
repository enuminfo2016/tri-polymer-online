/**
 * 
 */
package com.springcloud.microservice.rest;

/**
 * @author SIVA KUMAR
 */
public interface IRequestPath {
	
	String SECURED_REST_ENDPOINT = "/api/secured/v1";
	String SECURITY_REST_ENDPOINT = "/api/security";
	String UNSECURED_REST_ENDPOINT = "/api/v1";

	String USER_AUTHENTICATION = "/user/authentication";
    String USER_REGISTRATION = "/user/registration";
    
    String SAVE_USER_DRAFTED_ITEMS = "/user/draftedItems";
    String USER_DRAFTED_ITEMS = "/user/draftedItems/{value}";
    String SAVE_USER_ORDERED_ITEMS = "/user/orderedItems";
    String USER_ORDERED_ITEMS = "/user/orderedItems/{value}";
    String USER_CANCELLED_ITEMS = "/user/cancelledItems";    
    String USER_SELECTED_PRODUCT_ITEMS = "/user/selectedProductItemsById/{value}";
    
    String COUNTRIES = "/countries";
    String STATES_BY_COUNTRY = "/statesByCountry/{value}";
    String CITIES_BY_STATE = "/citiesByState/{value}";
    String LOCATIONS_BY_CITY = "/locationsByCity/{value}";
    String PIN_BY_LOCATION = "/pinByLocation/{value}";
    
    String DELIVERY_LOCATIONS = "/deliveryLocations";
    String DELIVERY_LOCATIONS_BY_LOCATION = "/deliveryLocationsByLocation/{value}";
    
    String CATALOG_PRODUCTS_BY_CATEGORY = "/catalogProductsByCategory/{value}";
    String CATALOG_PRODUCTS = "/catalogProducts";
    
    String CATEGORIES = "/category";
    String PRODUCTS = "/product";
    String PRODUCTS_BY_CATEGORY = "/productByCategory/{value}";
    String CATALOG = "/catalog";
}
