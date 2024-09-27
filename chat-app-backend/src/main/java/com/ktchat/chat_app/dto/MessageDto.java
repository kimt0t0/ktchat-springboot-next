package com.ktchat.chat_app.dto;

import java.util.UUID;

import com.ktchat.chat_app.models.Message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MessageDto {

    @NotNull(message = "Message content cannot be null.")
    @NotBlank(message = "Message content cannot be blank.")
    @NotEmpty(message = "Message content cannot be empty.")
    @Size(min = 2, max = 5000, message = "Message content must be between 2 and 5000 characters.")
    private String content;

    @NotNull(message = "Message's author id cannot be null.")
    @NotBlank(message = "Message's author id cannot be blank.")
    @NotEmpty(message = "Message's author cannot be empty.")
    private UUID authorId;

    @NotNull(message = "Message's tchat id cannot be null.")
    @NotBlank(message = "Message's tchat id cannot be blank.")
    @NotEmpty(message = "Message's tchat cannot be empty.")
    private UUID tchatId;

    public static MessageDto fromEntity(Message message) {
        return MessageDto.builder()
                .content(message.getContent())
                .authorId(message.getAuthor().getId())
                .tchatId(message.getTchat().getId())
                .build();
    }

}
