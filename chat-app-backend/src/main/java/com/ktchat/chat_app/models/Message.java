package com.ktchat.chat_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "messages")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Message extends AbstractEntity {

    @Column(nullable = false, length = 5000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "id_tchat")
    private Tchat tchat;

}
