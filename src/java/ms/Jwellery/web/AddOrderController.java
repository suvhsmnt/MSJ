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
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.AddOrderValidation;
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
public class AddOrderController {

    static Logger logger = Logger.getLogger(AddOrderController.class);
    @Autowired
    private Service service;
    @Autowired
    private AddOrderValidation OrderValidate;
    private AddOrderBean OrderBean;
    private LoginDetailsBean loginDetails;

    @RequestMapping(value = "/Orderregister.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            if (loginDetails == null && session.isNew()) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewform() Orderregister.htm viewForm():::::::::::::");
            OrderBean = new AddOrderBean();
            List<WorkerRegistrationBean> list = null;
            list = new ArrayList<WorkerRegistrationBean>();
            list = service.getAllCustomer();
            model.addAttribute("CSMR",list);
            model.addAttribute("OrderDetails", OrderBean);
            return "Orderregister";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::Orderregister.htm viewForm()" + nulEx.getMessage());
            return "Orderregister";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::Orderregister.htm viewForm()" + runEx.getMessage());
            return "Orderregister";
        }

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        logger.info("Enter Data Binding Method:::::::::::Orderregister.htm dataBinding()");
        binder.addValidators(OrderValidate);
    }

    @RequestMapping(value = "/Orderregister.htm", method = RequestMethod.POST)
    public String AddOrder(@ModelAttribute("OrderDetails") @Validated AddOrderBean OrderBean, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        logger.info("Enter Data Binding Method:::::::::::Orderregister.htm AddOrder()");
          List<WorkerRegistrationBean> list = null;
          list = new ArrayList<WorkerRegistrationBean>();
          list = service.getAllCustomer();
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            if (loginDetails == null && session.isNew()) {
                return "redirect:/login.htm";
            }
            if (result.hasErrors()) {
                logger.info("Enter Data Binding Method:::::::::::Orderregister.htm dataBinding()::::AddOrder");
                 model.addAttribute("CSMR",list);
                  model.addAttribute("Success", " hashErrors");
                return "Orderregister";
            } else {
                logger.info("Enter AddOrder Methoddfddd:::::::::::4"+OrderBean.getCname()+"hhh");
                boolean flag = false;
                boolean flagnxt = false;
                boolean Each=false;
                OrderBean.setORDER_ADDED_BY(loginDetails.getAdhar());
                flag = service.OrderRegistration(OrderBean);
                logger.info("Enter AddOrder Methoddfddd:::::::::::4");
                if(flag){
                for (int i = 0; i < OrderBean.getOrder().size(); i++) {
                    flagnxt = service.DivideOrder(OrderBean, i);
                     logger.info("Enter divide order Methoddfddd:::::::::::"+i);
                     if (flagnxt) {
                       
                    OrderDivideBean order = OrderBean.getOrder().get(i);
                    for(int j=0;j<Integer.parseInt(order.getQUANTITY());j++)
                     {
                         logger.info("Enter product Methoddfddd:::::::::::"+j);
                  Each=service.EachOrderBytype(order);  
                         if(!Each){
                         flagnxt=false;
                         }
                      }
                    }
                }
                }
                if (flag && flagnxt) {
                     model.addAttribute("CSMR",list);
                    model.addAttribute("Success", "Successfully product added.");
                    return "Orderregister";
                } else {
                     
                     model.addAttribute("CSMR",list);
                    model.addAttribute("Success", " product add not completed successfully.");
                    return "Orderregister";
                }
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewformmmmm:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }
}
