package ms.Jwellery.presistence;
// Generated Sep 29, 2018 7:40:44 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private String productId;
     private String orderDivideId;
     private String orderType;
     private String orderStatus;
     private String actWt;
     private Date logDt;

    public Product() {
    }

    public Product(String productId, String orderDivideId, String orderType, String orderStatus, String actWt, Date logDt) {
       this.productId = productId;
       this.orderDivideId = orderDivideId;
       this.orderType = orderType;
       this.orderStatus = orderStatus;
       this.actWt = actWt;
       this.logDt = logDt;
    }
   
    public String getProductId() {
        return this.productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getOrderDivideId() {
        return this.orderDivideId;
    }
    
    public void setOrderDivideId(String orderDivideId) {
        this.orderDivideId = orderDivideId;
    }
    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getActWt() {
        return this.actWt;
    }
    
    public void setActWt(String actWt) {
        this.actWt = actWt;
    }
    public Date getLogDt() {
        return this.logDt;
    }
    
    public void setLogDt(Date logDt) {
        this.logDt = logDt;
    }




}

