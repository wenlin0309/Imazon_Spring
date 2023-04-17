package com.example.demo.user.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//实体类，让你跟数据库连接，映射到一个表
//sprint data jpa

@Setter
//spring lambok
@Getter
@Table(name = "order_table")
public class userOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "orders", nullable = false)
    private int orders;
    @Column(name = "order_name", nullable = false)
    private String order_name;
    @Column(name = "order_price", nullable = false)
    private double order_price;
}
