package com.example.demo.user.dao.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class orderParam {

    private String userName;

    private int count;

    private String name;

    private double price;
}
