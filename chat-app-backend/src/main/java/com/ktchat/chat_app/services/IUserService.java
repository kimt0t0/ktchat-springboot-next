package main.java.com.ktchat.chat_app.services;

import main.java.com.ktchat.chat_app.dtos.UserDto;

public interface IUserService {
    ResponseEntity<Object> saveUser(UserDto userDto);
}
