package com.enuminfo.cloud.data.model;

import com.enuminfo.cloud.data.ColumnType;
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
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class Base implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.STATUS)
	private Boolean status;

	@Column(name = ColumnType.CREATED_BY)
	private String createdBy;

	@Column(name = ColumnType.CREATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = ColumnType.UPDATED_BY)
	private String updatedBy;

	@Column(name = ColumnType.UPDATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
}
