package com.ktchat.chat_app.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @Column(nullable = false, length = 5000)
    private String content;

}
