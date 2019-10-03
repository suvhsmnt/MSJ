/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import ms.Jwellery.validation.LoginValidation;
import static ms.Jwellery.web.LoginController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author suvo
 */
@Controller
@RequestMapping
public class ItemController {

    static Logger logger = Logger.getLogger(LoginController.class);
    private Item item;
    @Autowired
    private Service service;
    @Autowired
    private LoginValidation loginVallidate;

    @RequestMapping(value = "/item.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            List<Item> itm = null;
            itm = new ArrayList<Item>();
            item = new Item();
            itm = service.GetPrimaryItem("PRIMARY");
            logger.info("ItemController in viewform:::::::::::::");
            List<Item> all= null;
            all = new ArrayList<Item>();
            all=service.GetAllItem();
            model.addAttribute("All",all);
            model.addAttribute("item", itm);
            model.addAttribute("itm", item);
            return "Item";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

    @RequestMapping(value = "/item.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("itm") Item item, ModelMap model, HttpSession session) throws RuntimeException {
        Boolean flag = false;
        List<Item> itm = null;
        itm = new ArrayList<Item>();
          List<Item> all= null;
            all = new ArrayList<Item>();
            all=service.GetAllItem();
           
        try {

            logger.info("ItemController in viewform:::::::::::::");

            logger.info("ItemController in viewform:::::::::::::");
            if (service.AddItem(item)) {
               all=service.GetAllItem();
             model.addAttribute("All",all);
                itm = service.GetPrimaryItem("PRIMARY");
                model.addAttribute("item", itm);
                model.addAttribute("Success", "Item Added Successfully");
                return "Item";
            } else {
                itm = service.GetPrimaryItem("PRIMARY");
                model.addAttribute("item", itm);
                 model.addAttribute("All",all);
                model.addAttribute("Success", "Item Not Added Successfully");
                return "Item";
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            model.addAttribute("Success", "Item Not Added Successfully");
             model.addAttribute("All",all);
            return "Item";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            model.addAttribute("Success", "Item Not Added Successfully");
             model.addAttribute("All",all);
            return "Item";
        }
    }

}
