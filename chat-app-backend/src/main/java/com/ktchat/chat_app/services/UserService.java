package main.java.com.ktchat.chat_app.services;

import main.java.com.ktchat.chat_app.dtos.UserDto;
import main.java.com.ktchat.chat_app.models.User;
import main.java.com.ktchat.chat_app.repositories.UserRepository;

@Component
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Object> saveUser(UserDto userDto) {
        try {
            if (userRepository.findByEmail(userDto.getEmail()) == null) {
                User newUser = User.builder()
                        .username(userDto.getUsername())
                        .email(userDto.getEmail())
                        .password(userDto.getPassword())
                        .build();
                userRepository.save(newUser);
                return ResponseEntity.status(HttpStatus.CREATED).body("Success: User details successfully saved !");
            }
        } catch (Exception e) {
            log.error("User registration failed: " + e.message);
            return ResponseEntity.status(HttpStatus.)
        }
    }
}
