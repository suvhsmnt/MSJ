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
import ms.Jwellery.model.AddOrderBean;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.OrderDivideBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.OrderController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Suvh
 */
@Controller
public class OrderController {

    static Logger logger = Logger.getLogger(OrderController.class);
    @Autowired
    private Service service;
    private LoginDetailsBean loginDetails;

    @RequestMapping(value = "/OrderList.htm")
    public String viewHome(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("Enter checking session method:::::::::::::2");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewHome() method:::::::::::::1");
            List<AddOrderBean> list = null;
            logger.info("Enter inside viewHome() method:::::::::::::2");
            list = new ArrayList<AddOrderBean>();
            logger.info("Enter inside viewHome() method:::::::::::::3");
            list = service.getAllOrder();
            logger.info("Enter inside viewHome() method:::::::::::::4");
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "OrderList";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
     @RequestMapping(value = "/OrderDivide.htm")
    public String OrdrDivide(@RequestParam("ID") String ID,ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("Enter checking session method:::::::::::::2");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewHome() method:::::::::::::1");
            List<OrderDivideBean> list = null;
            logger.info("Enter inside viewHome() method:::::::::::::2");
            list = new ArrayList<OrderDivideBean>();
            logger.info("Enter inside viewHome() method:::::::::::::3");
            list = service.getAllByOrderId(ID);
            logger.info("Enter inside viewHome() method:::::::::::::4");
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "OrderDivideList";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
        @RequestMapping(value = "/Order.htm")
    public String viewOrder(@RequestParam("ID") String ID,ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("Enter checking session method:::::::::::::2");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewHome() method:::::::::::::1");
            List<OrderDivideBean> list = null;
            logger.info("Enter inside viewHome() method:::::::::::::2");
            list = new ArrayList<OrderDivideBean>();
            logger.info("Enter inside viewHome() method:::::::::::::3");
            list = service.getAllProduct(ID);
            logger.info("Enter inside viewHome() method:::::::::::::4");
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "Order";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
}


