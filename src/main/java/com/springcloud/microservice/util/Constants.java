/**
 * 
 */
package com.springcloud.microservice.util;

import java.io.File;

/**
 * @author SIVA KUMAR
 */
public interface Constants {

	String SYSTEM_USERNAME = "user.name";
	String UPDATE_LOG = "{} -> {} Updating...";
	String INSERT_LOG = "{} -> {} Inserting...";
	String DELETE_LOG = "{} -> {} Deleting...";
	String SELECT_LOG = "{} -> {} Selecting...";
	
	String SELECT_USER_LOG = "{} -> {} and {} Selecting...";
	String INSERT_USER_LOG = "{} -> {} and {} Inserting...";
	
	String MM_DD_YYYY_DATE_FORMAT = "MM/dd/yyyy";
	String YYYY_MM_DD_DATE_FORMAT = "yyyy-MM-dd";
	String HH_MM_TIME_FORMAT = "HH:mm";
	String DATE_TIME_FORMAT = "MMM dd,yyyy HH:MM:SS";
	String DD_MMM_YYYY_DATE_FORMAT = "dd MMM, yyyy";
	String ISO_DATE_TIME_FORMAT = "dd MMM, yyyy HH:MM:SS.ZZZ";
	String DEFAULT_DATE_TIME_FORMAT = "E dd MMM yyyy";
	
	String SLASH = "/";
	String DOT = ".";
	String COLON = ":";
	String DAY_WITH_DATE_FORMAT = "E dd MMM yyyy";
	
	String SINGLE_UNIQUE_LOG = "{}";
	String DOUBLE_UNIQUE_LOG = "{} -> {}";
	String EXCEPTION_FOR = "Exception for ";
	
	String C_DRIVE = "C";
	String USERS_FOLDER = "Users";
	
	String UPLOAD_PATH = C_DRIVE + COLON + File.separator + USERS_FOLDER + File.separator + System.getProperty(SYSTEM_USERNAME) + File.separator;
	String DATA_UPLOAD_PATH_LOG = "Data Upload Path: {}";
	
	String UNDER_SCORE = "_";
}
