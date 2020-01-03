package org.cmsspringfive.newscms.domain.validators;

public class HelperValidationMethods {

    public static boolean checkInputStringNullAndLength(String input){
        return (input == null || input.trim().length() == 0);
    }

}
