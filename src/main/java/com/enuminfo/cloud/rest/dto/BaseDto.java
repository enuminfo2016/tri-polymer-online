package com.enuminfo.cloud.rest.dto;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public abstract class BaseDto implements Serializable {
	private long id;
	private boolean status;
	private String lastModifiedBy;
	private String lastModifiedOn;
}
