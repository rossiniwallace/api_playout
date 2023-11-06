package br.com.playout.record.users;

import jakarta.validation.constraints.NotBlank;

public record UserSignIn(
        @NotBlank
        String username,
        @NotBlank
        String password
) {


}
