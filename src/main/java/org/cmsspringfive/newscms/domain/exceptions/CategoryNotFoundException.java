package org.cmsspringfive.newscms.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

    /**
     * @author      Jose Sousa
     * @version     1
     * @since       1
     * @apiNote     Exception is thrown when repository is null
     */


    @Getter
    private final String message;

    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }




}
