/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.UserRegistrationValidation;

import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import static ms.Jwellery.web.WokerRegistrationController.logger;
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
import org.springframework.web.multipart.MultipartFile;

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
    private WorkerRegistrationBean registerBean;

    @RequestMapping(value = "/userregistration.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            registerBean = new WorkerRegistrationBean();
            logger.info("Enter inside viewform() method:::::::::::::");
            model.addAttribute("RegistrationDetails", registerBean);
            return "AdminRegistration";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

//    @InitBinder
//    public void dataBinding(WebDataBinder binder) {
//        logger.info("Enter Data Binding Method:::::::::::");
//        binder.addValidators(regValidate);
//    }
 @RequestMapping(value = "/userregistration.htm", method = RequestMethod.POST)
    public String AddUser(@ModelAttribute("RegistrationDetails")  WorkerRegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
         logger.info("Enter post Method:::::::::::1");
        File serverFile = null;
        FileInputStream fops;
        String filename = null;
        try {
            if (result.hasErrors()) {
                return "AdminRegistration";
            } else {
                logger.info("Enter Data Binding Method:::::::::::1");
                boolean flag = false;
                MultipartFile multipartFile = null;
                String applicationPath = null;
                applicationPath = request.getSession().getServletContext().getRealPath("");
                multipartFile = regDetails.getFiledata();

                if (!multipartFile.isEmpty()) {

                    filename = multipartFile.getOriginalFilename();

                    regDetails.setFileName(multipartFile.getOriginalFilename());
                }

                if (filename != null && !filename.equals("")) {

                    File dir = new File(applicationPath + "/");

                    if (!dir.exists()) {
                        dir.mkdir();
                    }

                    serverFile = new File(dir, filename);
                }
                flag = service.CreateUser(regDetails);
                if (flag) {
                    model.addAttribute("Success", "Successfully product added.");
                     return "redirect:/login.htm";
                } else {
                    model.addAttribute("Failure", "Registration not completed successfully.");
                    return "AdminRegistration";
                }
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        } finally {
            if (serverFile != null) {
                serverFile.delete();
            }
        }
    }

}
