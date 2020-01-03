package org.cmsspringfive.newscms.domain.exceptions;

import lombok.Getter;
import org.cmsspringfive.newscms.domain.models.User;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {



    @Getter
    private String message;

    @Getter
    private String message1;
//    @Getter
//    private final HttpStatus httpStatus;

    public UserNotFoundException(HttpStatus httpStatus, String message) {
        super(message + httpStatus.toString());
        this.message = message;
        //this.httpStatus = httpStatus;
    }

    public UserNotFoundException(String message1) {
        super(message1);
        this.message = message1;
    }
}
