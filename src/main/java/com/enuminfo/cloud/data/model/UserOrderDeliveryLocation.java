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
@Table(name = TableType.USER_ORDERED_DELIVERY_LOCATION)
public class UserOrderDeliveryLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnType.ID)
    private Long id;

    @Column(name = ColumnType.USER_ORDER)
    private Long userOrder;

    @Column(name = ColumnType.DELIVERY_LOCATION)
    private Long deliveryLocation;
}
