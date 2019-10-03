/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.validation;

import ms.Jwellery.model.LoginDetailsBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Suvh
 */
@Component
public class LoginValidation implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return LoginDetailsBean.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "field.Password.empty");
    }

}
