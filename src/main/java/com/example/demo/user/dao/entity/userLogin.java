package com.example.demo.user.dao.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class userLogin {
    @NotBlank(message = "user name should not be null")
    private String userName;
    @NotBlank(message = "user password should not be null")
    private String password;
}
