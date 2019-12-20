package org.cmsspringfive.newscms.domain.exceptions;

import lombok.Getter;
import java.util.UUID;

public class CategoryNotFoundException extends RuntimeException {

    /**
     * @author      Jose Sousa
     * @version     1
     * @since       1
     * @apiNote     Exception is thrown when repository is null
     */

    @Getter
    private static final long serialVersionUID = Long.valueOf(UUID.randomUUID().toString());

    @Getter
    private final String message;

    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
