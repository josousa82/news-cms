package org.cmsspringfive.newscms.dtosTests;

import org.cmsspringfive.newscms.domain.voDtos.CategoryRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class CategoryRequestTest {

    private CategoryRequest categoryRequest;
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }
}