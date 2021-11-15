package com.enuminfo.cloud.data.model;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = TableType.USER_ORDER)
public class UserOrderedPayment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.USER_ORDER)
	private Long userOrder;
	
	@Column(name = ColumnType.CART_VALUE)
	private Double cartValue;
	
	@Column(name = ColumnType.SHIP_VALUE)
	private Double shipValue;
	
	@Column(name = ColumnType.TAX_VALUE)
	private Double taxValue;
	
	@Column(name = ColumnType.PAYMENT_METHOD)
	private String paymentMethod;
}
