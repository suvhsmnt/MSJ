/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.UserRegistrationValidation;
import static ms.Jwellery.web.UserRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Suvh
 */
@Controller
public class WokerRegistrationController {
 static Logger logger = Logger.getLogger(WokerRegistrationController.class);
    @Autowired
    private Service service;
    @Autowired
    private UserRegistrationValidation regValidate;
    private WorkerRegistrationBean registerBean;
    private LoginDetailsBean loginDetails;
    
    

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
         try {
             
            logger.info("Enter inside viewform() ************method:::::::::::::");
            registerBean = new WorkerRegistrationBean();
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

    @RequestMapping(value = "/index.htm", method = RequestMethod.POST)
    public String AddUser(@ModelAttribute("RegistrationDetails") @Validated WorkerRegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        File serverFile = null;
        FileInputStream fops;
        String filename = null;
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("session check");
             if(session != null && !session.isNew()) {
//               return "redirect:/login.htm";
            } else {
//                logger.info("Enter Data Binding Method:::::::::::1"+loginDetails.getName());  
            return "redirect:/login.htm";
               }
            if (result.hasErrors()) {
                return "index";
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
            flag = service.RegistrationUser(regDetails);
            if (flag) {
                model.addAttribute("Success", "Successfully product added.");
                return "index";
            } else {
                model.addAttribute("Success", " product add not completed successfully.");
                return "index";
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
