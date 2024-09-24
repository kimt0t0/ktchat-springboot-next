package main.java.com.ktchat.chat_app.dtos;

@Data
@Builder
public class UserDto {

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username must be 3 to 20 characters long.")
    private String username;

    @Email(message = "Email is not valid.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 255, message = "Password must be 8 to 255 characters long.")
    @StrongPassword(message = "Password must be strong.")
    private String password;

}
