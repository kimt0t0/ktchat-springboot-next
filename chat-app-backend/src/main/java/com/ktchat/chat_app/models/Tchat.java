package com.ktchat.chat_app.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tchats")
public class Tchat {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private boolean isPrivate;

}
