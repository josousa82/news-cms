package org.cmsspringfive.newscms.domain.exceptions;

import lombok.Getter;
import org.cmsspringfive.newscms.domain.models.User;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    @Getter
    private final long exceptionUUID = Long.parseLong(String.valueOf(UUID.randomUUID()));

    @Getter
    private final String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;

    }
}
