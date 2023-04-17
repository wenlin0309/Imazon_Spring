package com.example.demo.user.dao.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class mallUserParam {
        @NotBlank(message = "user name should not be null")
        private String userName;
        @NotBlank(message = "user Real name should not be null")
        private String userRealName;
        @NotBlank(message = "user password should not be null")
        private String password;
}
