package com.by.km.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 测试用实体类
 * @author bingyi
 */
@Entity
@Table(name = "km_demo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

}
