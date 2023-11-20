package runnerservice.runner.endpoints;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runnerservice.runner.logic.JwtGenerator;

@RestController
@RequestMapping("login")
public class LoginEndpoint {


    private final JwtGenerator jwtGenerator;

    public LoginEndpoint(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }


    @GetMapping
    String jwt(Authentication authentication) {
        return jwtGenerator.generate(authentication);
    }

}
