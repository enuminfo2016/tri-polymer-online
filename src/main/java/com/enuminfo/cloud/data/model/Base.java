package com.enuminfo.cloud.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.enuminfo.cloud.data.ColumnType;

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
@MappedSuperclass
public abstract class Base implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;
	
	@Column(name = ColumnType.STATUS)
	private Boolean status;
	
	@Column(name = ColumnType.CREATED_BY)
	private String createdBy;
	
	@Column(name = ColumnType.UPDATED_BY)
	private String updatedBy;
	
	@Column(name = ColumnType.CREATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = ColumnType.UPDATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
}
