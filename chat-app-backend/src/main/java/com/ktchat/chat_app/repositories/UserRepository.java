package main.java.com.ktchat.chat_app.repositories;

import java.util.UUID;

import main.java.com.ktchat.chat_app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    User findByUsername(String username);
}
