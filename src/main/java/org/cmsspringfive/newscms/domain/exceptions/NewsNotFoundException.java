package org.cmsspringfive.newscms.domain.exceptions;

import lombok.Getter;

import java.util.UUID;

/**
 * @author      Jose Sousa
 * @version     1
 * @since       1
 * @apiNote     Exception is thrown when repository is null
 */

public class NewsNotFoundException extends RuntimeException {

    @Getter
    private final String message;

    public NewsNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
