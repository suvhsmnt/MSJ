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
import static ms.Jwellery.web.WokerRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Suvh
 */
@Controller
public class WorkerController {
     static Logger logger = Logger.getLogger(WorkerController.class);
    @Autowired
    private Service service;
    private LoginDetailsBean loginDetails;
   @RequestMapping(value = "/Workerlist.htm")
    public String viewHome(ModelMap model) {
        try {
//            session = request.getSession(false);
//            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
//            logger.info("session check");
//             if(session != null && !session.isNew()) {
////               return "redirect:/login.htm";
//            } else {
////                logger.info("Enter Data Binding Method:::::::::::1"+loginDetails.getName());  
//            return "redirect:/login.htm";
//               }
            logger.info("Enter inside viewHome() method:::::::::::::1");
            List<LoginDetailsBean> list = null;
            logger.info("Enter inside viewHome() method:::::::::::::2");
            list = new ArrayList<LoginDetailsBean>();
            logger.info("Enter inside viewHome() method:::::::::::::3");
            list = service.getAllWorker();
            logger.info("Enter inside viewHome() method:::::::::::::4");
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "Workerlist";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
}

