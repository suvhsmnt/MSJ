/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Suvh
 */
public class AddOrderBean {

    private String ORDER_ID;
    private String CUSTOMER_ID;
    private String R_NAME;
    private String TOTAL_QUANTITY;
    private String TYPE;
    private String GNM_PCS;
    private String GNM_AVG_WT;
    private String ER_PCS;
    private String ER_AVG_WT;
    private String NECKLESS_PCS;
    private String cname;
    private String NECKLESS_AVG_WT;
     private String ORDER_ADDED_BY;
    private List<OrderDivideBean> order;
    private Date date;


    /**
     * @return the ORDER_ID
     */
    public String getORDER_ID() {
        return ORDER_ID;
    }

    /**
     * @param ORDER_ID the ORDER_ID to set
     */
    public void setORDER_ID(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    /**
     * @return the CUSTOMER_ID
     */
    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    /**
     * @param CUSTOMER_ID the CUSTOMER_ID to set
     */
    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    /**
     * @return the R_NAME
     */
    public String getR_NAME() {
        return R_NAME;
    }

    /**
     * @param R_NAME the R_NAME to set
     */
    public void setR_NAME(String R_NAME) {
        this.R_NAME = R_NAME;
    }

    /**
     * @return the TOTAL_QUANTITY
     */
    public String getTOTAL_QUANTITY() {
        return TOTAL_QUANTITY;
    }

    /**
     * @param TOTAL_QUANTITY the TOTAL_QUANTITY to set
     */
    public void setTOTAL_QUANTITY(String TOTAL_QUANTITY) {
        this.TOTAL_QUANTITY = TOTAL_QUANTITY;
    }

    /**
     * @return the GNM_PCS
     */
    public String getGNM_PCS() {
        return GNM_PCS;
    }

    /**
     * @param GNM_PCS the GNM_PCS to set
     */
    public void setGNM_PCS(String GNM_PCS) {
        this.GNM_PCS = GNM_PCS;
    }

    /**
     * @return the GNM_AVG_WT
     */
    public String getGNM_AVG_WT() {
        return GNM_AVG_WT;
    }

    /**
     * @param GNM_AVG_WT the GNM_AVG_WT to set
     */
    public void setGNM_AVG_WT(String GNM_AVG_WT) {
        this.GNM_AVG_WT = GNM_AVG_WT;
    }

    /**
     * @return the ER_PCS
     */
    public String getER_PCS() {
        return ER_PCS;
    }

    /**
     * @param ER_PCS the ER_PCS to set
     */
    public void setER_PCS(String ER_PCS) {
        this.ER_PCS = ER_PCS;
    }

    /**
     * @return the ER_AVG_WT
     */
    public String getER_AVG_WT() {
        return ER_AVG_WT;
    }

    /**
     * @param ER_AVG_WT the ER_AVG_WT to set
     */
    public void setER_AVG_WT(String ER_AVG_WT) {
        this.ER_AVG_WT = ER_AVG_WT;
    }

    /**
     * @return the NECKLESS_PCS
     */
    public String getNECKLESS_PCS() {
        return NECKLESS_PCS;
    }

    /**
     * @param NECKLESS_PCS the NECKLESS_PCS to set
     */
    public void setNECKLESS_PCS(String NECKLESS_PCS) {
        this.NECKLESS_PCS = NECKLESS_PCS;
    }

    /**
     * @return the NECKLESS_AVG_WT
     */
    public String getNECKLESS_AVG_WT() {
        return NECKLESS_AVG_WT;
    }

    /**
     * @param NECKLESS_AVG_WT the NECKLESS_AVG_WT to set
     */
    public void setNECKLESS_AVG_WT(String NECKLESS_AVG_WT) {
        this.NECKLESS_AVG_WT = NECKLESS_AVG_WT;
    }

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
     * @return the order
     */
    public List<OrderDivideBean> getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(List<OrderDivideBean> order) {
        this.order = order;
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
     * @return the ORDER_ADDED_BY
     */
    public String getORDER_ADDED_BY() {
        return ORDER_ADDED_BY;
    }

    /**
     * @param ORDER_ADDED_BY the ORDER_ADDED_BY to set
     */
    public void setORDER_ADDED_BY(String ORDER_ADDED_BY) {
        this.ORDER_ADDED_BY = ORDER_ADDED_BY;
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

}
