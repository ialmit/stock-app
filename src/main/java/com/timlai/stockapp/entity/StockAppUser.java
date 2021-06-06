package com.timlai.stockapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "stock_app_user")
public class StockAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; //This is the unique identifier to be used as the primary key.

    @Column(name = "user_id")
    private String userId; //This is an ID that the user has chosen to use to log in to the app.

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "email")
    private String email;
}
