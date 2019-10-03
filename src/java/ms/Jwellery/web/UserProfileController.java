/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.LoginDetailsBean;

import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.model.WorkerSalaryBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.WokerRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Suvh
 */
@Controller
public class UserProfileController {

    static Logger logger = Logger.getLogger(UserProfileController.class);
    @Autowired
    private Service service;
    private LoginDetailsBean loginDetails;
    private WorkerRegistrationBean registerBean;

    @RequestMapping(value = "/Profile.htm")
    public String viewForm(@RequestParam("id") String id, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            if (loginDetails == null && session.isNew()) {
                return "redirect:/login.htm";
            }
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
            worker = service.UserDetailsById(id);
            model.addAttribute("worker", worker);
            return "UserProfile";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/GrantPermission.htm")
    public String grant(@RequestParam("Adhar") String Adhar, @RequestParam("MKID") String MKID, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        boolean flag = false;
        try {
            System.out.println("grant");
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            if (loginDetails == null && session.isNew()) {
                return "redirect:/login.htm";
            } else if (loginDetails.getROLE().equalsIgnoreCase("admin")) {
                System.out.println("grant");
                flag = service.grantOrder(MKID);
                if (flag) {
                    return viewForm(Adhar, model, session, request, response);
                }
            }
            return "Error";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

//    @RequestMapping(value = "/updatepass.htm", method = RequestMethod.GET)
//    public String viewPassDetail(ModelMap model) {
//        return "UpdatePass";
//
//    }
//    @RequestMapping(value = "/updatepass.htm", method = RequestMethod.POST)
//    public String updatePassword(@RequestParam("oldpassword") String oldpass, @RequestParam("newpassword") String newpass, @RequestParam("confirmpassword") String confirmpass, @RequestParam("Adhar") String adhar, ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        boolean flag = false;
//        boolean flag2 = false;
//        try {
//            String success = "hellow";
//            LoginDetailsBean worker = null;
//            worker = new LoginDetailsBean();
//            session = request.getSession(false);
//            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
//            registerBean = new WorkerRegistrationBean();
//            registerBean.setADHAR(adhar);
//            registerBean.setPassword(oldpass);
//            registerBean.setRepassword(newpass);
//            logger.info("exception in viewform1:::::::::::::" + oldpass);
//            if (oldpass == null ) {
//                worker = service.UserDetailsById(adhar);
//                worker.setMsg("please");
//                model.addAttribute("worker", worker);
//                return "UserProfile";
//            } else if (newpass == null ? confirmpass != null : !newpass.equals(confirmpass)) {
//                worker = service.UserDetailsById(adhar);
//                worker.setMsg("Password Mismatch");
//                model.addAttribute("worker", worker);
//                return "UserProfile";
//
//            } else {
//                flag = service.Checkpass(loginDetails,oldpass);
//                logger.info("exception in viewform1:::::::::::::" + flag);
//               
//                
//                if (flag) {
//                    flag2 = service.Resetpass(registerBean);
//                    logger.info("exception in viewform2:::::::::::::" + flag2);
//                    if(flag2){
//                    worker = service.UserDetailsById(adhar);
//                    worker.setMsg("Success Password Updation");
//                    model.addAttribute("worker", worker);
//                    return "UserProfile";
//                    }else{
//                    worker = service.UserDetailsById(adhar);
//                    model.addAttribute("worker", worker);
//                    worker.setMsg("Enter correct Password");
//                    return "UserProfile";
//                    
//                    }
//                } else {
//                    worker = service.UserDetailsById(adhar);
//                    model.addAttribute("worker", worker);
//                    worker.setMsg("Wrong Credential");
//                    return "UserProfile";
//                }
//            }
//        } catch (NullPointerException nulEx) {
//            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
//            return "Error";
//        } catch (RuntimeException runEx) {
//            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
//            return "Error";
//        }
//
//    }
//    
//     @RequestMapping(value = "/updatedetails.htm", method = RequestMethod.GET)
//    public String viewDetail(ModelMap model,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
//      try {
//            session = request.getSession(false);
//            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
//            if (loginDetails == null && session.isNew()) {
//                return "redirect:/login.htm";
//            }
//            registerBean = new WorkerRegistrationBean();
//            model.addAttribute("RegistrationDetails", registerBean);
//            return "index";
//        } catch (NullPointerException nulEx) {    
//            return "index";
//        } catch (RuntimeException runEx) {  
//            return "index";
//        }
//
//    }
//
//
//    @RequestMapping(value = "/updatedetails.htm", method = RequestMethod.POST)
//    public String updateDetails(@ModelAttribute("RegistrationDetails")  WorkerRegistrationBean registerBean,@RequestParam("Adhar") String adhar, ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        boolean flag = false;
//        boolean flag2 = false;
//        try {
//           
//            LoginDetailsBean worker = null;
//            worker = new LoginDetailsBean();
//            session = request.getSession(false);
//            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
//           registerBean.setADHAR(adhar);
//            if (registerBean.getPassword() == null ) {
//                worker = service.UserDetailsById(registerBean.getADHAR());
//                worker.setMsg("please");
//                model.addAttribute("worker", worker);
//                return "UserProfile";
//            } else {
//                flag = service.Checkpass(loginDetails,registerBean.getPassword());
//                 if (flag) {
//                    flag2 = service.UpdateDetails(registerBean);            
//                    if(flag2){
//                    worker = service.UserDetailsById(registerBean.getADHAR());
//                    worker.setMsg("Success Password Updation");
//                    model.addAttribute("worker", worker);
//                    return "UserProfile";
//                    }else{
//                    worker = service.UserDetailsById(registerBean.getADHAR());
//                    model.addAttribute("worker", worker);
//                    worker.setMsg("Enter correct Password");
//                    return "UserProfile";
//                    
//                    }
//                } else {
//                    worker = service.UserDetailsById(registerBean.getADHAR());
//                    model.addAttribute("worker", worker);
//                    worker.setMsg("Wrong Credential");
//                    return "UserProfile";
//                }
//            }
//        } catch (NullPointerException nulEx) {
//            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
//            return "Error";
//        } catch (RuntimeException runEx) {
//            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
//            return "Error";
//        }
//
//    }
}
