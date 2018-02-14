/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.service;

import java.util.ArrayList;
import java.util.List;
import ms.Jwellery.dao.Dao;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suvh
 */
@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {
   static Logger logger = Logger.getLogger(ServiceImpl.class);
    @Autowired
    private Dao dao;
   @Override
    public boolean RegistrationUser(WorkerRegistrationBean registration) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.RegistrationUser(registration);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


   @Override
    public boolean getEmailValidation(String email) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside getEmailValidation Method:::::::::::::::::::");
            registrationMsg = dao.getEmailValidation(email);
            return registrationMsg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean getADHARValidation(String adhar) throws RuntimeException {
     boolean Adhar_msg = false;  
     try{
     logger.info("Enter inside getADHARValidation Method:::::::::::::::::::");
     Adhar_msg=dao.getADHARValidation(adhar);
     return Adhar_msg;
     }catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

     @Override
    public LoginDetailsBean userAuthentication(LoginDetailsBean loginDetails) throws RuntimeException {
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            loginDetails = dao.userAuthentication(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetailsBean getImage(String Phone) throws RuntimeException {
    LoginDetailsBean addImage = null;
        try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            addImage = new LoginDetailsBean();
            addImage = dao.getImage(Phone);
            return addImage;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<LoginDetailsBean> getAllWorker() throws RuntimeException {
      List<LoginDetailsBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<LoginDetailsBean>();
            list = dao.getAllWorker();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }
   
    
}
