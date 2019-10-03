/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Suvh
 */
public class LoginDetailsBean implements Serializable {
    private String username;
    private String Name;
    private String Email;
    private String Phone;
    private String Pass;
    private String password;
    private byte[] USER_IMAGE;
    private String Adhar;
    private String Address;
    private BigDecimal Gold;
    private int Stone;
    private BigDecimal Rs;
    private Date date;
    private String msg;
    private String ROLE;
    private String Worker_Id;
    private String Id;


    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Password
     */
    /**
     * @return the USER_IMAGE
     */
    public byte[] getUSER_IMAGE() {
        return USER_IMAGE;
    }

    /**
     * @param USER_IMAGE the USER_IMAGE to set
     */
    public void setUSER_IMAGE(byte[] USER_IMAGE) {
        this.USER_IMAGE = USER_IMAGE;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    /**
     * @param USER_IMAGE the USER_IMAGE to set
     */
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Gold
     */
    public BigDecimal getGold() {
        return Gold;
    }

    /**
     * @param Gold the Gold to set
     */
    public void setGold(BigDecimal Gold) {
        this.Gold = Gold;
    }

    /**
     * @return the Stone
     */
    public int getStone() {
        return Stone;
    }

    /**
     * @param Stone the Stone to set
     */
    public void setStone(int Stone) {
        this.Stone = Stone;
    }

    /**
     * @return the Rs
     */
    public BigDecimal getRs() {
        return Rs;
    }

    /**
     * @param Rs the Rs to set
     */
    public void setRs(BigDecimal Rs) {
        this.Rs = Rs;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the ROLE
     */
    public String getROLE() {
        return ROLE;
    }

    /**
     * @param ROLE the ROLE to set
     */
    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    /**
     * @return the Worker_Id
     */
    public String getWorker_Id() {
        return Worker_Id;
    }

    /**
     * @param Worker_Id the Worker_Id to set
     */
    public void setWorker_Id(String Worker_Id) {
        this.Worker_Id = Worker_Id;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }
}
