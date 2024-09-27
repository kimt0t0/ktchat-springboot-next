package com.ktchat.chat_app.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktchat.chat_app.enums.RoleEnum;
import com.ktchat.chat_app.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    // Find many
    List<User> findAll();

    List<User> findAllByUsernameContainingIgnoreCase(String username);

    List<User> findAllByRole(RoleEnum role);

    @Query("from User where count(messages) = 0")
    List<User> findAllWithoutMessages();

    @Query("from User where count(participatedTchats) = 0")
    List<User> findAllWithoutTchats();

    List<User> findAllByParticipatedTchatsTitleContainingIgnoreCase(String title);

    // Find one
    @SuppressWarnings("null")
    Optional<User> findById(UUID id);

    User findByUsername(String username);

    User findByEmail(String email);
}
