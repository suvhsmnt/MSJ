/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.TableDataBean;

import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.service.Service;
import static ms.Jwellery.web.OrderAccesslController.logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Suvh
 */
@EnableWebMvc
@Controller
public class AjaxController {

    static Logger logger = Logger.getLogger(AjaxController.class);
    @Autowired
    private Service service;
    private LoginDetailsBean loginDetails;
    private WorkerRegistrationBean registerBean;

    @RequestMapping(value = "/updatepass.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")

    public @ResponseBody
    String updatePassword(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;

        paramMap = mapper.readValue(data, Map.class);

        FormData frmd = new FormData();
        TimeUnit.SECONDS.sleep(10);
        boolean flag = false;
        boolean flag2 = false;
        try {
            String success = "hellow";
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            registerBean = new WorkerRegistrationBean();
            registerBean.setADHAR(paramMap.get("Adhar"));
            registerBean.setPassword(paramMap.get("Oldpass"));
            registerBean.setRepassword(paramMap.get("Password"));
            logger.info("ajaxajaxajaxajaxajaxajaxajax:::::::::::::" + paramMap.get("Oldpass") + paramMap.get("Password") + paramMap.get("confirmpassword"));
            if (paramMap.get("Oldpass") == null) {
                frmd.setStatus("noy");
                frmd.setData("Done");
                logger.info("if old pass is null");
                return mapper.writeValueAsString(frmd);

            } else if (paramMap.get("Password") == null ? paramMap.get("confirmpassword") != null : !paramMap.get("confirmpassword").equals(paramMap.get("Password"))) {
                frmd.setStatus("noy");
                frmd.setData("Done");
                logger.info("if pass and confirm is mismatch");
                return mapper.writeValueAsString(frmd);

            } else {
                flag = service.Checkpass(loginDetails, paramMap.get("Oldpass"));
                logger.info(":::::::::::::" + flag);

                if (flag) {
                    flag2 = service.Resetpass(registerBean);
                    logger.info("if old pass get the credential:::::::::::::" + flag2);
                    if (flag2) {
                        frmd.setStatus("Done");
                        frmd.setData("Done");
                        logger.info("if reset pass is done:::::::::::::");
                        return mapper.writeValueAsString(frmd);

                    } else {
                        frmd.setStatus("noy");
                        frmd.setData("Done");
                        logger.info("if reset pass is not done");
                        return mapper.writeValueAsString(frmd);

                    }
                } else {

                    frmd.setStatus("noy");
                    frmd.setData("Done");
                    logger.info("if old pass didnt get the credential");
                    return mapper.writeValueAsString(frmd);
                }
            }

        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);
        }

    }
     @RequestMapping(value = "/addloss.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String AddLoss(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
        FormData frmd = new FormData();
        TableDataBean tdb=new TableDataBean(); 
  
        boolean flag = false;
        boolean flag2 = false;
        try {
            frmd.setStatus("error");
            String success = "hellow";
            String pass=null;
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
           session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            registerBean = new WorkerRegistrationBean();
            pass=paramMap.get("Password");
            registerBean.setPassword(paramMap.get("Password"));
            tdb.setAssigned_By(loginDetails.getUsername());
            tdb.setDate_of_Assign(new Date());
            tdb.setLoss_Percentage(paramMap.get("Loss"));
            tdb.setWorkerType(paramMap.get("WorkType"));
            tdb.setWorking(paramMap.get("Working"));
            tdb.setWorker(paramMap.get("Worker_id"));
            if(service.Checkpass(loginDetails,registerBean.getPassword())){
                System.out.println(paramMap.get("Worker_id"));
                if(service.AddLoss(tdb)){
                      System.out.println("hi");
                frmd.setStatus("success");
                }
                else{
                 frmd.setStatus("error");
                }
            
            }else{
            
            frmd.setStatus("error");
            }
           
            
          return mapper.writeValueAsString(frmd);

        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);
        }

    }
     @RequestMapping(value = "/editloss.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String EditLoss(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
        FormData frmd = new FormData();
        TableDataBean tdb=new TableDataBean(); 
        try {
            frmd.setStatus("error");
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            tdb.setAssigned_By(loginDetails.getUsername());
            tdb.setLoss_Percentage(paramMap.get("Loss"));
            tdb.setWorkerType(paramMap.get("WorkType"));
            tdb.setWorking(paramMap.get("Working"));
            tdb.setWorker(paramMap.get("Worker_id"));
            if(service.Checkpass(loginDetails,paramMap.get("Password"))){
                System.out.println(paramMap.get("Worker_id")+"::::");
                if(service.EditLoss(tdb)){
                      System.out.println("hi");
                frmd.setStatus("success");
                }
                else{
                 frmd.setStatus("error");
                }
            
            }else{
            
            frmd.setStatus("error");
            }
           
            
          return mapper.writeValueAsString(frmd);

        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);
        }

    }
     @RequestMapping(value = "/getLossTable.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String GetLossTable(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
  
        List<TableDataBean> tdb = null;
        try {
           
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
           session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
              if (!(loginDetails == null && session.isNew())) {
               System.out.println(paramMap.get("WorkerId"));
              tdb=service.GetLossById(paramMap.get("WorkerId"));
                      System.out.println("hi");
                }
                 return mapper.writeValueAsString(tdb);

        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
       
            
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(tdb);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
          
            
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(tdb);
        }

    }

    @RequestMapping(value = "/UpdateUser.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")

    public @ResponseBody
    String updateuser(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        paramMap = mapper.readValue(data, Map.class);
        FormData frmd = new FormData();

        LoginDetailsBean worker = null;
        worker = new LoginDetailsBean();
        boolean flag = false;
        boolean flag2 = false;
        try {
            String success = "hellow";

            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            registerBean = new WorkerRegistrationBean();
            
            registerBean.setPassword(paramMap.get("Pass"));
            registerBean.setName(paramMap.get("Name"));
            registerBean.setPhone(paramMap.get("Phone"));
            registerBean.setEmail(paramMap.get("Email"));
            registerBean.setWORKER_ID(paramMap.get("id"));
            System.out.println(paramMap.get("id"));
            flag = service.Checkpass(loginDetails, registerBean.getPassword());

            if (flag) {
                flag2 = service.UpdateDetails(registerBean);
                System.out.println("flag");
                if (flag2) {
                    worker = service.UserDetailsById(registerBean.getWORKER_ID());
                    worker.setMsg("Success");
                    System.out.println("flag2");
                    return mapper.writeValueAsString(worker);
                } else {
                    worker = service.UserDetailsById(registerBean.getWORKER_ID());
                    worker.setMsg("Wrong");
                    System.out.println("wrong");
                    return mapper.writeValueAsString(worker);
                }
            } else {
                worker = service.UserDetailsById(registerBean.getADHAR());
                worker.setMsg("Wrong");
                System.out.println("wrong 2");
                return mapper.writeValueAsString(worker);
            }

        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            worker.setMsg("null");
            return mapper.writeValueAsString(worker);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            worker.setMsg("null");
            return mapper.writeValueAsString(worker);
        }

    }

    @RequestMapping(value = "/GoldCredit.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")

    public @ResponseBody
    String GoldCredit(@RequestBody String data, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;

        paramMap = mapper.readValue(data, Map.class);
        FormData frmd = new FormData();
        TimeUnit.SECONDS.sleep(10);
        boolean flag = false;
        boolean flag2 = false;
//         if (loginDetails == null && session.isNew()) {
//                return "redirect:/login.htm";
//            }
        try {
            LoginDetailsBean worker = null;
            worker = new LoginDetailsBean();
            session = request.getSession(false);
            loginDetails = (LoginDetailsBean) session.getAttribute("LoginDetails");
            registerBean = new WorkerRegistrationBean();
            registerBean.setADHAR(paramMap.get("Adhar"));
            registerBean.setPassword(paramMap.get("Oldpass"));
            registerBean.setRepassword(paramMap.get("Password"));
            if(service.Checkpass(loginDetails, paramMap.get("Pass"))){
            if (loginDetails.getROLE().equalsIgnoreCase("Admin")) {
              
//               if(service.CreditGoldByAdmin(paramMap.get("Adhar"),paramMap.get("Gold"))) {
//               }
               frmd.setStatus("Wrong Credential"); 
                     return mapper.writeValueAsString(frmd);
            }else if (loginDetails.getROLE().equalsIgnoreCase("MANAGER")) {
//                if(service.CreditGoldBy(paramMap.get("Adhar"),paramMap.get("Gold"))) {
//               }
               frmd.setStatus("Wrong Credential"); 
                     return mapper.writeValueAsString(frmd);
            } else {
               
                     frmd.setStatus("You are not Authorised"); 
                     return mapper.writeValueAsString(frmd);
            }
        } else {
               
                     frmd.setStatus("Wrong Credential"); 
                     return mapper.writeValueAsString(frmd);
            }
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);

        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            frmd.setStatus("noy");
            frmd.setData("Done");
            logger.info("hhhhhhhhh");
            return mapper.writeValueAsString(frmd);
        }

    }
     @RequestMapping(value = "/getallworktypes.htm", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json", consumes = "application/json")
    public @ResponseBody
    String GetWorkTypes(@RequestBody String data,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> paramMap;
        logger.info("hellow....................");
        paramMap = mapper.readValue(data, Map.class);
       List<Item> all= null;
       all = new ArrayList<Item>();
       all=service.GetPrimaryItem(paramMap.get("Type"));
       logger.info("hellow...................."+ paramMap.get("Type"));
        return mapper.writeValueAsString(all);

    }
}

