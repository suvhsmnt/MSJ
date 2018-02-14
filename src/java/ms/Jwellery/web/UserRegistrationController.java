/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;




import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.UserRegistrationValidation;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Suvh
 */
@Controller
public class UserRegistrationController {
  static Logger logger = Logger.getLogger(UserRegistrationController.class);
    @Autowired
    private Service service;
    @Autowired
    private UserRegistrationValidation regValidate;
    private UserRegistrationBean registerBean;
    
    

    @RequestMapping(value = "/indexee.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            registerBean = new UserRegistrationBean();
            model.addAttribute("RegistrationDetails", registerBean);
            return "index";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "index";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "index";
        }

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        logger.info("Enter Data Binding Method:::::::::::");
        binder.addValidators(regValidate);
    }

    @RequestMapping(value = "/indexee.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("RegistrationDetails") @Validated UserRegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session) throws RuntimeException {
        boolean flag = false;
        try {
            if (result.hasErrors()) {
                return "index";
            } else {
//               flag = service.RegistrationUser(regDetails);
                if (flag == false) {
                    result.reject("error.invalid");
                    return "index";
                } else {
                    model.addAttribute("success", "Successfully registration complated.");
                    return "index";
                }
            }
        }  catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "index";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "index";
        }

    }

}
