package com.ktchat.chat_app.models;

import java.util.UUID;

import com.ktchat.chat_app.enums.RoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
