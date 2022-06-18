package com.enuminfo.cloud.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = TableType.CATALOG)
public class Catalog extends Base {
	@Column(name = ColumnType.NAME)
	private String name;
	
	@Column(name = ColumnType.START)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = ColumnType.END)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
}
