/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.LoginValidation;
import ms.Jwellery.validation.UserRegistrationValidation;
import static ms.Jwellery.web.LoginController.logger;
import static ms.Jwellery.web.WokerRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Suvh
 */
@Controller
@RequestMapping
public class ForgotpassController {

    static Logger logger = Logger.getLogger(ForgotpassController.class);
  
    @Autowired
    private Service service;
    @Autowired
    private UserRegistrationValidation regValidate;
    private JavaMailSender mailSender;
    private WorkerRegistrationBean registerBean;
    private LoginDetailsBean loginDetails;

    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            logger.info("Enter inside viewform() method:::::::::::::");
            loginDetails = new LoginDetailsBean();
            model.addAttribute("LoginDetails", loginDetails);
            return "Forgotpass";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("LoginDetails") LoginDetailsBean loginDetails, BindingResult result, ModelMap model) throws RuntimeException {

        try {
            String recipientAddress = "suvasmnt@yahoo.in";
            String subject = "subject";

            System.out.println("To: " + recipientAddress);
            System.out.println("Subject: " + subject);

            logger.info("Enter processform Method:::::::::::");

//           mailSender.send(email);
            loginDetails = service.Forgotpass(loginDetails);
            if (loginDetails == null) {
                result.reject("error.invalid");
                return "Forgotpass";
            } else {
                String message = "message:::::hellow" + loginDetails.getName() + "   " + "/MsJwellery/ResetPass.htm?id=" + "1234" + "-2" + loginDetails.getAdhar();
                SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(recipientAddress);
                email.setSubject(subject);
                email.setText(message);
                mailSender.send(email);
                logger.info("Enter processform Method:::::::::::" + message);
                System.out.println(message);
                return "redirect:/login.htm";
            }

        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        }
    }

    @RequestMapping(value = "/ResetPass.htm", method = RequestMethod.GET)
    public String ViewForm(@RequestParam("id") String Phone, ModelMap model) throws ServletException, IOException {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            logger.info("Enter inside viewform() method:::::::::::::");
            String test = Phone;
            String[] check = test.split("-2");

            if (check[0].equalsIgnoreCase("1234")) {
                
                registerBean =new WorkerRegistrationBean();
                registerBean.setPhone(check[1]);           
                logger.info("Enter inside viewform() method:::::::::::::"+check[1]);
                model.addAttribute("RegistrationDetails", registerBean);
                return "ResetPass";
            } else {
                return "Error";
            }
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
//     @InitBinder
//    public void dataBinding(WebDataBinder binder) {
//        logger.info("Enter Data Binding Method:::::::::::");
//        binder.addValidators(regValidate);
//    }

    @RequestMapping(value = "/ResetPass.htm", method = RequestMethod.POST)
    public String ProcessForm(@ModelAttribute("RegistrationDetails")  WorkerRegistrationBean registerBean, BindingResult result, ModelMap model) throws RuntimeException {

        try {
            boolean msg;
            msg=service.Resetpass(registerBean);
            if (msg){
            model.addAttribute("Success", "Successfully Upadted password");
             return "ResetPass";
            }
            else{
             model.addAttribute("Success", "password is not updated try again");
             return "ResetPass";
            }
           

        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        }
    }

}
