package com.ktchat.chat_app.models;

import com.ktchat.chat_app.dto.MessageDto;

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
    @JoinColumn(name = "id_author", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "id_tchat", nullable = false)
    private Tchat tchat;

    public static Message toEntity(MessageDto messageDto) {
        return Message.builder()
                .content(messageDto.getContent())
                .author(
                        User.builder()
                                .id(messageDto.getAuthorId())
                                .build())
                .tchat(
                        Tchat.builder()
                                .id(messageDto.getTchatId())
                                .build())
                .build();
    }

}
