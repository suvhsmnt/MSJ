/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.web.WokerRegistrationController;
import org.apache.log4j.Logger;
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
public class UserRegistrationValidation implements Validator{
 @Autowired
    private Service service;
    private Pattern pattern;
    private Matcher matcher;
    private final String strpatten = "[a-zA-Z]";
    private final String phnpattern = "[0-9]";
    private final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String ADHAR_PATTERN="[0-9]{12}";

    private final String PASSWORD_PATTERN
            = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
   static Logger logger = Logger.getLogger(WokerRegistrationController.class);
   
    @Override
    public boolean supports(Class<?> c) {
        logger.info("inside supportsss section:::::::::::::");
        return WorkerRegistrationBean.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        logger.info("inside validate section:::::::::::::");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Name", "field.Name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "field.Email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone", "field.Phone.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "field.Password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repassword", "field.rePassword.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ADDRESS", "field.ADDRESS.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ADHAR", "field.ADHAR.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "GOLD", "field.GOLD.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "NETBAL", "field.NETBAL.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "STONE", "field.STONE.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filedata", "field.filedata.empty");
       WorkerRegistrationBean regBean = (WorkerRegistrationBean) command;
//        if (regBean.getFname() != null && !regBean.getFname().isEmpty()) {
//            pattern = Pattern.compile(strpatten);
//            matcher = pattern.matcher(regBean.getFname());
//            if (!matcher.matches()) {
//                errors.rejectValue("Fname", "Fname.error");
//            }
//        }
//        if (regBean.getLname() != null && !regBean.getLname().isEmpty()) {
//            pattern = Pattern.compile(strpatten);
//            matcher = pattern.matcher(regBean.getLname());
//            if (!matcher.matches()) {
//                errors.rejectValue("Lname", "Lname.error");
//            }
//        }

        if (regBean.getPassword() != null && !regBean.getPassword().isEmpty()) {
            if (regBean.getPassword().length() > 6 && regBean.getPassword().length() < 20) {
                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(regBean.getPassword());
                  logger.info("inside password validate section:::::::::::::");
                if (!matcher.matches()) {
                     logger.info("inside password validate section:::::::::::::");
                    errors.rejectValue("password", "password.error");
                }
            } else {
                 logger.info("inside password validate section:::::::::::::");
                errors.rejectValue("password", "password.error.length");
            }
        }
         if (regBean.getRepassword() != null && !regBean.getRepassword().isEmpty()) {
             logger.info("inside adhar validate section:::::::::::::"+regBean.getPassword()+">>>>>>>>>"+regBean.getRepassword());
            if (!regBean.getRepassword().equals(regBean.getPassword())) {
                errors.rejectValue("repassword", "repassword.error");
            }
        }
        if (regBean.getEmail() != null && !regBean.getEmail().isEmpty()) {
           logger.info("inside email validate section:::::::::::::");
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(regBean.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "email.error");
            }else{
//              boolean flag=service.getEmailValidation(regBean.getEmail()); 
//              if(flag){
//                errors.rejectValue("email", "email.exits.error");
//              }
            }
        }
        if (regBean.getADHAR()!= null && !regBean.getADHAR().isEmpty()) {
            logger.info("inside adhar validate section:::::::::::::");
            pattern = Pattern.compile(ADHAR_PATTERN);
            matcher = pattern.matcher(regBean.getADHAR());
            if (!matcher.matches()) {
                errors.rejectValue("ADHAR", "ADHAR.error");
            }else{
                logger.info("inside adhar validate section:::::::::::::2");
              boolean flag=service.getADHARValidation(regBean.getADHAR()); 
              logger.info("inside adhar validate section:::::::::::::2.5");
              if(flag){
                  logger.info("inside adhar validate section:::::::::::::3");
                errors.rejectValue("ADHAR", "ADHAR.exits.error");
              }
            }
        }

//        if (regBean.getPhone() != null && !regBean.getPhone().isEmpty()) {
//            if (regBean.getPhone().length() == 10) {
//                pattern = Pattern.compile(phnpattern);
//                matcher = pattern.matcher(regBean.getPhone());
//                if (!matcher.matches()) {
//                    errors.rejectValue("phone", "phone.error");
//                }
//            }else{
//                errors.rejectValue("phone", "phone.error.length");
//            }
//        }

    }

}

