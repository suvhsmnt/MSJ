/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.AjaxController.logger;
import static ms.Jwellery.web.CustomerRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author suvo
 */
@Controller
public class CustomerController {

    static Logger logger = Logger.getLogger(UserProfileController.class);
    @Autowired
    private Service service;
    private LoginDetailsBean loginDetails;
    private WorkerRegistrationBean registerBean;

    @RequestMapping(value = "/Cprofile.htm")
    public String viewHome(@RequestParam("id") String id, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        logger.info("Enter inside profile() method:::::::::::::1");
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            logger.info("Enter checking session method:::::::::::::2");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            }
            logger.info("Enter inside viewHome() method:::::::::::::1");
            WorkerRegistrationBean csmr = null;
            csmr = new WorkerRegistrationBean();
            csmr = service.getCustomerDetailsById(id);
            logger.info("Enter inside viewHome() method:::::::::::::2");
            model.addAttribute("csmr", csmr);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "CustomerProfile";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

    @RequestMapping(value = "/getGoldStocktypes.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String GetWorkTypes(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        logger.info("hellow....................");
        paramMap = mapper.readValue(data, Map.class);
        List<Item> all = null;
        all = new ArrayList<Item>();
        all = service.GetPrimaryItem(paramMap.get("Type"));
        logger.info("hellow...................." + paramMap.get("Type"));
        return mapper.writeValueAsString(all);

    }

    @RequestMapping(value = "/AddGoldCustomer.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String AddGold(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        FormData f = new FormData();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
        f.setCID(paramMap.get("Customer_id"));
        f.setType(paramMap.get("Type"));
        f.setQuantity(paramMap.get("Gold_Quantity"));
        f.setPurpose(paramMap.get("Purpose"));
        
         if(service.Checkpass(loginDetails,paramMap.get("Password"))){
             f.setCurrent_Logger(loginDetails.getUsername());
              if(service.AddCustomerGold(f)){
              }
              else{
              }
         }else{
         
         }
         
        f.setStatus("success");
        return mapper.writeValueAsString(f);

    }
}
