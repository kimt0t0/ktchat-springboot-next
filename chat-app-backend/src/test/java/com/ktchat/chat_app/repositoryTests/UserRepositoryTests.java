package test.java.com.ktchat.chat_app.repositoryTests;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveUser() {
        // Test data
        String username = "toto";
        String email = "toto@test.com";
        String password = "TotoPass-44-";

        // Create user object with the data
        User user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();

        // Save to database
        User savedUser = userRepository.save(user);

        // Assert data values
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(username, savedUser.getUsername());
        assertEquals(email, savedUser.getEmail());
        // add password check ?

    }

    // add tests with empty fields for user save.

    @Test
    @Transactional
    @Rollback
    public void testFindByEmailUserFound() {

        String username = "titi";
        String email = "titi@test.com";
        String password = "TitiPass-44-";

        User user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();

        userRepository.save(user);

        User foundUser = userRepository.findByEmail(email);

        assertNotNull(foundUser);
        assertEquals(email, foundUser.getEmail());
        assertEquals(username, foundUser.getUsername());
        // add password check ?
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByEmailUserNotFound() {

        User foundUser = userRepository.findByEmail("fake@test.com");
        assertNull(foundUser);
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByUsernameUserFound() {
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByUsernameUserNotFound() {
    }

}
