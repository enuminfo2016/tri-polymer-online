package com.enuminfo.cloud.data.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
@Table
public class UserOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Long user;
	private String status;
	private String deliveryStatus;
	private Date draftedDate;
	private Date orderedDate;
	private Date cancelledDate;
}