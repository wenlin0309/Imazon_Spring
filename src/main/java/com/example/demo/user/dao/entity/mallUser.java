package com.example.demo.user.dao.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
//实体类，让你跟数据库连接，映射到一个表
//sprint data jpa

@Setter
//spring lambok
@Getter
@Table(name = "user")
public class mallUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自动设置id,按顺序添加id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "user_real_name", nullable = false)
    private String userRealName;
    @Column(name = "user_password", nullable = false)
    private String password;

}
