@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    @PostMapping("/register")
    @Operation(summary = "Register user")
    public String register() {
        return "User registered";
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public String login() {
        return "JWT_TOKEN";
    }
}
