/**
 * 
 */
package com.enuminfo.cloud.util;

import java.io.File;

/**
 * @author SIVA KUMAR
 */
public class Constants {
	
	private static final Constants instance = new Constants();
	private Constants() {}
	
	public static Constants getInstance() {
		return instance;
	}

	public static final String SYSTEM_USERNAME = "user.name";
	public static final String UPDATE_LOG = "{} -> {} Updating...";
	public static final String INSERT_LOG = "{} -> {} Inserting...";
	public static final String DELETE_LOG = "{} -> {} Deleting...";
	public static final String SELECT_LOG = "{} -> {} Selecting...";
	
	public static final String SELECT_USER_LOG = "{} -> {} and {} Selecting...";
	public static final String INSERT_USER_LOG = "{} -> {} and {} Inserting...";
	
	public static final String MM_DD_YYYY_DATE_FORMAT = "MM/dd/yyyy";
	public static final String YYYY_MM_DD_DATE_FORMAT = "yyyy-MM-dd";
	public static final String HH_MM_TIME_FORMAT = "HH:mm";
	public static final String DATE_TIME_FORMAT = "MMM dd,yyyy HH:MM:SS";
	public static final String DD_MMM_YYYY_DATE_FORMAT = "dd MMM, yyyy";
	public static final String ISO_DATE_TIME_FORMAT = "dd MMM, yyyy HH:MM:SS.ZZZ";
	public static final String DEFAULT_DATE_TIME_FORMAT = "E dd MMM yyyy";
	
	public static final String SLASH = "/";
	public static final String DOT = ".";
	public static final String COLON = ":";
	public static final String DAY_WITH_DATE_FORMAT = "E dd MMM yyyy";
	
	public static final String SINGLE_UNIQUE_LOG = "{}";
	public static final String DOUBLE_UNIQUE_LOG = "{} -> {}";
	public static final String EXCEPTION_FOR = "Exception for ";
	
	public static final String C_DRIVE = "C";
	public static final String USERS_FOLDER = "Users";
	
	public static final String UPLOAD_PATH = C_DRIVE + COLON + File.separator + USERS_FOLDER + File.separator + System.getProperty(SYSTEM_USERNAME) + File.separator;
	public static final String DATA_UPLOAD_PATH_LOG = "Data Upload Path: {}";
	
	public static final String UNDER_SCORE = "_";
	
	public static final String SALE = "Sale";
	public static final String OUT_OF_STOCK = "Out Of Stock";
	
	public static final String IMAGE_PATH = "assets/img/products/";
}
