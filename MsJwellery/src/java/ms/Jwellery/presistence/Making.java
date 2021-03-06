package ms.Jwellery.presistence;
// Generated Sep 29, 2018 7:40:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Making generated by hbm2java
 */
public class Making  implements java.io.Serializable {


     private String makingId;
     private String orderId;
     private String workerId;
     private BigDecimal returnGold;
     private BigDecimal returnStone;
     private BigDecimal lossPercentage;
     private String assignBy;
     private String assignStatus;
     private Date logDt;

    public Making() {
    }

    public Making(String makingId, String orderId, String workerId, BigDecimal returnGold, BigDecimal returnStone, BigDecimal lossPercentage, String assignBy, String assignStatus, Date logDt) {
       this.makingId = makingId;
       this.orderId = orderId;
       this.workerId = workerId;
       this.returnGold = returnGold;
       this.returnStone = returnStone;
       this.lossPercentage = lossPercentage;
       this.assignBy = assignBy;
       this.assignStatus = assignStatus;
       this.logDt = logDt;
    }
   
    public String getMakingId() {
        return this.makingId;
    }
    
    public void setMakingId(String makingId) {
        this.makingId = makingId;
    }
    public String getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getWorkerId() {
        return this.workerId;
    }
    
    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }
    public BigDecimal getReturnGold() {
        return this.returnGold;
    }
    
    public void setReturnGold(BigDecimal returnGold) {
        this.returnGold = returnGold;
    }
    public BigDecimal getReturnStone() {
        return this.returnStone;
    }
    
    public void setReturnStone(BigDecimal returnStone) {
        this.returnStone = returnStone;
    }
    public BigDecimal getLossPercentage() {
        return this.lossPercentage;
    }
    
    public void setLossPercentage(BigDecimal lossPercentage) {
        this.lossPercentage = lossPercentage;
    }
    public String getAssignBy() {
        return this.assignBy;
    }
    
    public void setAssignBy(String assignBy) {
        this.assignBy = assignBy;
    }
    public String getAssignStatus() {
        return this.assignStatus;
    }
    
    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }
    public Date getLogDt() {
        return this.logDt;
    }
    
    public void setLogDt(Date logDt) {
        this.logDt = logDt;
    }




}


