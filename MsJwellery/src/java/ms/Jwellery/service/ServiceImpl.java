/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import ms.Jwellery.dao.Dao;
import ms.Jwellery.model.AddOrderBean;
import ms.Jwellery.model.AllWorkerBean;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.OrderDivideBean;
import ms.Jwellery.model.TableDataBean;

import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.model.WorkerSalaryBean;
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
            logger.info("Enter inside Service RegistrationUser Method:::::::::::::::::::");
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
            logger.info("Enter inside service getEmailValidation Method:::::::::::::::::::");
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
        try {
            logger.info("Enter inside service getADHARValidation Method:::::::::::::::::::");
            Adhar_msg = dao.getADHARValidation(adhar);
            return Adhar_msg;
        } catch (NullPointerException ex) {
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
            logger.info("Enter inside Service userAuthentication Method:::::::::::::::::::");
            loginDetails = dao.userAuthentication(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetailsBean getImage(String adhar) throws RuntimeException {
        LoginDetailsBean addImage = null;
        try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            addImage = new LoginDetailsBean();
            addImage = dao.getImage(adhar);
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
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
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

    @Override
    public boolean RegistrationCustomer(WorkerRegistrationBean regDetails) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service RegistrationUser Method:::::::::::::::::::");
            registrationMsg = dao.RegistrationCustomer(regDetails);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean OrderRegistration(AddOrderBean OrderBean) throws RuntimeException {
        boolean ordrregistrationmsg = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            ordrregistrationmsg = dao.OrderRegistration(OrderBean);
            return ordrregistrationmsg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean DivideOrder(AddOrderBean OrderBean, int i) throws RuntimeException {
        boolean divideorder = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            divideorder = dao.DivideOrder(OrderBean, i);
            return divideorder;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<AddOrderBean> getAllOrder() throws RuntimeException {
        List<AddOrderBean> list = null;
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
            list = new ArrayList<AddOrderBean>();
            list = dao.getAllOrder();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public LoginDetailsBean Forgotpass(LoginDetailsBean loginDetails) throws RuntimeException {
        try {
            logger.info("Enter inside Service userAuthentication Method:::::::::::::::::::");
            loginDetails = dao.Forgotpass(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetailsBean UserDetailsById(String Adhar) throws RuntimeException {
        LoginDetailsBean list = null;
        try {
            logger.info("Enter inside Service userAuthentication Method:::::::::::::::::::");
            list = new LoginDetailsBean();
            list = dao.UserDetailsById(Adhar);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean Resetpass(WorkerRegistrationBean regDetails) throws RuntimeException {
     boolean resetpass = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            resetpass = dao.Resetpass(regDetails);
            return resetpass;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean Checkpass(LoginDetailsBean loginDetails,String oldpass) throws RuntimeException {
       boolean resetpass = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            resetpass = dao.Checkpass(loginDetails,oldpass);
            return resetpass;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean UpdateDetails(WorkerRegistrationBean registerBean) throws RuntimeException {
      boolean resetpass = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            resetpass = dao.UpdateDetails(registerBean);
            return resetpass;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<WorkerRegistrationBean> getAllCustomer() throws RuntimeException {
      List<WorkerRegistrationBean> list = null;
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
            list = new ArrayList<WorkerRegistrationBean>();
            list = dao.getAllCustomer();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean EachOrderBytype(OrderDivideBean order) throws RuntimeException {
     boolean divideorder = false;
        try {
            logger.info("Enter inside Service OrderRegistration method:::::::::");
            divideorder = dao.EachOrderBytype(order);
            return divideorder;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<OrderDivideBean> getAllProduct(String ID) throws RuntimeException {
      List<OrderDivideBean> list = null;
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
            list = new ArrayList<OrderDivideBean>();
            list = dao.getAllProduct(ID);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<OrderDivideBean> getAllByOrderId(String ID) throws RuntimeException {
     List<OrderDivideBean> list = null;
        try {
            logger.info("Enter inside Service getAllByOrderId():::::::::::::::::::");
            list = new ArrayList<OrderDivideBean>();
            list = dao.getAllByOrderId(ID);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AllWorkerBean> getAllWorkerByType(String Type) throws RuntimeException {
         List<AllWorkerBean> list = null;
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
            list = new ArrayList<AllWorkerBean>();
            list = dao.getAllWorkerByType(Type);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public String getProductStatus(String get) throws RuntimeException {
           String Status=null;
        try {
            logger.info("Enter inside Service getProductStatus():::::::::::::::::::");
           
            Status = dao.getProductStatus(get);
            return Status;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public BigDecimal getLossPercentageById(String Wid) throws RuntimeException {
             BigDecimal L_percentage=null;
        try {
            logger.info("Enter inside Service getProductStatus():::::::::::::::::::");
           
            L_percentage = dao.getLossPercentageById(Wid);
            return L_percentage;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public Boolean AssignMaking(FormData fd) throws RuntimeException {
     boolean msg = false;
        try {
            logger.info("Enter inside Service AssignMaking method:::::::::");
            msg = dao.AssignMaking(fd);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Boolean UpdateProduct(String get, String MSG) throws RuntimeException {
    boolean msg = false;
        try {
            logger.info("Enter inside Service AssignMaking method:::::::::");
            msg = dao.UpdateProduct(get,MSG);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public TableDataBean getMakingByPid(String id) throws RuntimeException {
         TableDataBean tdb = null;
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
           
            tdb = dao.getMakingByPid(id);
            return tdb;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public Boolean ReciveMaking(String pid, String R_GOLD, String R_STONE) throws RuntimeException {
     boolean msg = false;
        try {
            logger.info("Enter inside Service AssignMaking method:::::::::");
            msg = dao.ReciveMaking(pid,R_GOLD,R_STONE);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<WorkerSalaryBean> getPendingRequest(String adhar) throws RuntimeException {
     List<WorkerSalaryBean> wsb = null;
        wsb = new ArrayList<WorkerSalaryBean>();
        try {
            logger.info("Enter inside Service getAllWorker():::::::::::::::::::");
           
            wsb = dao.getPendingRequest(adhar);
            return wsb;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public boolean grantOrder(String MKID) throws RuntimeException {
        boolean msg = false;
        try {
            logger.info("Enter inside Service mkid method:::::::::");
            msg = dao.grantOrder(MKID);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<WorkerSalaryBean> getWorkersalary(String adhar) throws RuntimeException {
        List<WorkerSalaryBean> wsb = null;
        wsb = new ArrayList<WorkerSalaryBean>();
        try {
            logger.info("Enter inside Service getWorkersalary():::::::::::::::::::");
            wsb = dao.getWorkersalary(adhar);
            return wsb;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } }

    @Override
    public boolean getUserNameValidation(String username) throws RuntimeException {
           boolean msg = false;
        try {
            logger.info("Enter inside Service mkid method:::::::::");
            msg = dao.getUserNameValidation(username);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public long rowcountUser() throws RuntimeException {
      long lng;
        try {
            logger.info("Enter inside Service mkid method:::::::::");
           lng= dao.rowcountUser();
            return lng;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean CreateUser(WorkerRegistrationBean regDetails) throws RuntimeException {
     boolean msg = false;
        try {
            logger.info("Enter inside Service mkid method:::::::::");
            msg = dao.CreateUser(regDetails);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetailsBean getWorkerImage(String id) throws RuntimeException {
      LoginDetailsBean addImage = null;
        try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            addImage = new LoginDetailsBean();
            addImage = dao.getWorkerImage(id);
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
    public boolean AddItem(Item itm) throws RuntimeException {
     boolean msg = false;
        try {
            logger.info("Enter inside Service AddItem method:::::::::");
            msg = dao.AddItem(itm);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Item> GetPrimaryItem(String Type) throws RuntimeException {
       List<Item> itm=null;
         try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            itm = new ArrayList<Item>();
            itm = dao.GetPrimaryItem(Type);
            return itm;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<Item> GetAllItem() throws RuntimeException {
        
     List<Item> itm=null;
         try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            itm = new ArrayList<Item>();
            itm = dao.GetAllItem();
            return itm;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean AddLoss(TableDataBean tdb) throws RuntimeException {
        boolean msg = false;
        try {
            logger.info("Enter inside Service AddItem method:::::::::");
            msg = dao.AddLoss(tdb);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<TableDataBean> GetLossById(String get) throws RuntimeException {
      List<TableDataBean> itm=null;
         try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            itm = new ArrayList<TableDataBean>();
            itm = dao.GetLossById(get);
            return itm;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean EditLoss(TableDataBean tdb) throws RuntimeException {
         boolean msg = false;
        try {
            logger.info("Enter inside Service EditLoss method:::::::::");
            msg = dao.EditLoss(tdb);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean CHECKGST(String gst) throws RuntimeException {
      boolean msg = false;
        try {
            logger.info("Enter inside Service CHECKGST method:::::::::");
            msg = dao.CHECKGST(gst);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public WorkerRegistrationBean getCustomerDetailsById(String ID) throws RuntimeException {
    WorkerRegistrationBean csmr=null;
         try {
            logger.info("Enter inside Service getImage():::::::::::::::::::");
            csmr = new WorkerRegistrationBean();
            csmr = dao.getCustomerDetailsById(ID);
            return csmr;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean AddCustomerGold(FormData f) throws RuntimeException {
     boolean msg = false;
        try {
            logger.info("Enter inside Service CHECKGST method:::::::::");
            msg = dao.AddCustomerGold(f);
            return msg;
        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }
}
