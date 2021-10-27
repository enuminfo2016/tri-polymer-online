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
@Table(name = TableType.USER_DETAIL)
public class UserDetail extends Base {

    @Column(name = ColumnType.FIRST_NAME)
    private String firstName;

    @Column(name = ColumnType.MIDDLE_NAME)
    private String middleName;

    @Column(name = ColumnType.LAST_NAME)
    private String lastName;

    @Column(name = ColumnType.EMAIL)
    private String email;

    @Column(name = ColumnType.PHONE)
    private Long phone;
}