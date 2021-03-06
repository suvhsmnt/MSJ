/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.WokerRegistrationController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Suvh
 */
@Controller
public class ImageController {

    static Logger logger = Logger.getLogger(ImageController.class);
    @Autowired

    private Service service;

    @RequestMapping(value = "/myImage.htm", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") String id, HttpServletResponse response, HttpSession session, HttpServletRequest request)
            throws ServletException, IOException {
        try {
            logger.info("Enter show image:::::::: 1");
            LoginDetailsBean item = (LoginDetailsBean) session.getAttribute("loginDetails");
            item = service.getImage(id);
            System.out.println("Size of image is " + item.getUSER_IMAGE().length);
            byte[] image = item.getUSER_IMAGE();
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(image);
            response.getOutputStream().close();
        } catch (RuntimeException ex) {
        }
    }
        @RequestMapping(value = "/WorkerImage.htm", method = RequestMethod.GET)
    public void showWorkerImage(@RequestParam("id") String id, HttpServletResponse response, HttpSession session, HttpServletRequest request)
            throws ServletException, IOException {
        try {
            logger.info("Enter show image:::::::: worker");
            LoginDetailsBean item = (LoginDetailsBean) session.getAttribute("loginDetails");
            item = service.getWorkerImage(id);
            System.out.println("Size of image is " + item.getUSER_IMAGE().length);
            byte[] image = item.getUSER_IMAGE();
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(image);
            response.getOutputStream().close();
        } catch (RuntimeException ex) {
        }
    }
}
