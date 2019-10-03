/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.CustomerValidation;
import static ms.Jwellery.web.WokerRegistrationController.logger;
import static ms.Jwellery.web.WorkerController.logger;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Suvh
 */
@Controller
public class CustomerRegistrationController {

    static Logger logger = Logger.getLogger(CustomerRegistrationController.class);
    @Autowired
    private Service service;
    @Autowired
    private CustomerValidation regValidate;
    private WorkerRegistrationBean registerBean;
    private LoginDetailsBean loginDetails;

    @RequestMapping(value = "/CRegistration.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("session check:::");
            if (loginDetails == null) {
                logger.info("session check:::inside if");
                return "redirect:/login.htm";
            }
            logger.info("Enter inside CRegistration viewform() ************method:::::::::::::");
            registerBean = new WorkerRegistrationBean();
            model.addAttribute("RegistrationDetails", registerBean);
            return "CRegistration";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "CRegistration";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "CRegistration";
        }

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        logger.info("Enter CRegistration Data Binding Method:::::::::::");
        binder.addValidators(regValidate);
    }

    @RequestMapping(value = "/CRegistration.htm", method = RequestMethod.POST)
    public String AddUser(@ModelAttribute("RegistrationDetails") @Validated WorkerRegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("session check:::");
            if (loginDetails == null && session.isNew()) {
                logger.info("session check:::inside if");
                return "redirect:/login.htm";
            }
            if (result.hasErrors()) {
                return "CRegistration";
            } else {
                logger.info("Enter CRegistration Method:::::::::::1");
                boolean flag = false;
                regDetails.setWORKER_ADDED_BY(loginDetails.getUsername());
                flag = service.RegistrationCustomer(regDetails);
                if (flag) {
                    model.addAttribute("Success", "Successfully Customer Added added.");
                    return "CRegistration";
                } else {
                    model.addAttribute("Success", " Customer add not completed successfully.");
                    return "CRegistration";
                }
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }
        @RequestMapping(value = "/Customerlist.htm")
    public String viewHome(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("Enter checking session method:::::::::::::2");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewHome() method:::::::::::::1");
             List<WorkerRegistrationBean> list = null;
            list = new ArrayList<WorkerRegistrationBean>();
            list = service.getAllCustomer();
            logger.info("Enter inside viewHome() method:::::::::::::2");
           
            logger.info("Enter inside viewHome() method:::::::::::::3");
          
            logger.info("Enter inside viewHome() method:::::::::::::4");
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "CustomerList";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
       
}
