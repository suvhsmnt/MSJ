/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.io.Serializable;

/**
 *
 * @author Suvh
 */
public class LoginDetailsBean implements Serializable {
    private String Name;
    private String Email;
    private String Phone;
    private int Pass;
    private String password;
    private byte[] USER_IMAGE; 
    private String Adhar;

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
        this.USER_IMAGE=USER_IMAGE;
    }

    /**
     * @return the Pass
     */
    public int getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(int Pass) {
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
}
