/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import ms.Jwellery.model.AddOrderBean;
import ms.Jwellery.model.AllWorkerBean;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.OrderDivideBean;
import ms.Jwellery.model.TableDataBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.model.WorkerSalaryBean;
import ms.Jwellery.presistence.Customer;
import ms.Jwellery.presistence.CustomerGoldstock;
import ms.Jwellery.presistence.CustomerGoldstockId;
import ms.Jwellery.presistence.CustomerId;
import ms.Jwellery.presistence.ItemTable;
import ms.Jwellery.presistence.LossWorkerSalary;
import ms.Jwellery.presistence.Making;
import ms.Jwellery.presistence.OrderDescription;
import ms.Jwellery.presistence.OrderDetails;
import ms.Jwellery.presistence.Product;
import ms.Jwellery.presistence.UserDetails;
import ms.Jwellery.presistence.UserDetailsId;
import ms.Jwellery.presistence.UserRole;
import ms.Jwellery.presistence.WorkerLoss;
import ms.Jwellery.presistence.WorkerLossId;
import ms.Jwellery.presistence.WorkerRegistration;
import ms.Jwellery.presistence.WorkerRegistrationId;
import ms.Jwellery.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
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
        long productId = this.rowCountuser();
        productId = productId + 1;
        Long lObj = new Long(productId);
        try {
            logger.info("Enter inside DAO RegistrationUser() method::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            WorkerRegistration user = new WorkerRegistration();
            WorkerRegistrationId userid = new WorkerRegistrationId();
            userid.setWorkerAdhar(registration.getADHAR());
            user.setWorkerName(registration.getName());
            user.setWorkerEmail(registration.getEmail());
            user.setForgotPassword("NOTASSIGNED");
            user.setWorkerAddress(registration.getADDRESS());
            user.setWorkerMobile(registration.getPhone());
            user.setWorkerPassword(registration.getPassword());
            userid.setUserName(registration.getUsername());
            userid.setWorkerId(lObj.toString());
            user.setId(userid);
            user.setWorkerType(registration.getWorker_des());
            user.setWorkerStatus("JOINED");
            user.setWorkerSalary(registration.getSalary().toString());
            user.setWorkerAddedBy(registration.getWORKER_ADDED_BY());
            user.setLogDt(new Date());
            user.setImageName(registration.getFileName());
            user.setWorkerImage(registration.getFiledata().getBytes());
            System.out.println("lenght is>>>>>>>>>>>>22" + registration.getFiledata().getBytes().length);
            session.save(user);
            System.out.println("lenght is>>>>>>>>>>>>1" + registration.getPhone());
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
    public long rowCountuser() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
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
    public boolean getEmailValidation(String email) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            logger.info("Enter inside DAO getEmailValidation() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("workerEmail", email));
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
        try {
            logger.info("Enter inside DAO getADHARValidation() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("id.workerAdhar", adhar));
            logger.info("inside getADHARValidation method>>>>>>>>> 1");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                logger.info("inside getADHARValidation method>>>>>>>>>2 ");
                flag = true;
            }
            return (flag);
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
    public LoginDetailsBean userAuthentication(LoginDetailsBean loginDetails) throws RuntimeException {
        Session session = null;
         String role=null;
        try {
            logger.info("Enter inside userAuthentication() method:::::::::::::::::::");
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(UserDetails.class);
            loginCriteria.add(Restrictions.eq("id.userLogin", loginDetails.getUsername()));
            System.out.println("lenght is>>>>>>>>>>>>" + loginDetails.getUsername());
            loginCriteria.add(Restrictions.eq("userPassword", loginDetails.getPassword()));
            System.out.println("lenght is>>>>>>>>>>>>" + loginDetails.getPassword());
            logger.info("Enter inside userAuthentication ():::::::::::::::::::");
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
//                    logger.info("Enter inside userAuthentication ():::::::::::::::::::");
                    UserDetails User = (UserDetails) it.next();
                    loginDetails = new LoginDetailsBean();
                    loginDetails.setEmail(User.getUserEmail());
                    loginDetails.setName(User.getUserName());
                    loginDetails.setPhone(User.getUserMobile());
                    loginDetails.setId(User.getId().getUserId());
                    loginDetails.setAdhar(User.getId().getUserAdhar());
                    loginDetails.setUsername(User.getId().getUserLogin());
                    role=User.getRoleId();
                      logger.info("Enter inside userAuthentication ():::::::::::::::::::"+ loginDetails.getROLE());
                }
            
              loginCriteria = session.createCriteria(UserRole.class); 
               loginCriteria.add(Restrictions.eq("roleId",role));
               logger.info("Enter inside userAuthentication ():::::::::::::::::::1"+role);
               if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                logger.info("Enter inside userAuthentication ():::::::::::::::::::1");
                 Iterator iterator = loginCriteria.list().iterator();
                while (iterator.hasNext()) {
                     UserRole Ur= (UserRole) iterator.next();
                 logger.info("Enter inside userAuthentication ():::::::::::::::::::1");
                loginDetails.setROLE(Ur.getRoleName());
                }
               }
            } else {
                 logger.info("Enter inside userAuthentication ():::::::::::::::::::1");
                loginDetails = null;
            }
            return loginDetails;
        }catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public LoginDetailsBean getImage(String id) throws RuntimeException {
        Session session = null;
        LoginDetailsBean addImage = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(UserDetails.class);
            criteria.add(Restrictions.eq("id.userId", id));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    addImage = new LoginDetailsBean();
                    UserDetails pp = (UserDetails) iterator.next();

                    addImage.setUSER_IMAGE(pp.getUserImage());
                }
            }
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
            logger.info("Enter inside dao getAllWorker  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
//            criteria.add(Restrictions.not(Restrictions.like("userRole", "ADMIN")));
            
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    LoginDetailsBean m = new LoginDetailsBean();
                    WorkerRegistration meeting = (WorkerRegistration) iterator.next();
//                    m.setWorker_Id(meeting.getId());
                     m.setWorker_Id(meeting.getId().getWorkerId());
                    m.setAdhar(meeting.getId().getWorkerAdhar());
                    m.setName(meeting.getWorkerName());
                    m.setPhone(meeting.getWorkerMobile());
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
    
    @Override
    public boolean RegistrationCustomer(WorkerRegistrationBean regDetails) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        long productId = this.rowCountcustomer();
        productId = productId + 1;
        Long lObj = new Long(productId);
        try {
            logger.info("Enter inside DAO RegistrationUser() method::::::::::::::");
            logger.info("Create session object:::::::::::::::" + productId);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Customer customer = new Customer();
            CustomerId customerid = new CustomerId();
            customerid.setCustomerId(lObj.toString());
            customer.setCustomerEmail(regDetails.getEmail());
            customer.setCustomerName(regDetails.getName());
            customer.setCustomerAddress(regDetails.getADDRESS());
            customerid.setCustomerGst(regDetails.getGST());
            customerid.setCustomerMobile(regDetails.getPhone());
            customer.setId(customerid);
            customer.setCustomerAddedBy(regDetails.getWORKER_ADDED_BY());
            customer.setLogDt(new Date());
            session.save(customer);
            System.out.println("lenght is>>>>>>>>>>>>1" + regDetails.getPhone());
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
    public long rowCountcustomer() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
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
    public long rowCountOrder() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(OrderDetails.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
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
    public long rowCountOrderDivide() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(OrderDescription.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
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
    public long rowCountProduct() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
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
    public boolean OrderRegistration(AddOrderBean OrderBean) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        boolean divide = false;
        long productId = this.rowCountOrder();
        productId = productId + 1;
        Long lObj = new Long(productId);
        String OrderId = "OR" + lObj;
        try {
            
            logger.info("Enter inside DAO OrderRegistration() method::::::::::::::" + OrderId);
            OrderBean.setORDER_ID(OrderId);
            logger.info("Create session object:::::::::::::::" + OrderBean.getCUSTOMER_ID() + OrderBean.getR_NAME());
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            OrderDetails ordr = new OrderDetails();
            ordr.setCustomerId(OrderBean.getCUSTOMER_ID());
            ordr.setOrderId(OrderId);
            ordr.setSalseMan(OrderBean.getR_NAME());
            ordr.setTotalQuantity(OrderBean.getTOTAL_QUANTITY());
            ordr.setOrderStatus("1");
            ordr.setOrderAddedBy(OrderBean.getORDER_ADDED_BY());
            ordr.setLogDt(new Date());
            logger.info("Create session object:::::::::::::::" + OrderBean.getCUSTOMER_ID() + OrderBean.getR_NAME());
            session.save(ordr);
            transaction.commit();
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
    public boolean DivideOrder(AddOrderBean OrderBean, int i) {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        long productId = this.rowCountOrderDivide();
        productId = productId + 1;
        Long lObj = new Long(productId);
        String OrderDivideId = "ORD" + lObj;
        OrderDivideBean data = OrderBean.getOrder().get(i);
        try {
            data.setORDER_Divide_ID(OrderDivideId);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            OrderDescription ordrdes = new OrderDescription();
            ordrdes.setOrderType(data.getTYPE());
            ordrdes.setOrderQuantity(data.getQUANTITY());
            ordrdes.setAvgWt(data.getAVG_WT());
            ordrdes.setOrderDivideId(OrderDivideId);
            ordrdes.setOrderId(OrderBean.getORDER_ID());
            ordrdes.setLogDt(new Date());
            session.save(ordrdes);
            transaction.commit();
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
    public List<AddOrderBean> getAllOrder() throws RuntimeException {
        Session session = null;
        List<AddOrderBean> order = null;
        order = new ArrayList<AddOrderBean>();
        int s = 0;
        
        try {
            logger.info("Enter inside dao getAllWorker  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(OrderDetails.class);
//            criteria.setMaxResults(30);
            criteria.add(Restrictions.eq("orderStatus", "1"));
            logger.info("Enter inside while getAllWorker  1::::::::");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                logger.info("Enter inside while getAllWorker 2 ::::::::");
                while (iterator.hasNext()) {
                    AddOrderBean m = new AddOrderBean();
                    OrderDetails meeting = (OrderDetails) iterator.next();
                    logger.info("Enter inside while getAllWorker  ::::::::");
                    m.setCUSTOMER_ID(meeting.getCustomerId());
                    m.setORDER_ID(meeting.getOrderId());
                    m.setR_NAME(meeting.getSalseMan());
                    m.setTOTAL_QUANTITY(meeting.getTotalQuantity());
                    m.setDate(meeting.getLogDt());
                    order.add(m);
                }
            }
            return order;
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
    public LoginDetailsBean Forgotpass(LoginDetailsBean loginDetails) throws RuntimeException {
        Session session = null;
        try {
            logger.info("Enter inside userAuthentication() method:::::::::::::::::::");
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(WorkerRegistration.class);
            loginCriteria.add(Restrictions.eq("workerEmail", loginDetails.getEmail()));
            System.out.println("lenght is>>>>>>>>>>>>1" + loginDetails.getEmail());
            logger.info("Enter inside userAuthentication ():::::::::::::::::::");
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
//                    logger.info("Enter inside userAuthentication ():::::::::::::::::::");
                    WorkerRegistration regUser = (WorkerRegistration) it.next();
                    
                    loginDetails = new LoginDetailsBean();
                    loginDetails.setEmail(regUser.getWorkerEmail());
                    loginDetails.setName(regUser.getWorkerName());
                    loginDetails.setPhone(regUser.getWorkerMobile());
                    loginDetails.setAdhar(regUser.getId().getWorkerAdhar());
                    
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
    public LoginDetailsBean UserDetailsById(String id) throws RuntimeException {
        Session session = null;
        LoginDetailsBean list = null;
        list = new LoginDetailsBean();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            logger.info("Enter inside UserDetailsById ()111111:::::::::::::::::::" + id);
            // criteria.add(Restrictions.i)
            // criteria.add(Restrictions.in("productType",));
            criteria.add(Restrictions.eq("id.workerId", id));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    // AddProductBean addp = new AddProductBean();
                    WorkerRegistration wr = (WorkerRegistration) iterator.next();
                    list.setEmail(wr.getWorkerEmail());
                    list.setPhone(wr.getWorkerMobile());
                    list.setAddress(wr.getWorkerAddress());
                    list.setAdhar(wr.getId().getWorkerAdhar());
                    list.setWorker_Id(wr.getId().getWorkerId());
                    list.setUsername(wr.getId().getUserName());
                    list.setDate(wr.getLogDt());
                    list.setName(wr.getWorkerName());
                }
            }
            return list;
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
    public boolean Resetpass(WorkerRegistrationBean regDetails) throws RuntimeException {
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count = 0;
        System.out.println("hellow00");
        String hql = "update WorkerRegistration reguser set reguser.workerPassword=:pass where reguser.id.workerAdhar=:adhar";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            System.out.println("hellow00");
            Query query = session.createQuery(hql);
            System.out.println("hellow000");
            query.setParameter("pass", regDetails.getRepassword());
            query.setParameter("adhar", regDetails.getADHAR());
            System.out.println("hellow1");
            count = query.executeUpdate();
            System.out.println("hellow2");
            if (count > 0) {
                System.out.println("hellow3");
                transaction.commit();
                System.out.println("hellow3..........................");
                resetMsg = true;
            }
            return resetMsg;
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
    public boolean Checkpass(LoginDetailsBean loginDetails, String oldpass) throws RuntimeException {
        Session session = null;
        boolean msg = false;
        try {
            logger.info("Enter inside Checkpass() method:::::::::::::::::::" + loginDetails.getUsername() + "++" + oldpass);
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(UserDetails.class);
            logger.info("Enter inside Checkpass() inside true method:::::::::::::::::::1");
            loginCriteria.add(Restrictions.eq("id.userLogin", loginDetails.getUsername()));
            loginCriteria.add(Restrictions.eq("userPassword", oldpass));
            logger.info("Enter inside Checkpass() inside true method:::::::::::::::::::2");
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                msg = true;
                logger.info("Enter inside Checkpass() inside true method:::::::::::::::::::3");
            }
            logger.info("Enter inside Checkpass() inside true method:::::::::::::::::::4");
            return msg;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @Override
    public boolean UpdateDetails(WorkerRegistrationBean registerBean) throws RuntimeException {
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count = 0;
        String hql = "update WorkerRegistration reguser set reguser.workerEmail=:email,reguser.workerMobile=:phone,reguser.workerName=:name where reguser.id.workerId=:id";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("email", registerBean.getEmail());
            query.setParameter("phone", registerBean.getPhone());
            query.setParameter("name", registerBean.getName());
            query.setParameter("id", registerBean.getWORKER_ID());
            System.out.println(registerBean.getEmail() + registerBean.getPhone() + registerBean.getName()+registerBean.getWORKER_ID() );
            count = query.executeUpdate();
            if (count > 0) {
                System.out.println("hellow3");
                transaction.commit();
                System.out.println("hellow3..........................");
                resetMsg = true;
            }
            return resetMsg;
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
    public List<WorkerRegistrationBean> getAllCustomer() throws RuntimeException {
        Session session = null;
        List<WorkerRegistrationBean> customer = null;
        customer = new ArrayList<WorkerRegistrationBean>();
        int s = 0;
        try {
            logger.info("Enter inside dao getAllCustomer  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Customer.class);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    WorkerRegistrationBean item = new WorkerRegistrationBean();
                    Customer csmr = (Customer) iterator.next();
                    
                    item.setCID(csmr.getId().getCustomerId());
                    item.setName(csmr.getCustomerName());
                    item.setGST(csmr.getId().getCustomerGst());
                    item.setWORKER_ADDED_BY(csmr.getCustomerAddedBy());
                    item.setEmail(csmr.getCustomerEmail());
                    customer.add(item);
                }
            }
            return customer;
            
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
    public boolean EachOrderBytype(OrderDivideBean order) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        long productId = this.rowCountProduct();
        productId = productId + 1;
        Long lObj = new Long(productId);
        String ProductID = "PID" + lObj;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product prod = new Product();
            prod.setProductId(ProductID);
            prod.setLogDt(new Date());
            prod.setOrderDivideId(order.getORDER_Divide_ID());
            prod.setActWt(order.getAVG_WT());
            prod.setOrderStatus("Wait");
            prod.setOrderType(order.getTYPE());
            session.save(prod);
            transaction.commit();
            
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
    public List<OrderDivideBean> getAllProduct(String ID) throws RuntimeException {
        Session session = null;
        List<OrderDivideBean> order = null;
        order = new ArrayList<OrderDivideBean>();
        try {
            logger.info("Enter inside dao getAllWorker  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Product.class);
//            criteria.setMaxResults(30);
            criteria.add(Restrictions.eq("orderDivideId", ID));
            logger.info("Enter inside while getAllWorker  1::::::::");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                logger.info("Enter inside while getAllWorker 2 ::::::::");
                while (iterator.hasNext()) {
                    OrderDivideBean m = new OrderDivideBean();
                    Product prod = (Product) iterator.next();
                    logger.info("Enter inside while getAllWorker  ::::::::");
                    m.setORDER_Divide_ID(prod.getOrderDivideId());
                    m.setStatus(prod.getOrderStatus());
                    m.setAVG_WT(prod.getActWt());
                    m.setProdId(prod.getProductId());
                    m.setTYPE(prod.getOrderType());
                    order.add(m);
                }
            }
            return order;
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
    public List<OrderDivideBean> getAllByOrderId(String ID) throws RuntimeException {
        Session session = null;
        List<OrderDivideBean> order = null;
        order = new ArrayList<OrderDivideBean>();
        try {
            logger.info("Enter inside dao getAllWorker  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(OrderDescription.class);
//            criteria.setMaxResults(30);
            criteria.add(Restrictions.eq("orderId", ID));
            logger.info("Enter inside while getAllWorker  1::::::::");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                logger.info("Enter inside while getAllWorker 2 ::::::::");
                while (iterator.hasNext()) {
                    OrderDivideBean m = new OrderDivideBean();
                    OrderDescription prod = (OrderDescription) iterator.next();
                    logger.info("Enter inside while getAllWorker  ::::::::");
                    m.setORDER_Divide_ID(prod.getOrderDivideId());
                    m.setTYPE(prod.getOrderType());
                    
                    order.add(m);
                }
            }
            return order;
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
    public List<AllWorkerBean> getAllWorkerByType(String Type) throws RuntimeException {
        Session session = null;
        List<AllWorkerBean> Workers = null;
        Workers = new ArrayList<AllWorkerBean>();
        
        try {
            logger.info("Enter inside dao getAllWorker  ::::::::" + Type);
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("workerType", Type));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AllWorkerBean m = new AllWorkerBean();
                    WorkerRegistration worker = (WorkerRegistration) iterator.next();
                    m.setName(worker.getWorkerName());
                    m.setADHAR(worker.getId().getWorkerAdhar());
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
    
    @Override
    public String getProductStatus(String get) throws RuntimeException {
        
        Session session = null;
        String Status = null;
        
        try {
            logger.info("Enter inside dao getProductStatus  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Product.class);
            logger.info("Enter inside dao getProductStatus  ::::::::1");
            criteria.add(Restrictions.eq("productId", get));
            logger.info("Enter inside dao getProductStatus  ::::::::2");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    logger.info("Enter inside dao getProductStatus  ::::::::3");
                    Product product = (Product) iterator.next();
                    Status = product.getOrderStatus();
                }
            }
            return Status;
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
    public BigDecimal getLossPercentageById(String Wid) throws RuntimeException {
        Session session = null;
        BigDecimal L_PERCENTAGE = null;
        
        try {
            logger.info("Enter inside dao getProductStatus  ::::::::");
            session = sessionFactory.openSession();
//            Criteria criteria = session.createCriteria(Worker.class);
//            logger.info("Enter inside dao getProductStatus  ::::::::1");
//            criteria.add(Restrictions.eq("id.workerId", Wid));
//            logger.info("Enter inside dao getProductStatus  ::::::::2");
////            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
////                Iterator iterator = criteria.list().iterator();
////                while (iterator.hasNext()) {
////                    logger.info("Enter inside dao getProductStatus  ::::::::3");
////                    Worker WR = (Worker) iterator.next();
////                    L_PERCENTAGE = WR.getLossPercentage();
////                }
//            }
            return L_PERCENTAGE;
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
    public boolean AssignMaking(FormData fd) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        BigDecimal bd = new BigDecimal(0.00);
        
        try {
            logger.info("Enter inside DAO RegistrationUser() method::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Making mk = new Making();
            mk.setMakingId(getMakingId());
            mk.setLossPercentage(fd.getLoss_percentage());
            mk.setLogDt(new Date());
            mk.setOrderId(fd.getProductid());
            mk.setReturnGold(bd);
            mk.setReturnStone(bd);
            mk.setAssignBy(fd.getCurrent_Logger());
            mk.setAssignStatus(fd.getStatus());
            mk.setWorkerId(fd.getMaker());
            session.save(mk);
            transaction.commit();
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
    public boolean UpdateProduct(String get, String MSG) throws RuntimeException {
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count;
        String hql = "update Product prd  set orderStatus=:status where prd.productId=:id";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("id", get);
            query.setParameter("status", MSG);
            
            count = query.executeUpdate();
            
            if (count > 0) {
                
                transaction.commit();
                
                resetMsg = true;
            }
            return resetMsg;
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
    public TableDataBean getMakingByPid(String id) throws RuntimeException {
        Session session = null;
        TableDataBean tdb = null;
        
        try {
            logger.info("Enter inside dao getMakingByPid  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Making.class);
            logger.info("Enter inside dao getMakingByPid  ::::::::1");
            criteria.add(Restrictions.eq("orderId", id));
            logger.info("Enter inside dao getMakingByPid  ::::::::2");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    tdb = new TableDataBean();
                    logger.info("Enter inside dao getProductStatus  ::::::::3");
                    Making MK = (Making) iterator.next();
                    tdb.setAssigned_By(MK.getAssignBy());
                    tdb.setDate_of_Assign(MK.getLogDt());
                    
                    tdb.setGIVEN_GOLD("--");
                    tdb.setGiven_Stone("--");
                    tdb.setLoss_Percentage(MK.getLossPercentage().toString());
                    tdb.setReturn_Stone(MK.getReturnStone().toString());
                    tdb.setReturn_GOLD(MK.getReturnGold().toString());
                    tdb.setTable("MAKING");
                    tdb.setWorker(MK.getWorkerId());
                    logger.info("Enter inside dao getProductStatus  ::::::::4");
                }
            }
            logger.info("Enter inside dao getProductStatus  ::::::::5");
            return tdb;
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
    public boolean ReciveMaking(String pid, String R_GOLD, String R_STONE) throws RuntimeException {
        
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count, SLNO;
        long sal_count = 0, lon = 0000000;
        
        BigDecimal Credit, a, b, cb, x;
        String worker, s, L_Percentage, sl_no, Last_update, z;
        worker = null;
        L_Percentage = null;
        sl_no = "0";
        Last_update = "0";
        SLNO = 0;
        Credit = new BigDecimal(R_GOLD);
        String hql = "update Making mk set returnGold=:R_GOLD,returnStone=:R_STONE where mk.orderId=:pid";
        try {
            logger.info("Enter inside dao ReciveMaking  ::::::::3");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            logger.info("Enter inside dao ReciveMaking  ::::::::3");
            Query query = session.createQuery(hql);
            logger.info("Enter inside dao ReciveMaking  ::::::::3");
            a = new BigDecimal(R_GOLD);
            b = new BigDecimal(R_STONE);
            query.setParameter("R_GOLD", a);
            query.setParameter("R_STONE", b);
            query.setParameter("pid", pid);
            logger.info("Enter inside dao ReciveMaking  ::::::::3" + R_GOLD + R_STONE + pid);
            count = query.executeUpdate();
            logger.info("Enter inside dao ReciveMaking  ::::::::3");
            
            if (count > 0) {
                
                session.flush();
                
                logger.info("Enter inside dao ReciveMaking  after 1 ::::::::3");
                Criteria criteria = session.createCriteria(Making.class);
//            criteria.setMaxResults(30);
                criteria.add(Restrictions.eq("orderId", pid));
                
                if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                    Iterator iterator = criteria.list().iterator();
                    
                    while (iterator.hasNext()) {
                        
                        Making MK = (Making) iterator.next();
                        worker = MK.getWorkerId();
                        L_Percentage = MK.getLossPercentage().toString();
                    }
                }
                session.flush();
                
                logger.info("Enter inside dao ReciveMaking   after 2::::::::3");
                criteria = session.createCriteria(Making.class);
//            criteria.setMaxResults(30);
                criteria.add(Restrictions.eq("orderId", pid));
                
                if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                    Iterator iterator = criteria.list().iterator();
                    
                    while (iterator.hasNext()) {
                        
                        Making MK = (Making) iterator.next();
                        
                        worker = MK.getWorkerId();
                        L_Percentage = MK.getLossPercentage().toString();
                    }
                }
                session.flush();
                
                logger.info("Enter inside dao ReciveMaking after 3  ::::::::3" + worker);
                criteria = session.createCriteria(LossWorkerSalary.class);
                criteria.add(Restrictions.eq("workerId", worker));
                logger.info("Enter inside dao ReciveMaking after 3  ::::::::3.5");
                if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                    Iterator iterator = criteria.list().iterator();
                    logger.info("Enter inside dao ReciveMaking after 3  ::::::::3.6");
                    while (iterator.hasNext()) {
                        
                        LossWorkerSalary lw = (LossWorkerSalary) iterator.next();
                        
                        if (Integer.parseInt(sl_no) < Integer.parseInt(lw.getSlNo())) {
                            sl_no = lw.getSlNo();
                            Last_update = lw.getCurrentBalance();
                        }
                        
                    }
                }
                session.flush();
                
                criteria = session.createCriteria(LossWorkerSalary.class);

//            criteria.setMaxResults(30);
                criteria.setProjection(Projections.rowCount());
                if (criteria.list().size() > 0) {
                    sal_count = (Long) criteria.list().get(0);
                }
                
                logger.info("Enter inside dao ReciveMaking  after 4 ::::::::3");
                
                session.flush();
                logger.info("Enter inside dao ReciveMaking  after 4 ::::::::4");
                hql = "update Product prd  set orderStatus=:status where prd.productId=:id";
                query = session.createQuery(hql);
                query.setParameter("id", pid);
                query.setParameter("status", "RMAKING");
                count = query.executeUpdate();
                logger.info("Enter inside dao ReciveMaking  after 4 ::::::::5");
                if (count > 0) {
                    session.flush();
                    session.clear();
                    LossWorkerSalary lwsid = new LossWorkerSalary();
                    
                    SLNO = Integer.parseInt(sl_no) + 1;
                    lwsid.setSlNo(Integer.toString(SLNO));
                    lwsid.setPurpose("EARNED FORM :" + pid);
                    lwsid.setLogDt(new Date());
                    lwsid.setWorkerId(worker);
                    lwsid.setGoldCurrency("0000");
                    s = "TXN" + sal_count;
                    sal_count = sal_count + lon;
                    s = "TXN" + Long.toString(sal_count);
                    lwsid.setTxnId(s);
                    lwsid.setLastUpdate(Last_update);
                    Credit = (new BigDecimal(L_Percentage)).multiply(Credit).divide(BigDecimal.valueOf(100));
                    cb = new BigDecimal(Last_update).add(Credit);
                    lwsid.setCreditDebit("+" + Credit);
                    x = Credit.add(new BigDecimal(Last_update));
                    lwsid.setCurrentBalance(x.toString());
                    session.save(lwsid);
                    session.flush();
                    transaction.commit();
                    logger.info("Enter inside dao ReciveMaking  after 4 ::::::::6");
                    resetMsg = true;
                }
            }
            
            logger.info("Enter inside dao ReciveMaking after 5 ::::::::3");
            return resetMsg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                System.out.println("session close");
                session.close();
            }
        }
    }
    
    @Override
    public List<WorkerSalaryBean> getPendingRequest(String adhar) throws RuntimeException {
        Session session = null;
        List<WorkerSalaryBean> wsb = null;
        wsb = new ArrayList<WorkerSalaryBean>();
        
        try {
            logger.info("Enter inside dao getAllWorker  ::::::::" + adhar);
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Making.class);
            criteria.add(Restrictions.eq("assignStatus", "NotGrant"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {                    
                    
                    WorkerSalaryBean m = new WorkerSalaryBean();
                    Making MK = (Making) iterator.next();
                    m.setMaking_ID(MK.getMakingId());
                    m.setPID(MK.getOrderId());
                    m.setStatus(MK.getAssignStatus());
                    m.setWorker_Id(MK.getWorkerId());
                    m.setL_Percentage(MK.getLossPercentage().toString());
                    
                    wsb.add(m);
                }
            }
            return wsb;
            
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
    
    private String getMakingId() {
        Session session = null;
        String id, test;
        long count = 0, preset = 100000;
        try {
            logger.info("Enter inside DAO rowCount() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Making.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            System.out.println(count);
            preset = preset + count;
            test = Long.toString(preset);
            String[] parts = test.split("1");
            id = "MK".concat(parts[1]);
            return id;
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
    public boolean grantOrder(String MKID) throws RuntimeException {
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count;
        String hql = "update Making prd  set assignStatus=:msg where prd.makingId=:id";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("id", MKID);
            query.setParameter("msg", "Granted");
            
            count = query.executeUpdate();
            
            if (count > 0) {
                
                transaction.commit();
                
                resetMsg = true;
            }
            return resetMsg;
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
    public List<WorkerSalaryBean> getWorkersalary(String id) throws RuntimeException {
        Session session = null;
        List<WorkerSalaryBean> wsb = null;
        wsb = new ArrayList<WorkerSalaryBean>();
        
        try {
            logger.info("Enter inside dao getWorkersalary  ::::::::" + id);
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(LossWorkerSalary.class);
            criteria.add(Restrictions.eq("workerId", id));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {                    
                    
                    System.out.println("hellow");
                    WorkerSalaryBean wsbe = new WorkerSalaryBean();
                    LossWorkerSalary lws = (LossWorkerSalary) iterator.next();
                    wsbe.setSL_NO(lws.getSlNo());
                    wsbe.setTXN_ID(lws.getTxnId());
                    wsbe.setPURPOSE(lws.getPurpose());
                    wsbe.setCREDIT_DEBIT(lws.getCreditDebit());
                    wsbe.setCURRENT_BALANCE(lws.getCurrentBalance());
                    wsbe.setGOLD_CURRENCY(lws.getGoldCurrency());
                    wsbe.setDate(lws.getLogDt());
                    wsbe.setLAST_UPDATE(lws.getLastUpdate());
                    
                    wsb.add(wsbe);
                }
            }
            return wsb;
            
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
    public boolean getUserNameValidation(String username) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            logger.info("Enter inside DAO getADHARValidation() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("id.userName", username));
            logger.info("inside getUserNameValidation method>>>>>>>>> 1");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                logger.info("inside getUserNameValidation method>>>>>>>>>2 ");
                flag = true;
            }
            return (flag);
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
    public long rowcountUser() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowcountUser() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(UserDetails.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
                logger.info("Enter inside DAO rowcountUser() method::::::::::::::" + count);
                
            }
            return count;
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
    public boolean CreateUser(WorkerRegistrationBean regDetails) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
//        long productId = this.rowCountuser();
        String id,roleid, test;
        long count = 0,role=0;
        long preset_for_userid=100000,preset_for_roleid= 100000;
        try {
             role=rowcountROLE();
            preset_for_roleid = preset_for_roleid + role+1;
            test = Long.toString(preset_for_roleid);
            String[] part = test.split("1");
            roleid = "ROLE".concat(part[1]);
            logger.info("Enter inside DAO RegistrationUser() method::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserDetails user = new UserDetails();
            UserDetailsId userid = new UserDetailsId();
            user.setForgotPassword("NOT-ASSIGN");
            user.setLogDt(new Date());
            user.setRoleId(roleid);
            user.setUserAddress(regDetails.getADDRESS());
            user.setUserEmail(regDetails.getEmail());
            user.setUserImage(regDetails.getFiledata().getBytes());
            user.setUserImageName(regDetails.getFileName());
            userid.setUserLogin(regDetails.getUsername());
            user.setUserMobile(regDetails.getPhone());
            user.setUserName(regDetails.getName());
            user.setUserPassword(regDetails.getPassword());
            userid.setUserAdhar(regDetails.getADHAR());
            count = rowcountUser();
            System.out.println("1");
            preset_for_userid = preset_for_userid + count+1;
            System.out.println("2");
            test = Long.toString(preset_for_userid);
            System.out.println("3");
            String[] parts = test.split("1");
            id = "USR".concat(parts[1]);
            userid.setUserId(id);
            user.setId(userid);
            session.save(user);
            session.flush();
            session.clear();
               System.out.println("3");
            UserRole ur=new UserRole();
//            role=rowcountROLE();
            ur.setRoleId(roleid);
            if(rowcountROLE()==0){
            ur.setRoleName("ADMIN");
            }else{
            ur.setRoleName(regDetails.getROLE());
            }
            session.save(ur);
            session.flush();
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
    public long rowcountROLE() throws RuntimeException {
       Session session = null;
        long count = 0;
        try {
            logger.info("Enter inside DAO rowcountROLE() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(UserRole.class);
            criteria.setProjection(Projections.rowCount());
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
                logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" + count);
                
            }
            return count;
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
    public LoginDetailsBean getWorkerImage(String id) throws RuntimeException {
      Session session = null;
        LoginDetailsBean addImage = null;
        try {
            System.out.println("worker........image");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerRegistration.class);
            criteria.add(Restrictions.eq("id.workerId", id));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    addImage = new LoginDetailsBean();
                    WorkerRegistration pp = (WorkerRegistration) iterator.next();

                    addImage.setUSER_IMAGE(pp.getWorkerImage());
                }
            }
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
    public boolean AddItem(Item itm) throws RuntimeException {
        logger.info("Enter inside DAO AddItem() method::::::::::::::");
        boolean flag=false;
        Session session = null;
        Transaction transaction = null;
        logger.info("Enter inside DAO AddItem() method::::::::::::::");
        long productId=this.rowcountItem();
        logger.info("Enter inside DAO AddItem() method::::::::::::::");
        Random random = new Random();
     String id="ITM"+ random.nextInt(9)+ productId;
      logger.info("Enter inside DAO AddItem() method::::::::::::::"+productId);
     try {
            logger.info("Enter inside DAO AddItem() method::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
             ItemTable item=new ItemTable();
             item.setName(itm.getName());
             item.setTypeId(id);
             item.setType(itm.getType());
             session.save(item);
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
    public long rowcountItem() throws RuntimeException {
       Session session=null;
       long count=0;
       logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       try{
            session = sessionFactory.openSession();
       Criteria criteria=session.createCriteria(ItemTable.class);
        logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       criteria.setProjection(Projections.rowCount());
         if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
                logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" + count);
                
            }
         return count;
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
    public List<Item> GetPrimaryItem(String Type) throws RuntimeException {
    Session session = null;
        List<Item> itm = null;
        itm = new ArrayList<Item>();
        
        try {
            logger.info("Enter inside dao GetPrimaryItem  ::::::::" );
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ItemTable.class);
            criteria.add(Restrictions.eq("type",Type));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    Item m = new Item();
                    ItemTable it = (ItemTable) iterator.next();
                    m.setItem_Id(it.getTypeId());
                    m.setName(it.getName());
                    m.setType(it.getType());
                    itm.add(m);
                }
            }
            return itm;
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
    public List<Item> GetAllItem() throws RuntimeException {
   Session session = null;
        List<Item> itm = null;
        itm = new ArrayList<Item>();
        
        try {
            logger.info("Enter inside dao GetAllItem  ::::::::" );
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ItemTable.class);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                      logger.info("Enter inside dao GetAllItem  ::::::::" );
                    Item m = new Item();
                    ItemTable it = (ItemTable) iterator.next();
                    m.setItem_Id(it.getTypeId());
                    m.setName(it.getName());
                    m.setType(it.getType());
                    itm.add(m);
                }
            }
            return itm;
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
    public boolean AddLoss(TableDataBean tdb) throws RuntimeException {
      logger.info("Enter inside DAO AddLoss() method::::::::::::::");
        boolean flag=false;
        Session session = null;
        Transaction transaction = null;
       logger.info("Enter inside DAO AddLoss() method::::::::::::::");
     try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
             WorkerLoss wl=new WorkerLoss();
             WorkerLossId wlid=new WorkerLossId();
            wl.setLastAssignedBy(tdb.getAssigned_By());
            wl.setLastUpdated(new Date());
            wl.setLossPercentage(tdb.getLoss_Percentage());
            wlid.setWorkPhase(tdb.getWorking());
            wlid.setWorkType(tdb.getWorkerType());
            wlid.setWorkerId(tdb.getWorker());
            wl.setId(wlid);
            session.save(wl);
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
    public List<TableDataBean> GetLossById(String get) throws RuntimeException {
      Session session = null;
        List<TableDataBean> itm = null;
        itm = new ArrayList<TableDataBean>();
        
        try {
            logger.info("Enter inside dao GetAllItem  ::::::::" );
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(WorkerLoss.class);
            criteria.add(Restrictions.eq("id.workerId", get));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                      logger.info("Enter inside dao GetAllItem  ::::::::" );
                    TableDataBean m = new TableDataBean();
                    WorkerLoss it = (WorkerLoss) iterator.next();
                   m.setWorkerType(it.getId().getWorkType());
                   m.setWorking(it.getId().getWorkPhase());
                   m.setLoss_Percentage(it.getLossPercentage());
                   m.setWorker(it.getId().getWorkerId());
                   m.setDate_of_Assign(it.getLastUpdated());
                   m.setAssigned_By(it.getLastAssignedBy());
                    itm.add(m);
                }
            }
            return itm;
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
    public boolean EditLoss(TableDataBean tdb) throws RuntimeException {
      
        
        boolean resetMsg = false;
        Session session = null;
        Transaction transaction = null;
        int count;
       
        String hql = "update WorkerLoss REGISTER set REGISTER.lastAssignedBy=:assignby ,REGISTER.lossPercentage=:lpercentage,REGISTER.lastUpdated=:date  where REGISTER.id.workType=:type and REGISTER.id.workPhase=:phase and REGISTER.id.workerId=:wid";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
       
            Query query = session.createQuery(hql);
            logger.info("Enter inside dAO EditLoss method:::::::::");
            System.out.println(tdb.getAssigned_By());
            System.out.println(tdb.getLoss_Percentage());
            System.out.println(tdb.getWorkerType());
            System.out.println( tdb.getWorking());
            System.out.println( tdb.getWorker());
            query.setParameter("assignby",  tdb.getAssigned_By());
            query.setParameter("lpercentage",tdb.getLoss_Percentage());
            query.setParameter("date", new Date());
            query.setParameter("type", tdb.getWorkerType());
            query.setParameter("phase", tdb.getWorking());
            query.setParameter("wid", tdb.getWorker());
            System.out.println("1");
            count = query.executeUpdate();
            
            if (count > 0) {
                System.out.println("2");
                transaction.commit();
                
                resetMsg = true;
            }
            System.out.println("3");
            return resetMsg;
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
    public boolean CHECKGST(String gst) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            logger.info("Enter inside DAO CHECKGST() method::::::::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("id.customerGst", gst));
            logger.info("inside CHECKGST method>>>>>>>>> 1");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                logger.info("inside CHECKGST method>>>>>>>>>2 ");
                flag = true;
            }
            return (flag);
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
    public WorkerRegistrationBean getCustomerDetailsById(String ID) throws RuntimeException {
        Session session = null;
        WorkerRegistrationBean item = new WorkerRegistrationBean();
        int s = 0;
        try {
            logger.info("Enter inside dao getAllCustomer  ::::::::");
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("id.customerId",ID));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    logger.info("Enter inside dao getAllCustomer  ::::::::1111");
                    Customer csmr = (Customer) iterator.next();
                    
                    item.setCID(csmr.getId().getCustomerId());
                    item.setName(csmr.getCustomerName());
                    item.setGST(csmr.getId().getCustomerGst());
                    item.setWORKER_ADDED_BY(csmr.getCustomerAddedBy());
                    item.setEmail(csmr.getCustomerEmail());
                        }
            }
            return item;
            
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
    public boolean AddCustomerGold(FormData f) throws RuntimeException {
       logger.info("Enter inside DAO AddLoss() method::::::::::::::");
        boolean flag=false;
        Session session = null;
        Transaction transaction = null;
        FormData fin=new FormData();
        BigDecimal bd=null;
        String currentbalance=null;
       logger.info("Enter inside DAO AddLoss() method::::::::::::::");
     try {
               long productId=this.rowCountGoldCustomer();
               logger.info("Enter inside DAO AddItem() method::::::::::::::");
              Random random = new Random();
              String id="CGLDS"+ random.nextInt(9)+ productId;
             fin=GetLastUpdate(f.getCID(),f.getType());
             logger.info("Enter inside DAO AddLoss() method::::::::::::::21");
             bd= (new BigDecimal(fin.getLast_updated()));
             bd.add(new BigDecimal(f.getQuantity()));
         logger.info("Enter inside DAO AddLoss() method::::::::::::::23");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
             CustomerGoldstock csmrGold=new CustomerGoldstock();
             CustomerGoldstockId csmGoldId=new CustomerGoldstockId();
             csmrGold.setCrDb(f.getQuantity());
             csmrGold.setCurrentBalance(bd.toString());
             csmrGold.setLogDt(new Date());
             csmrGold.setPurpose(f.getPurpose());
             csmrGold.setStockAddedBy(f.getCurrent_Logger());
             csmGoldId.setCustomerId(f.getCID());
             csmGoldId.setGoldType(f.getType());
             csmGoldId.setSlNo((int)fin.getSlno());
             csmGoldId.setStockId(id);
            csmrGold.setId(csmGoldId);
            session.save(csmrGold);
              transaction.commit();
              logger.info("Enter inside DAO AddLoss() method::::::::::::::24");
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
    public FormData GetLastUpdate(String id, String type) throws RuntimeException {
     Session session = null;
        boolean flag = false;
        long count = 0;
        FormData f=new FormData();
        try {
            f.setLast_updated("0");
            f.setSlno(0);
            logger.info("Enter inside DAO CHECKGST() method::::::::::::::"+id+"::"+type);
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(CustomerGoldstock.class);
            criteria.add(Restrictions.eq("id.customerId", id));
            criteria.add(Restrictions.eq("id.goldType", type));
            criteria.add(Restrictions.eq("id.slNo",0));
            if(GetMaxSlnoByTypeId(id,type)>0){
           
            logger.info("inside CHECKGST method>>>>>>>>> 1");
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                  logger.info("inside CHECKGST method>>>>>>>>> 1");
                while (iterator.hasNext()) {             
                    CustomerGoldstock csmr = (CustomerGoldstock) iterator.next();                
                        logger.info(csmr.getCurrentBalance()+csmr.getId().getSlNo());
                    f.setLast_updated(csmr.getCurrentBalance());
                }
            }
            }
          logger.info("inside CHECKGST method>>>>>>>>> 2.1");
         return f;
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
    public long rowCountGoldCustomer() throws RuntimeException {
       Session session=null;
       long count=0;
       logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       try{
            session = sessionFactory.openSession();
       Criteria criteria=session.createCriteria(CustomerGoldstock.class);
        logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       criteria.setProjection(Projections.rowCount());
         if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
                logger.info("Enter inside DAO rowcountROLE()1 method::::::::::::::" + count);
                
            }
         return count;
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
    public long  GetMaxSlnoByTypeId(String id,String type) throws RuntimeException {
       Session session=null;
       long count=0;
       logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       try{
            session = sessionFactory.openSession();
       Criteria criteria=session.createCriteria(CustomerGoldstock.class);
            criteria.add(Restrictions.eq("id.customerId", id));
            criteria.add(Restrictions.eq("id.goldType", type));
        logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" );
       criteria.setProjection(Projections.rowCount());
         if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
                logger.info("Enter inside DAO rowcountROLE() method::::::::::::::" + count);
                
            }
         return count;
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
