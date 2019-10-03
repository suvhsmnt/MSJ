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
    private BigDecimal Loss;
    private BigDecimal Salary;
    private String Type;
    private String Username;
    private BigDecimal NETBAL;
    private int STONE;
    private CommonsMultipartFile filedata;
    private String fileName;
    private byte[] USER_IMAGE;
    private String GST;
    private String CID;
    private String Worker_des;
   private String ROLE;
    private String WORKER_ADDED_BY;
    private String WORKER_ID;
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

    /**
     * @return the GST
     */
    public String getGST() {
        return GST;
    }

    /**
     * @param GST the GST to set
     */
    public void setGST(String GST) {
        this.GST = GST;
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
     * @return the Loss
     */
    public BigDecimal getLoss() {
        return Loss;
    }

    /**
     * @param Loss the Loss to set
     */
    public void setLoss(BigDecimal Loss) {
        this.Loss = Loss;
    }

    /**
     * @return the Salary
     */
    public BigDecimal getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(BigDecimal Salary) {
        this.Salary = Salary;
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
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Worker_des
     */
    public String getWorker_des() {
        return Worker_des;
    }

    /**
     * @param Worker_des the Worker_des to set
     */
    public void setWorker_des(String Worker_des) {
        this.Worker_des = Worker_des;
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
     * @return the WORKER_ADDED_BY
     */
    public String getWORKER_ADDED_BY() {
        return WORKER_ADDED_BY;
    }

    /**
     * @param WORKER_ADDED_BY the WORKER_ADDED_BY to set
     */
    public void setWORKER_ADDED_BY(String WORKER_ADDED_BY) {
        this.WORKER_ADDED_BY = WORKER_ADDED_BY;
    }

    /**
     * @return the WORKER_ID
     */
    public String getWORKER_ID() {
        return WORKER_ID;
    }

    /**
     * @param WORKER_ID the WORKER_ID to set
     */
    public void setWORKER_ID(String WORKER_ID) {
        this.WORKER_ID = WORKER_ID;
    }
}
