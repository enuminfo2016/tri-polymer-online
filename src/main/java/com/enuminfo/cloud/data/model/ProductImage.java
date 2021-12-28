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
@Table(name = TableType.PRODUCT_IMAGE)
@SuppressWarnings("serial")
public class ProductImage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Long id;

	@Column(name = ColumnType.IMG_NAME)
	private String imgName;

	@Column(name = ColumnType.IMG_DATA)
	@Lob
	private byte[] imgData;

	@Column(name = ColumnType.IMG_TYPE)
	private String imgType;

	@Column(name = ColumnType.PRODUCT)
	private Long product;

	@Column(name = ColumnType.MAIN_IMG)
	private Boolean mainImg;
}
