package org.cmsspringfive.newscms.domain.validators;


import org.cmsspringfive.newscms.domain.models.Role;
import org.cmsspringfive.newscms.domain.voDtos.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateUserRequest")
public class UserRequestDtoValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {

        return UserRequest.class.equals(aClass);
    }

    @Override
     public void validate(Object object, Errors errors) {


        ValidationUtils.rejectIfEmpty(errors, "identity", "identity.empty",
                "Identity must have a value.");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "role", "name.empty");

        UserRequest userRequestDto = (UserRequest) object;
        Role role = null;

        if(!userRequestDto.getRole().name().equalsIgnoreCase(role.AUTHOR.name()) ||
                !userRequestDto.getRole().name().equalsIgnoreCase(role.REVIEWER.name())){
            errors.rejectValue("role", "The Role must be " + Role.AUTHOR.name() + " " + Role.REVIEWER.name());

            //throw new IllegalArgumentException("The Role must be " + Role.AUTHOR.name() + " " + Role.REVIEWER.name());

        }


    }


}
