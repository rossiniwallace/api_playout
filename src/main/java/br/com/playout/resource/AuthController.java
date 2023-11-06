package br.com.playout.resource;

import br.com.playout.model.User;
import br.com.playout.record.users.JWTToken;
import br.com.playout.record.users.UserDTO;
import br.com.playout.record.users.UserRegister;
import br.com.playout.record.users.UserSignIn;
import br.com.playout.service.AuthenticationService;
import br.com.playout.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> signIn(@RequestBody @Valid UserRegister body, UriComponentsBuilder uriBuilder) throws Exception {
        return userService.signUp(body,uriBuilder);
    }

    @PostMapping("/signIn")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JWTToken> signUp(@RequestBody @Valid UserSignIn body) throws Exception {
        return userService.signIn(body);
    }
}
