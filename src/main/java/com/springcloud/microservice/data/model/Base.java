/**
 *
 */
package com.springcloud.microservice.data.model;

import com.springcloud.microservice.data.ColumnType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SIVA KUMAR
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@MappedSuperclass
public abstract class Base implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
