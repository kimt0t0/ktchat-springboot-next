package test.java.com.ktchat.chat_app.controllerTests;

@WebMvcTest(User.UserControllerTests)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void saveUserSuccess() {
        // Valid UserDto request body
        String userDtoJson = "{\"username\": \"tutu\", \"email\": \"tutu@test.com\", \"password\": \"TutuPass-44-\"}";
        // mock successful service response
        when(userService.saveUser(any())).thenReturn(
                ResponseEntity.status(HttpStatus.CREATED).body("Success: User detailed successfully saved !"));
        // perform post request with valid dto
        mockMvc.perform(MockMvcRequestBuilder.post("/users/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UserDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Success: User detailed successfully saved !"));
    }

    @Test
    public void saveUserWithExistingEmailFailure() {
    }

    @Test
    public void saveUserWithInternalErrorFailure() {
    }

    @Test
    public void saveUserWithInvalidInputFailure() {
    }

}
