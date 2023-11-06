package br.com.playout.record.users;

import br.com.playout.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegister(
        @NotBlank
        String name,
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String phoneNumber,
        @NotNull
        Role role
) {
}
