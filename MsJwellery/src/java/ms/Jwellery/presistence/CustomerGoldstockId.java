package ms.Jwellery.presistence;
// Generated Sep 29, 2018 7:40:44 PM by Hibernate Tools 4.3.1



/**
 * CustomerGoldstockId generated by hbm2java
 */
public class CustomerGoldstockId  implements java.io.Serializable {


     private String customerId;
     private String stockId;
     private String goldType;
     private int slNo;

    public CustomerGoldstockId() {
    }

    public CustomerGoldstockId(String customerId, String stockId, String goldType, int slNo) {
       this.customerId = customerId;
       this.stockId = stockId;
       this.goldType = goldType;
       this.slNo = slNo;
    }
   
    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getStockId() {
        return this.stockId;
    }
    
    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
    public String getGoldType() {
        return this.goldType;
    }
    
    public void setGoldType(String goldType) {
        this.goldType = goldType;
    }
    public int getSlNo() {
        return this.slNo;
    }
    
    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CustomerGoldstockId) ) return false;
		 CustomerGoldstockId castOther = ( CustomerGoldstockId ) other; 
         
		 return ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) )
 && ( (this.getStockId()==castOther.getStockId()) || ( this.getStockId()!=null && castOther.getStockId()!=null && this.getStockId().equals(castOther.getStockId()) ) )
 && ( (this.getGoldType()==castOther.getGoldType()) || ( this.getGoldType()!=null && castOther.getGoldType()!=null && this.getGoldType().equals(castOther.getGoldType()) ) )
 && (this.getSlNo()==castOther.getSlNo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCustomerId() == null ? 0 : this.getCustomerId().hashCode() );
         result = 37 * result + ( getStockId() == null ? 0 : this.getStockId().hashCode() );
         result = 37 * result + ( getGoldType() == null ? 0 : this.getGoldType().hashCode() );
         result = 37 * result + this.getSlNo();
         return result;
   }   


}


