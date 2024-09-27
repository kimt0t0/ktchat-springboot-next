package com.ktchat.chat_app.dto;

import org.hibernate.validator.constraints.UniqueElements;

import com.ktchat.chat_app.enums.RoleEnum;
import com.ktchat.chat_app.models.User;

import jakarta.validation.constraints.Email;
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
public class UserDto {

    @NotNull(message = "Username cannot be null.")
    @NotBlank(message = "Username cannot be blank.")
    @NotEmpty(message = "Username cannot be empty.")
    @Size(min = 2, max = 40, message = "Username must be between 2 and 40 characters.")
    @UniqueElements
    private String username;

    @Email
    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email cannot be blank.")
    @NotEmpty(message = "Email cannot be empty.")
    @Size(min = 8, max = 120, message = "Email must be between 2 and 40 characters.")
    @UniqueElements
    private String email;

    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password cannot be blank.")
    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 255, message = "Password must be between 2 and 40 characters.")
    private String password;

    private RoleEnum role;

    public static UserDto fromEntity(User user) {
        //
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

}
