package test.java.com.ktchat.chat_app.ControllersTests;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.chatapp.controller.UserController;
import com.chatapp.model.User;
import com.chatapp.service.UserService;

public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMock
    private UserController userController;

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUserSuccess() {
        UserDto userDto = UserDto.builder()
                .id(UUID.randomUUID())
                .email("toto@test.com")
                .username("toto")
                .password("Toto-123-")
                .role("classic")
                .build();

        when(userService.save(any(UserDto.class))).thenReturn(userDto);

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(
                        "{ \"email\": \"toto@test.com\", \"username\": \"toto\", \"password\": \"Toto-123-\", \"role\\\": \"classic\" }"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateUserFailureEmailAlreadyExists() {
        when(userService.save(any(UserDto.class)))
                .thenThrow(new UserAlreadyExistsException("A user account already exists with this email."));

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(
                        "{ \"email\": \"toto@test.com\", \"username\": \"toto\", \"password\": \"Toto-123-\", \"role\\\": \"classic\" }"))
                .andExpect(status().isConflict());
    }

    @Test
    public void testCreateUserFailureInvalidInput() {
        UserDto userDto = UserDto.builder()
                .id(UUID.randomUUID())
                .email("toto@test")
                .username("")
                .password("Toto")
                .role("classic")
                .build();

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(
                        "{ \"email\": \"toto@test\", \"username\": \"\", \"password\": \"Toto\", \"role\\\": \"classic\" }"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").value("Email is invalid !"))
                .andExpect(jsonPath("$.username").value("Username is required !"))
                .andExpect(jsonPath("$.password").value("Password is invalid !"));

        verify(userService, times(0)).save(any(UserDto.class));
    }

    @Test
    public void testFindUserByIdSuccess() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .email("toto@test.com")
                .username("toto")
                .password("Toto-123-")
                .role("classic")
                .build();

        when(userService.findById(any(UUID.class))).thenReturn(user);

        mockMvc.perform(get("/users/{id}", user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("toto@test.com"));
    }

    @Test
    public void testFindUserByIdFailure() {
        when(userService.findById(any(UUID.class))).thenThrow(new UserNotFoundException("User not found !"));

        mockMvc.perform(get("/users/{id}", UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }
}
