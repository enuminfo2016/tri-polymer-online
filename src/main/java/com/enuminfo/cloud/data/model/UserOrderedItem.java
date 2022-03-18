package com.enuminfo.cloud.data.model;

import java.io.Serializable;

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
public class UserOrderedItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Long userOrder;
	private Long product;
	private Double quantity;
	private Double price;
}
