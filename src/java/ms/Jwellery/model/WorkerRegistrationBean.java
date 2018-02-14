/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.math.BigDecimal;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Suvh
 */
public class WorkerRegistrationBean {
    private String Name;
    private String Email;
    private String Phone;
    private String Password;
    private String repassword;
    private String ADDRESS;
    private String ADHAR;
    private BigDecimal GOLD;
    private BigDecimal NETBAL;
    private int STONE;
    private CommonsMultipartFile filedata;
   private String fileName;
   private byte[] USER_IMAGE;
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
     * @return the rePassword
     */


    /**
     * @return the ADDRESS
     */
    public String getADDRESS() {
        return ADDRESS;
    }

    /**
     * @param ADDRESS the ADDRESS to set
     */
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    /**
     * @return the ADHAR
     */
    public String getADHAR() {
        return ADHAR;
    }

    /**
     * @param ADHAR the ADHAR to set
     */
    public void setADHAR(String ADHAR) {
        this.ADHAR = ADHAR;
    }

    /**
     * @return the GOLD
     */
    public BigDecimal getGOLD() {
        return GOLD;
    }

    /**
     * @param GOLD the GOLD to set
     */
    public void setGOLD(BigDecimal GOLD) {
        this.GOLD = GOLD;
    }

    /**
     * @return the NETBAL
     */
    public BigDecimal getNETBAL() {
        return NETBAL;
    }

    /**
     * @param NETBAL the NETBAL to set
     */
    public void setNETBAL(BigDecimal NETBAL) {
        this.NETBAL = NETBAL;
    }

    /**
     * @return the STONE
     */
    public int getSTONE() {
        return STONE;
    }

    /**
     * @param STONE the STONE to set
     */
    public void setSTONE(int STONE) {
        this.STONE = STONE;
    }

    /**
     * @return the filedata
     */
    public CommonsMultipartFile getFiledata() {
        return filedata;
    }

    /**
     * @param filedata the filedata to set
     */
    public void setFiledata(CommonsMultipartFile filedata) {
        this.filedata = filedata;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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
     * @return the repassword
     */
    public String getRepassword() {
        return repassword;
    }

    /**
     * @param repassword the repassword to set
     */
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
