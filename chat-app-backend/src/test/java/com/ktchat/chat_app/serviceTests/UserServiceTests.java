package test.java.com.ktchat.chat_app.serviceTests;

@ExtendWith(MockitoExtension.class)
// @DataJpaTest
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private static final String TEST_USERNAME = "tonton";
    private static final String TEST_EMAIL = "tonton@test.com";
    private static final String TEST_PASSWORD = "TontonPass-44-";
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        // create user dto with test data
        userDto = UserDto.builder()
                .username(TEST_USERNAME)
                .email(TEST_EMAIL)
                .password(TEST_PASSWORD)
                .build();
    }

    @Test
    public void registerUserWithSuccess() {
        // Mock userRepository.findByEmail to return null - simulating that no user
        // exists with this email
        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(null);

        // call save method from service with the dto
        ResponseEntity<?> response = userService.saveUser(userDto);

        // check that findByEmail from repository was called only once with this dto
        verify(userRepository, times(1)).findByEmail(userDto.getEmail());
        // check that save method was called only once with any User object
        verify(userService, times(1)).save(any(User.class));
        // assert that response status is code HttpStatus.CREATED
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Success: User detailed successfully saved !", response.getBody());
    }

    @Test
    public void saveUserWithExistingEmailFailure() {
        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(new User());
        ResponseEntity<?> response = userService.saveUser(userDto);
        verify(userRepository, times(1)).findByEmail(userDto.getEmail());
        verify(userService, times(0)).save(any(User.class));
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Failure: a user account already exists with this email !", response.getBody());
    }

    @Test
    public void saveUserWithInternalErrorFailure() {
        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(new User());
        ResponseEntity<?> response = userService.saveUser(userDto);
        verify(userRepository, times(1)).findByEmail(userDto.getEmail());
        verify(userService, times(0)).save(any(User.class));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Failure: an internal server error has occured !", response.getBody());
    }

}
