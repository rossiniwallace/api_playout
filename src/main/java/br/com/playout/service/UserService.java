package br.com.playout.service;

import br.com.playout.model.User;
import br.com.playout.record.users.JWTToken;
import br.com.playout.record.users.UserDTO;
import br.com.playout.record.users.UserRegister;
import br.com.playout.record.users.UserSignIn;
import br.com.playout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    TokenService tokenService;

    public ResponseEntity<UserDTO> signUp(UserRegister userRegister, UriComponentsBuilder uriBuilder){

        User user = userRepository.save(new User((userRegister)));
        URI uri = uriBuilder.path("").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(user));

    }

    public ResponseEntity<JWTToken> signIn(UserSignIn userSignIn) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userSignIn.username(),
                        userSignIn.password()
                );

        Authentication authentication = manager.authenticate(authenticationToken);

        String token = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTToken(token));
    }
}
