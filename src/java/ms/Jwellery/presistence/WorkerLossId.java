package ms.Jwellery.presistence;
// Generated Sep 29, 2018 7:40:44 PM by Hibernate Tools 4.3.1



/**
 * WorkerLossId generated by hbm2java
 */
public class WorkerLossId  implements java.io.Serializable {


     private String workType;
     private String workPhase;
     private String workerId;

    public WorkerLossId() {
    }

    public WorkerLossId(String workType, String workPhase, String workerId) {
       this.workType = workType;
       this.workPhase = workPhase;
       this.workerId = workerId;
    }
   
    public String getWorkType() {
        return this.workType;
    }
    
    public void setWorkType(String workType) {
        this.workType = workType;
    }
    public String getWorkPhase() {
        return this.workPhase;
    }
    
    public void setWorkPhase(String workPhase) {
        this.workPhase = workPhase;
    }
    public String getWorkerId() {
        return this.workerId;
    }
    
    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }




}


