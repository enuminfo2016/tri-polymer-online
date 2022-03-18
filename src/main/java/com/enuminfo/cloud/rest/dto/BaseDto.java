package com.enuminfo.cloud.rest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public abstract class BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean status;
	private String lastModifiedBy;
	private String lastModifiedOn;
}
