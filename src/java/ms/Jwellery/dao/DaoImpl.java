/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.model.WorkerRegistrationBean;

import ms.Jwellery.presistence.WorkerRegistration;
import ms.Jwellery.presistence.WorkerRegistrationId;
import ms.Jwellery.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Suvh
 */
@Repository("dao")
public class DaoImpl implements Dao {
 static Logger logger = Logger.getLogger(DaoImpl.class);
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public boolean RegistrationUser(WorkerRegistrationBean registration) throws RuntimeException {
         Session session = null;
        Transaction transaction = null;
        boolean flag = false;
////        long productId = this.rowCount();
//        productId = productId + 1;
      Long lObj = new Long(10);
        try {
            logger.info("Enter inside DAO sellerRegistration() method::::::::::::::");
//            logger.info("Create session object:::::::::::::::" + productId);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            // Blob blob=Hibernate.createBlob();
//            typ = addProductBean.getType();
            WorkerRegistration user = new WorkerRegistration();
            WorkerRegistrationId userid = new WorkerRegistrationId();
            userid.setWorkerId("101");
            userid.setWorkerAdhar(registration.getADHAR());
            user.setWorkerName(registration.getName());
            user.setWorkerEmail(registration.getEmail());
            user.setWorkerGold(registration.getGOLD());
            user.setWorkerNetbal(registration.getNETBAL());
            user.setWorkerStone(registration.getSTONE());
            user.setWorkerAddress(registration.getADDRESS());
            user.setWorkerMobile(registration.getPhone());
            user.setWorkerPassword(registration.getPassword());
            user.setPassToken(0);
            user.setId(userid);
            user.setLogDt(new Date());
            user.setImageName(registration.getFileName());
            user.setWorkerImage(registration.getFiledata().getBytes());
            System.out.println("lenght is>>>>>>>>>>>>" + registration.getFiledata().getBytes().length);
            
            
            
//            pDetails.setProductName(addProductBean.getProductName());
//            pDetails.setProductType(addProductBean.getType());
//            pDetails.setImageName(addProductBean.getFileName());
//            pDetails.setProductImage(addProductBean.getFiledata().getBytes());
//            System.out.println("lenght is>>>>>>>>>>>>" + addProductBean.getFiledata().getBytes().length);
//            pDetails.setProductPrice(addProductBean.getPrice());
//            pDetails.setProductDesc(addProductBean.getDescription());
//            pDetails.setSellername(addProductBean.getUname());
            session.save(user);
            System.out.println("lenght is>>>>>>>>>>>>1"+registration.getPhone());
            transaction.commit();
            System.out.println("lenght is>>>>>>>>>>>>2");
            flag = true;

        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }

   
    @Override
    public boolean getEmailValidation(String email) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            logger.info("Enter inside DAO getEmailValidation method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("id.workerEmail", email));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                flag = true;
            }
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean getADHARValidation(String adhar) throws RuntimeException {
     Session session = null;
        boolean flag = false;
        try{
          logger.info("inside getADHARValidation method>>>>>>>>> 0");
        session=sessionFactory.openSession();
        Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("id.workerAdhar", adhar));
            logger.info("inside getADHARValidation method>>>>>>>>> 1");
             if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                logger.info("inside getADHARValidation method>>>>>>>>>2 ");
                 flag = true;
            }
             return(flag);
        }catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

     @Override
    public LoginDetailsBean userAuthentication(LoginDetailsBean loginDetails) throws RuntimeException {
        Session session = null;

        try {
            logger.info("Enter inside userAuthentication ():::::::::::::::::::");
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(WorkerRegistration.class);
            
            loginCriteria.add(Restrictions.eq("id.workerAdhar", loginDetails.getAdhar()));
            System.out.println("lenght is>>>>>>>>>>>>1"+loginDetails.getAdhar());
            loginCriteria.add(Restrictions.eq("workerPassword", loginDetails.getPassword()));
            System.out.println("lenght is>>>>>>>>>>>>1"+loginDetails.getPassword());
           logger.info("Enter inside userAuthentication ():::::::::::::::::::");
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
                    logger.info("Enter inside userAuthentication ():::::::::::::::::::");
                    WorkerRegistration regUser = (WorkerRegistration) it.next();
                    loginDetails = new LoginDetailsBean();
                    loginDetails.setEmail(regUser.getWorkerEmail());
                    loginDetails.setName(regUser.getWorkerName());
                    loginDetails.setPhone(regUser.getWorkerMobile());
//                    loginDetails.setUSER_IMAGE(regUser.getWorkerImage());
                    loginDetails.setPass(regUser.getPassToken());
//                    loginDetails.setFristName(regUser.getFristName());
//                    loginDetails.setLastName(regUser.getLastName());
//                    loginDetails.setName(regUser.getId().getUserName());
//                    loginDetails.setAddress(regUser.getAddress());
//                    loginDetails.setPinCode(regUser.getPinCode());
//                    loginDetails.setMobileNo(regUser.getMobileNo());
//                    loginDetails.setEmailId(regUser.getId().getEmailId());
//                    loginDetails.setPassword(regUser.getUserPassword());
                }
            } else {
                loginDetails = null;
            }
            return loginDetails;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public LoginDetailsBean getImage(String Phone) throws RuntimeException {
    Session session = null;
        LoginDetailsBean addImage = null;
        try {
            session = sessionFactory.openSession();
             logger.info("Enter getImage  ::::::::");
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("workerMobile", Phone));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    addImage = new LoginDetailsBean();
                    WorkerRegistration pp = (WorkerRegistration) iterator.next();
                    addImage.setPass(1);
                    logger.info("Enter inside getimage section 1():::::::::::::::::::");
                    addImage.setUSER_IMAGE(pp.getWorkerImage());
                     logger.info("Enter inside getimage section 2():::::::::::::::::::");
                }
            }
             logger.info("Enter inside getimage section 3():::::::::::::::::::");
            return addImage;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            runEx.printStackTrace();
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<LoginDetailsBean> getAllWorker() throws RuntimeException {
       Session session = null;
        List<LoginDetailsBean> Workers = null;
        Workers = new ArrayList<LoginDetailsBean>();

        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.setMaxResults(10);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    LoginDetailsBean m = new LoginDetailsBean();
                    WorkerRegistration meeting = (WorkerRegistration) iterator.next();
             
                    m.setName(meeting.getWorkerName());
                    m.setPhone(meeting.getWorkerMobile());
                    
                    
                    
                    
//                    m.setProductId(meeting.getProductId());
//                    m.setProductName(meeting.getProductName());
//                    m.setPrice(meeting.getProductPrice());
                    Workers.add(m);
                }

            }
            return Workers;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
