/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.AllWorkerBean;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.JsonLogo;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.OrderActionBean;
import ms.Jwellery.model.TableDataBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.AjaxController.logger;
import static ms.Jwellery.web.WokerRegistrationController.logger;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.util.Base64Utils;

/**
 *
 * @author sum
 */
@EnableWebMvc
@Controller
public class OrderAccesslController {

    static Logger logger = Logger.getLogger(OrderAccesslController.class);
    private LoginDetailsBean loginDetails;
    @Autowired
    private Service service;

    @RequestMapping(value = "/getdetails.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String updatePassword(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
        String Prod_Status;
        OrderActionBean oab = new OrderActionBean();
        oab.setProdId(paramMap.get("pid"));
        System.out.println(oab.getProdId() + paramMap.get("pid") + paramMap.get("Prod"));
        Prod_Status = service.getProductStatus(paramMap.get("pid"));
        System.out.println(Prod_Status);
        oab.setProduct_Status(Prod_Status);
        oab.setStatus("success");
        return mapper.writeValueAsString(oab);
    }

    @RequestMapping(value = "/assingmaking.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String Assing_Maker(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        BigDecimal L_Percentage;
        Boolean bl = false, flag_for_order = false;
        OrderActionBean oab = new OrderActionBean();
        try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            paramMap = mapper.readValue(data, Map.class);
            oab.setProdId(paramMap.get("pid"));
            System.out.println(oab.getProdId() + paramMap.get("Maker") + paramMap.get("Maker") + paramMap.get("Loss_Percentage"));
            FormData fd = new FormData();
            fd.setMaker(paramMap.get("Maker"));
             fd.setStatus("NotGrant");
            if(loginDetails.getROLE().equalsIgnoreCase("admin")){
            fd.setStatus("Granted");
            }
            if (paramMap.get("Loss_Percentage").equals("") || paramMap.get("Loss_Percentage").equals(null)) {
                L_Percentage = service.getLossPercentageById(paramMap.get("Maker"));
                fd.setLoss_percentage(L_Percentage);
                
            } else {
                fd.setLoss_percentage(new BigDecimal(paramMap.get("Loss_Percentage")));
                System.out.println("f");
               
            }
            fd.setCurrent_Logger(loginDetails.getUsername());
            fd.setProductid(paramMap.get("pid"));
            bl = service.AssignMaking(fd);
            if (bl) {
                flag_for_order = service.UpdateProduct(paramMap.get("pid"), "AMAKING");
                if (flag_for_order) {
                    oab.setStatus("success");
                } else {
                    oab.setStatus("fail");
                }
            } else {
                oab.setStatus("fail");
            }
            return mapper.writeValueAsString(oab);
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            oab.setStatus("fail");
            return mapper.writeValueAsString(oab);
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            oab.setStatus("fail");
            return mapper.writeValueAsString(oab);
        }
    }

    @RequestMapping(value = "/getallworker.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String GetworkerBytype(@RequestBody String data,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        logger.info("hellow....................");
        paramMap = mapper.readValue(data, Map.class);
        List<AllWorkerBean> list = null;
        list = service.getAllWorkerByType( paramMap.get("Type"));
        logger.info("hellow...................."+ paramMap.get("Type"));
        return mapper.writeValueAsString(list);

    }
   
 @RequestMapping(value = "/gettableData.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String GetTableData(@RequestBody String data,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        TableDataBean tdb=null;
         paramMap = mapper.readValue(data, Map.class);
        logger.info("hellow...................."+paramMap.get("Pid"));     
        List<TableDataBean> list = null;
        tdb=service.getMakingByPid( paramMap.get("Pid"));
         logger.info("hellow....................");
//        list.add(0,tdb);
        logger.info("hellow...................."+ paramMap.get("Pid"));
        logger.info("hellow....................");
        return mapper.writeValueAsString(tdb);

    }
    @RequestMapping(value = "/imagetest.htm", method = RequestMethod.POST)
    public @ResponseBody
    String echoFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("inseide echo file..........>>>>>");
        MultipartFile multipartFile = request.getFile("idLogoFile");
        if (multipartFile == null) {
            logger.info("inseide echo file..........>>>>>1");
        }
        Long size = multipartFile.getSize();
        logger.info("inseide echo file..........>>>>>2");
        String contentType = multipartFile.getContentType();
        InputStream stream = multipartFile.getInputStream();
        byte[] bytes = IOUtils.toByteArray(stream);
        logger.info("inseide echo file..........>>>>>" + contentType);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fileoriginalsize", size);
        map.put("contenttype", contentType);
        map.put("base64", new String(Base64Utils.encode(bytes)));
        JsonLogo logo = new JsonLogo();
        if (multipartFile.getBytes().length > 0) {
            logo.setImage(new String(Base64Utils.encode(multipartFile.getBytes())));
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(logo);
    }
@RequestMapping(value = "/receivemaking.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String Receive_Making(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
     ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        FormData fd = new FormData();
        Boolean bl = false, flag_for_order = false;
         try {
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            paramMap = mapper.readValue(data, Map.class);
            logger.info("hi i am inside receivemaking ");
            System.out.println( paramMap.get("Pid") + paramMap.get("Return_Stone") + paramMap.get("Return_Gold"));
            bl=service.ReciveMaking(paramMap.get("Pid"),paramMap.get("Return_Stone"),paramMap.get("Return_Gold"));
            fd.setStatus("success");
           if(!bl){
            fd.setStatus("NotGrant");
           }
            return mapper.writeValueAsString(fd);
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            fd.setStatus("NotGrant");
            return mapper.writeValueAsString(fd);
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
             fd.setStatus("NotGrant");
            return mapper.writeValueAsString(fd);
        }
    }
}
