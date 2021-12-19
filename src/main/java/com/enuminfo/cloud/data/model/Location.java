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
@Table(name = TableType.LOCATION)
@SuppressWarnings("serial")
public class Location extends Base {
	@Column(name = ColumnType.NAME)
	private String name;

	@Column(name = ColumnType.PIN)
	private Long pin;

	@Column(name = ColumnType.CITY)
	private String city;

	@Column(name = ColumnType.STATE)
	private String state;

	@Column(name = ColumnType.COUNTRY)
	private Long country;
}
