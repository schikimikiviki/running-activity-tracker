package runnerservice.runner.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import runnerservice.runner.data.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@RestController
@RequestMapping("/internal/user")
public class InternalUserEndpoint {

    // In-memory storage for user data
    private final Map<String, User> userStorage = new ConcurrentHashMap<>();

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User newUser) {
        // Validate the bearer token (you might need to modify this part based on how tokens are passed)


        String expectedToken = System.getProperty("user.srv.token", "MY_TOKEN");
        String actualToken = ""; // You need to obtain the token from the User object or another source

        if (!expectedToken.equals(actualToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid bearer token");
        }

        // Save the user in the in-memory storage or perform other operations as needed
        userStorage.put(newUser.getUsername(), newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
}