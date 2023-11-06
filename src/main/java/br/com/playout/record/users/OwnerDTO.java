package br.com.playout.record.users;

import br.com.playout.model.User;

public record OwnerDTO(
        Long ownerId,
        String name,
        String phoneNumber
) {

    public OwnerDTO(User user) {
        this(
            user.getUserId(),
            user.getName(),
            user.getPhoneNumber()
        );
    }
}
