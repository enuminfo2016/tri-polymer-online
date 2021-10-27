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
@Table(name = TableType.CATALOG_PRODUCT)
public class CatalogProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnType.ID)
    private Long id;

    @Column(name = ColumnType.CATALOG)
    private Long catalog;

    @Column(name = ColumnType.PRODUCT)
    private Long product;

    @JoinColumn(name = ColumnType.QUANTITY)
    private Double quantity;

    @JoinColumn(name = ColumnType.PRICE)
    private Double price;
}
