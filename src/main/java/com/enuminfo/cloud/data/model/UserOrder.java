package com.enuminfo.cloud.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date draftedDate;
	
	@Column(name = ColumnType.ORDERED_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderedDate;
	
	@Column(name = ColumnType.CANCELLED_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelledDate;
}