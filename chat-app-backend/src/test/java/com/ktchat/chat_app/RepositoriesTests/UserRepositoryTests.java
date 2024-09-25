package test.java.com.ktchat.chat_app.RepositoriesTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ktchat.chat_app.model.User;
import com.ktchat.chat_app.repository.UserRepository;

public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUserSuccess() {
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .email("tutu@test.com")
                .username("tutu")
                .password("Tutu-123-")
                .role("classic")
                .build();

        User createdUser = userRepository.save(user);

        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getId()).isEqualTo(userId);
        assertThat(createdUser.getEmail()).isEqualTo("tutu@test.com");
        assertThat(createdUser.getUsername()).isEqualTo("tutu");
    }

    @Test
    public void testFindByIdSuccess() {
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .email("tonton@test.com")
                .username("tonton")
                .password("Tonton-123-")
                .role("classic")
                .build();

        userRepository.save(user);
        User foundUser = userRepository.findById(userId).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(userId);
        assertThat(foundUser.getEmail()).isEqualTo("tonton@test.com");
        assertThat(foundUser.getUsername()).isEqualTo("tonton");
    }
}
