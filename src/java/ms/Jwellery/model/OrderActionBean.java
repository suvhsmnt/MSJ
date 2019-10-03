/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.io.Serializable;

/**
 *
 * @author sum
 */
public class OrderActionBean implements Serializable{
    private String Status;
    private String ProdId;
    private String Product_Status;

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

    /**
     * @return the Product_Status
     */
    public String getProduct_Status() {
        return Product_Status;
    }

    /**
     * @param Product_Status the Product_Status to set
     */
    public void setProduct_Status(String Product_Status) {
        this.Product_Status = Product_Status;
    }
    
}
