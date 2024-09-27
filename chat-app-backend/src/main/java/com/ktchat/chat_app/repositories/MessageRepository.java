package com.ktchat.chat_app.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktchat.chat_app.models.Message;

public interface MessageRepository extends JpaRepository {

    // Find many
    List<Message> findAll();

    List<Message> findAllByAuthorId(UUID id);

    List<Message> findAllByContentContainingIgnoreCase(String content);

    List<Message> findAllByContentContainingIgnoreCaseAndTchatIsPrivate(String content, boolean isPrivate);

    List<Message> findAllByTchatId(UUID id);

    List<Message> findAllByTchatIdAndTchatIsPrivate(UUID id, boolean isPrivate);

    // Find one
    Optional<Message> findById(UUID id);

}
