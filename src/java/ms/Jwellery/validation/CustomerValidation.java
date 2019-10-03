/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.validation;

import static java.lang.Compiler.command;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.validation.UserRegistrationValidation.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Suvh
 */
@Component
public class CustomerValidation implements Validator {
@Autowired
    private Service service;
    private Pattern pattern;
    private Matcher matcher;
    private final String GST_PATTERN
            = "[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9A-Za-z]{1}[Z]{1}[0-9a-zA-Z]{1}";
   @Override
    public boolean supports(Class<?> c) {
        logger.info("inside supportsss section:::::::::::::");
        return WorkerRegistrationBean.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Name", "field.Name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "field.Email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone", "field.Phone.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ADDRESS", "field.ADDRESS.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "GST", "field.GST.empty");
         WorkerRegistrationBean regBean = (WorkerRegistrationBean) command;
          if (regBean.getPhone() != null && !regBean.getPhone().isEmpty()) {
            logger.info("inside adhar validate section:::::::::::::");
            pattern = Pattern.compile(GST_PATTERN);
            matcher = pattern.matcher(regBean.getGST());
            if (!matcher.matches()) {
                errors.rejectValue("GST", "GST.pattern.error");
            } else {
                logger.info("inside gst validate section:::::::::::::2");
                boolean flag = service.CHECKGST(regBean.getGST());
                logger.info("inside adhar validate section:::::::::::::2.5");
                if (flag) {
                    logger.info("inside gst validate section:::::::::::::3");
                    errors.rejectValue("GST", "GST.exits.error");
                }
            }
        }
    }

}
