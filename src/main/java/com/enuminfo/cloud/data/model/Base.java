package com.enuminfo.cloud.data.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

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
public abstract class Base implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Boolean status;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
}
