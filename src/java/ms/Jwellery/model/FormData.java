/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Suvh
 */
public class FormData implements Serializable {

    private String Password;
    private String pass2;
    private String confirmpassword;
    private String Adhar;
   private String Data;
    private String Status;
    private String Current_Logger;
     private String Maker;
      private BigDecimal Loss_percentage;
     private String Productid;
     private String Purpose;
     private String Quantity;
     private String Type;
     private String CID;
     private String Last_updated;
     private long slno;
    

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the pass2
     */
    public String getPass2() {
        return pass2;
    }

    /**
     * @param pass2 the pass2 to set
     */
    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    /**
     * @return the confirmpassword
     */
    public String getConfirmpassword() {
        return confirmpassword;
    }

    /**
     * @param confirmpassword the confirmpassword to set
     */
    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    /**
     * @return the Adhar
     */
    public String getAdhar() {
        return Adhar;
    }

    /**
     * @param Adhar the Adhar to set
     */
    public void setAdhar(String Adhar) {
        this.Adhar = Adhar;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the Current_Logger
     */
    public String getCurrent_Logger() {
        return Current_Logger;
    }

    /**
     * @param Current_Logger the Current_Logger to set
     */
    public void setCurrent_Logger(String Current_Logger) {
        this.Current_Logger = Current_Logger;
    }

    /**
     * @return the Maker
     */
    public String getMaker() {
        return Maker;
    }

    /**
     * @param Maker the Maker to set
     */
    public void setMaker(String Maker) {
        this.Maker = Maker;
    }

    /**
     * @return the Loss_percentage
     */
    public BigDecimal getLoss_percentage() {
        return Loss_percentage;
    }

    /**
     * @param Loss_percentage the Loss_percentage to set
     */
    public void setLoss_percentage(BigDecimal Loss_percentage) {
        this.Loss_percentage = Loss_percentage;
    }

    /**
     * @return the Productid
     */
    public String getProductid() {
        return Productid;
    }

    /**
     * @param Productid the Productid to set
     */
    public void setProductid(String Productid) {
        this.Productid = Productid;
    }

    /**
     * @return the Purpose
     */
    public String getPurpose() {
        return Purpose;
    }

    /**
     * @param Purpose the Purpose to set
     */
    public void setPurpose(String Purpose) {
        this.Purpose = Purpose;
    }

    /**
     * @return the Quantity
     */
    public String getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the CID
     */
    public String getCID() {
        return CID;
    }

    /**
     * @param CID the CID to set
     */
    public void setCID(String CID) {
        this.CID = CID;
    }

    /**
     * @return the Last_updated
     */
    public String getLast_updated() {
        return Last_updated;
    }

    /**
     * @param Last_updated the Last_updated to set
     */
    public void setLast_updated(String Last_updated) {
        this.Last_updated = Last_updated;
    }

    /**
     * @return the slno
     */
    public long getSlno() {
        return slno;
    }

    /**
     * @param slno the slno to set
     */
    public void setSlno(long slno) {
        this.slno = slno;
    }

}
