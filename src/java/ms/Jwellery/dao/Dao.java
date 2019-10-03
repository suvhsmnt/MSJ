/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.dao;
import java.math.BigDecimal;
import java.util.List;
import ms.Jwellery.model.AddOrderBean;
import ms.Jwellery.model.AllWorkerBean;
import ms.Jwellery.model.FormData;
import ms.Jwellery.model.Item;
import ms.Jwellery.model.LoginDetailsBean;
import ms.Jwellery.model.OrderDivideBean;
import ms.Jwellery.model.TableDataBean;
import ms.Jwellery.model.UserRegistrationBean;
import ms.Jwellery.model.WorkerRegistrationBean;
import ms.Jwellery.model.WorkerSalaryBean;

/**
 *
 * @author Suvh
 */
public interface Dao {

    public boolean RegistrationUser(WorkerRegistrationBean registration) throws RuntimeException;

    public boolean getEmailValidation(String email) throws RuntimeException;

    public boolean getADHARValidation(String adhar) throws RuntimeException;

    public LoginDetailsBean userAuthentication(LoginDetailsBean loginDetails) throws RuntimeException;

    public LoginDetailsBean getImage(String adhar) throws RuntimeException;

    public List<LoginDetailsBean> getAllWorker() throws RuntimeException;

    public long rowCountuser() throws RuntimeException;

    public long rowCountcustomer() throws RuntimeException;
    public long rowCountOrder() throws RuntimeException;
     public long rowCountOrderDivide() throws RuntimeException;
       public long rowCountProduct() throws RuntimeException;
    public boolean RegistrationCustomer(WorkerRegistrationBean regDetails) throws RuntimeException;

    public boolean DivideOrder(AddOrderBean OrderBean, int i) throws RuntimeException;

    public boolean OrderRegistration(AddOrderBean OrderBean) throws RuntimeException;

    public List<AddOrderBean> getAllOrder() throws RuntimeException;

    public LoginDetailsBean Forgotpass(LoginDetailsBean loginDetails) throws RuntimeException;

    public LoginDetailsBean UserDetailsById(String Adhar) throws RuntimeException;

    public boolean Resetpass(WorkerRegistrationBean regDetails)throws RuntimeException;

    public boolean Checkpass(LoginDetailsBean loginDetails,String oldpass)throws RuntimeException;

    public boolean UpdateDetails(WorkerRegistrationBean registerBean)throws RuntimeException;

    public List<WorkerRegistrationBean> getAllCustomer()throws RuntimeException;

    public boolean EachOrderBytype(OrderDivideBean order)throws RuntimeException;

    public List<OrderDivideBean> getAllProduct(String ID)throws RuntimeException;

    public List<OrderDivideBean> getAllByOrderId(String ID)throws RuntimeException;

    public List<AllWorkerBean> getAllWorkerByType(String Type)throws RuntimeException;

    public String getProductStatus(String get)throws RuntimeException;

    public BigDecimal getLossPercentageById(String Wid)throws RuntimeException;

    public boolean AssignMaking(FormData fd)throws RuntimeException;

    public boolean UpdateProduct(String get, String MSG)throws RuntimeException;

    public TableDataBean getMakingByPid(String id)throws RuntimeException;

    public boolean ReciveMaking(String pid, String R_GOLD, String R_STONE)throws RuntimeException;

    public  List<WorkerSalaryBean> getPendingRequest(String adhar)throws RuntimeException;

    public boolean grantOrder(String MKID)throws RuntimeException;

    public List<WorkerSalaryBean> getWorkersalary(String adhar)throws RuntimeException;

    public boolean getUserNameValidation(String username)throws RuntimeException;

    public long rowcountUser()throws RuntimeException;
    public long rowcountROLE()throws RuntimeException;
     public long rowcountItem()throws RuntimeException;
    public boolean CreateUser(WorkerRegistrationBean regDetails)throws RuntimeException;

    public LoginDetailsBean getWorkerImage(String id)throws RuntimeException;

    public boolean AddItem(Item itm)throws RuntimeException;

    public List<Item> GetPrimaryItem(String Type)throws RuntimeException;

    public List<Item> GetAllItem()throws RuntimeException;

    public boolean AddLoss(TableDataBean tdb)throws RuntimeException;

    public List<TableDataBean> GetLossById(String get)throws RuntimeException;

    public boolean EditLoss(TableDataBean tdb)throws RuntimeException;

    public boolean CHECKGST(String gst)throws RuntimeException;

    public WorkerRegistrationBean getCustomerDetailsById(String ID)throws RuntimeException;

    public boolean AddCustomerGold(FormData f)throws RuntimeException;
    public FormData GetLastUpdate(String id,String type)throws RuntimeException;
    public long rowCountGoldCustomer()throws RuntimeException;
    public long  GetMaxSlnoByTypeId(String id,String type) throws RuntimeException;
 
}
