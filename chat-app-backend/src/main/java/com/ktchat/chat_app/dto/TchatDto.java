package com.ktchat.chat_app.dto;

import java.util.UUID;

import com.ktchat.chat_app.models.Tchat;

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
public class TchatDto {

    @NotNull(message = "Tchat title cannot be null.")
    @NotBlank(message = "Tchat title cannot be blank.")
    @NotEmpty(message = "Tchat title cannot be empty.")
    @Size(min = 2, max = 150, message = "Tchat title must be between 2 and 40 characters.")
    private String title;

    private boolean isPrivate;

    @NotNull(message = "Tchat's owner id cannot be null.")
    @NotBlank(message = "Tchat's owner id cannot be blank.")
    @NotEmpty(message = "Tchat's owner cannot be empty.")
    private UUID ownerId;

    public static TchatDto fromEntity(Tchat tchat) {
        return TchatDto.builder()
                .title(tchat.getTitle())
                .isPrivate(tchat.isPrivate())
                .ownerId(tchat.getOwner().getId())
                .build();
    }

}
