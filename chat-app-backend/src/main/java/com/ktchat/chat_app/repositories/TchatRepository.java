package com.ktchat.chat_app.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktchat.chat_app.models.Tchat;

public interface TchatRepository extends JpaRepository {

    // Find many
    List<Tchat> findAll();

    List<Tchat> findAllByIsPrivate(boolean isPrivate);

    List<Tchat> findAllByIdOwner(UUID id_owner);

    List<Tchat> findAllByIdOwnerAndIsPrivate(UUID id_owner, boolean isPrivate);

    List<Tchat> findAllByOwnerUsername(String username);

    List<Tchat> findAllByOwnerUsernameAndIsPrivate(String username, boolean isPrivate);

    List<Tchat> findAllByTitleContainingIgnoreCase(String title);

    List<Tchat> findAllByTitleContainingIgnoreCaseAndIsPrivate(String title, boolean isPrivate);

    @Query("from Tchat where count(messages) = 0")
    List<Tchat> findAllEmptyTchats();

    // Find one
    Optional<Tchat> findById(UUID id);

    Optional<Tchat> findByIdAndIsPrivate(UUID id, boolean isPrivate);

    Tchat findByTitleIgnoreCase(String title);

    Tchat findByTitleIgnoreCaseAndIsPrivate(String title, boolean isPrivate);

}
