package ms.Jwellery.presistence;
// Generated Sep 29, 2018 7:40:44 PM by Hibernate Tools 4.3.1



/**
 * WorkerRegistrationId generated by hbm2java
 */
public class WorkerRegistrationId  implements java.io.Serializable {


     private String workerId;
     private String userName;
     private String workerAdhar;

    public WorkerRegistrationId() {
    }

    public WorkerRegistrationId(String workerId, String userName, String workerAdhar) {
       this.workerId = workerId;
       this.userName = userName;
       this.workerAdhar = workerAdhar;
    }
   
    public String getWorkerId() {
        return this.workerId;
    }
    
    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getWorkerAdhar() {
        return this.workerAdhar;
    }
    
    public void setWorkerAdhar(String workerAdhar) {
        this.workerAdhar = workerAdhar;
    }




}


