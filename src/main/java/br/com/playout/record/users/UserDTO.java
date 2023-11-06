package br.com.playout.record.users;

import br.com.playout.enums.Role;
import br.com.playout.model.User;

public record UserDTO(Long user_id, String name, Role role,String phoneNumber,String username) {

    public UserDTO(User user){
        this(
            user.getUserId(),
            user.getName(),
            user.getRole(),
            user.getPhoneNumber(),
            user.getUsername()
        );
    }
}
