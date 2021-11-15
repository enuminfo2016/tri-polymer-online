package com.enuminfo.cloud.data.model;

import com.enuminfo.cloud.data.ColumnType;
import com.enuminfo.cloud.data.TableType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	private String startDate;

	@Column(name = ColumnType.END)
	private String endDate;
}
