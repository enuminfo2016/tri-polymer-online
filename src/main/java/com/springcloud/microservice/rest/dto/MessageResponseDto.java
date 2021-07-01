/**
 * 
 */
package com.springcloud.microservice.rest.dto;

import java.io.Serializable;

/**
 * @author SIVA KUMAR
 */
public class MessageResponseDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public MessageResponseDto(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
