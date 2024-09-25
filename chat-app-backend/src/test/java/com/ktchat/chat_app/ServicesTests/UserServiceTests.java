package test.java.com.ktchat.chat_app.ServicesTests;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;

    @Test
    public void testCreateUserSuccess() {

        UserDto userDto = UserDto.builder()
                .id(UUID.randomUUID())
                .email("toto@test.com")
                .username("toto")
                .password("Toto-123-")
                .role("classic")
                .build();

        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(userDto);

        ResponseEntity<?> response = userService.save(userDto);

        verify(userRepository, times(1)).findByEmail(userDto.getEmail());
        verify(userRepository, times(1)).save(any(User.class));

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Success: user successfully created !", response.getBody());
    }

    @Test
    public void testCreateUserFailureEmailAlreadyExists() {
        UserDto userDto = UserDto.builder()
                .id(UUID.randomUUID())
                .email("toto@test.com")
                .username("toto")
                .password("Toto-123-")
                .role("classic")
                .build();

        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(Optional.of(userDto));

        assertThatThrownBy(() -> userService.save(userDto)).isInstanceOf(UserAlreadyExistsException.class)
                .hasMessageContaining("A user account already exists with this email.");
    }

    @Test
    public void testFindUserByIdSuccess() {
        UUID userId = UUID.randomUUID();
        User user = User.builder()
                .id(userId)
                .email("tutu@test.com")
                .username("tutu")
                .password("Tutu-123-")
                .role("classic")
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        ResponseEntity<?> response = userService.findById(userId);

        verify(userRepository, times(1)).findById(userId);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testFindUserByIdFailure() {
        UUID userId = UUID.randomUUID();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.findById(userId)).isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("User not found.");
    }
}
