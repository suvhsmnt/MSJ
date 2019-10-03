/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.LoginValidation;
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
public class LoginController {

    static Logger logger = Logger.getLogger(LoginController.class);
    private LoginDetailsBean loginDetails;
    @Autowired
    private Service service;
    @Autowired
    private LoginValidation loginVallidate;
    @Autowired
    private JavaMailSender mailSender;
    

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            Boolean flag;
            logger.info("Enter inside viewform() login.htm:::::::::::::");
            if(service.rowcountUser()==0){
            return "redirect:/userregistration.htm";
            }
            loginDetails = new LoginDetailsBean();
            model.addAttribute("LoginDetails", loginDetails);
            return "Login";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        logger.info("Enter Data Binding Method:::::::::::");
        binder.addValidators(loginVallidate);
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("LoginDetails") @Validated LoginDetailsBean loginDetails, BindingResult result, ModelMap model, HttpSession session) throws RuntimeException {

        try {
            String recipientAddress = "suvasmnt@yahoo.in";
            String subject = "subject";
            String message = "message:::::hellow";
            System.out.println("To: " + recipientAddress);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);

            logger.info("Enter processform Method:::::::::::");
            loginDetails = service.userAuthentication(loginDetails);
            logger.info("Enter processform Method:::::::::::");
            if (loginDetails == null) {
                result.reject("error.invalid");
                return "Login";
            } else {
                session.setAttribute("LoginDetails", loginDetails);
                model.addAttribute("LoginDetails", loginDetails);
                SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(recipientAddress);
                email.setSubject(subject);
                email.setText(message);
//                 mailSender.send(email);
                return "redirect:/index.htm";
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

    @RequestMapping(value = "/Logout.htm")
    public String logout(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("Enter in Logout request");
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            if (loginDetails != null) {
                loginDetails = null;
            }
            if (session != null) {
                session.invalidate();
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-store");
                response.setHeader("Expires", "0");
                response.setDateHeader("Expires", -1);
                response.addHeader("X-Frame-Options", "SAMEORIGIN");
            }
            logger.info("Logout successfully");
            return "redirect:/login.htm";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            return "redirect:/home.htm";
        }
    }
//  @WebFilter("/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpSession session = request.getSession(false);
//        String loginURI = request.getContextPath() + "/login";
//
//        boolean loggedIn = session != null && session.getAttribute("user") != null;
//        boolean loginRequest = request.getRequestURI().equals(loginURI);
//
//        if (loggedIn || loginRequest) {
//            chain.doFilter(request, response);
//        } else {
//            response.sendRedirect(loginURI);
//        }
//    }
//  }
//    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.GET)
//    public String ForgatePassView(ModelMap model) {
//        return "ForgotPassword";
//    }
//
//    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.POST)
//    public String getForgatePass(@RequestParam("Email") String emailId, ModelMap model) {
//        boolean flag = false;
//        try {
//            flag = service.getEmailValidation(emailId);
//            if(flag){
//                
//              return "ForgotPassword";
//            }else{
//              model.addAttribute("success", "Enter valid email.");
//              return "ForgotPassword";
//            }
//        } catch (NullPointerException nulEx) {
//            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
//            return "Error";
//        } catch (RuntimeException runEx) {
//            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
//            return "Error";
//        }        
//    }
}
