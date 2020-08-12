package com.by.km.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 实体类：系统用户
 */
@Entity
@Table(name = "km_sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

}
