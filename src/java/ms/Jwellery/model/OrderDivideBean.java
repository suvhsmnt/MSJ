/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

/**
 *
 * @author Suvh
 */
public class OrderDivideBean {

    private String TYPE;
    private String QUANTITY;
    private String AVG_WT;
    private String ORDER_Divide_ID;
    private String Status;
    private String ProdId;
    /**
     * @return the TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * @param TYPE the TYPE to set
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * @return the QUANTITY
     */
    public String getQUANTITY() {
        return QUANTITY;
    }

    /**
     * @param QUANTITY the QUANTITY to set
     */
    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    /**
     * @return the AVG_WT
     */
    public String getAVG_WT() {
        return AVG_WT;
    }

    /**
     * @param AVG_WT the AVG_WT to set
     */
    public void setAVG_WT(String AVG_WT) {
        this.AVG_WT = AVG_WT;
    }

    /**
     * @return the ORDER_Divide_ID
     */
    public String getORDER_Divide_ID() {
        return ORDER_Divide_ID;
    }

    /**
     * @param ORDER_Divide_ID the ORDER_Divide_ID to set
     */
    public void setORDER_Divide_ID(String ORDER_Divide_ID) {
        this.ORDER_Divide_ID = ORDER_Divide_ID;
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
     * @return the ProdId
     */
    public String getProdId() {
        return ProdId;
    }

    /**
     * @param ProdId the ProdId to set
     */
    public void setProdId(String ProdId) {
        this.ProdId = ProdId;
    }
}
