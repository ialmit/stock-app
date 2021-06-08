package com.timlai.stockapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Setter
@Getter
@Entity
@Table(name = "stock_app_user")
public class StockAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId; //This is an ID that the user has chosen to use to log in to the app.

    @Column(name = "user_password")
    private String userPassword;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role = "USER";

    @Column(name = "enabled")
    private boolean enabled = true;
}
