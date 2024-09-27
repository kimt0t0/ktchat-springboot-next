package com.ktchat.chat_app.models;

import java.util.List;

import com.ktchat.chat_app.dto.UserDto;
import com.ktchat.chat_app.enums.RoleEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @Column(unique = true, nullable = false, length = 40)
    private String username;

    @Column(unique = true, nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.MERGE)
    private List<Tchat> ownedTchats;

    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Message> messages;

    @ManyToMany(targetEntity = Tchat.class, mappedBy = "members")
    private List<Tchat> participatedTchats;

    public static User toEntity(UserDto userDto) {
        //
        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
    }

}
