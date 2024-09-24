package test.java.com.ktchat.chat_app.controllerTests;

import org.junit.jupiter.api.Test;

import main.java.com.ktchat.chat_app.models.User;
import main.java.com.ktchat.chat_app.services.UserService;

@WebMvcTest(User.UserControllerTests)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // initialize common objects or set up necessary preconditions
    }

    @Test
    public void saveUserSuccess() {
        // Valid UserDto request body
        String userDtoJson = "{\"username\": \"tutu\", \"email\": \"tutu@test.com\", \"password\": \"TutuPass-44-\"}";
        // mock successful service response
        when(userService.saveUser(any())).thenReturn(
                ResponseEntity.status(HttpStatus.CREATED).body("Success: User details successfully saved !"));
        // perform post request with valid dto
        mockMvc.perform(MockMvcRequestBuilder.post("/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Success: User details successfully saved !"));
    }

    @Test
    public void saveUserWithExistingEmailFailure() {
        String userDtoJson = "{\"username\": \"toto\", \"email\": \"toto@test.com\", \"password\": \"TotoPass-44-\"}";
        when(userService.saveUser(any())).thenReturn(
                ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Failure: a user account already exists with this email !"));
        mockMvc.perform(MockMvcRequestBuilder.post("/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserDtoJson))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Failure: a user account already exists with this email !"));
    }

    @Test
    public void saveUserWithInternalErrorFailure() {
        String userDtoJson = "{\"username\": \"toto\", \"email\": \"toto@test.com\", \"password\": \"TotoPass-44-\"}";
        when(userService.saveUser(any())).thenReturn(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failure: an internal server error has occured !"));
        mockMvc.perform(MockMvcRequestBuilder.post("/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserDtoJson))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Failure: an internal server error has occured !"));
    }

    @Test
    public void saveUserWithInvalidInputFailure() {
        // invalid dto string
        String userDtoJson = "{ \"email\": \"toto@test\", \"password\": \"TotoPass\"}";
        mockMvc.perform(MockMvcRequestBuilder("/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserDtoJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Username is required."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("Email is not valid."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("Password is not valid."));
    }

    @AfterEach
    public void tearDown() {
        // Reset mocks or any shared state if necessary
    }

}
