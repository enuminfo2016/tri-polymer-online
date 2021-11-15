package com.enuminfo.cloud.data.model;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = TableType.USER_ORDER)
public class UserOrder implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.USER)
	private Long user;

	@Column(name = ColumnType.STATUS)
	private String status;

	@Column(name = ColumnType.DELIVERY_STATUS)
	private String deliveryStatus;

	@Column(name = ColumnType.DRAFTED_DATE)
	@Temporal(TemporalType.DATE)
	private Date draftedDate;

	@Column(name = ColumnType.ORDERED_DATE)
	@Temporal(TemporalType.DATE)
	private Date orderedDate;

	@Column(name = ColumnType.CANCELLED_DATE)
	@Temporal(TemporalType.DATE)
	private Date cancelledDate;
}