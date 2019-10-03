/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sum
 */
public class TableDataBean implements Serializable {
  private String Table;
    private String Worker;
      private String Assigned_By;
      private String Loss_Percentage;
      private String GIVEN_GOLD;
      private String Return_GOLD;
      private String Return_Stone;
      private String Given_Stone;
        private Date Date_of_Assign;
        private  String WorkerType;
        private String Working;
        private String Status;

    /**
     * @return the Date_of_Assign
     */
    public Date getDate_of_Assign() {
        return Date_of_Assign;
    }

    /**
     * @param Date_of_Assign the Date_of_Assign to set
     */
    public void setDate_of_Assign(Date Date_of_Assign) {
        this.Date_of_Assign = Date_of_Assign;
    }

    /**
     * @return the Table
     */
    public String getTable() {
        return Table;
    }

    /**
     * @param Table the Table to set
     */
    public void setTable(String Table) {
        this.Table = Table;
    }

    /**
     * @return the Worker
     */
    public String getWorker() {
        return Worker;
    }

    /**
     * @param Worker the Worker to set
     */
    public void setWorker(String Worker) {
        this.Worker = Worker;
    }

    /**
     * @return the Assigned_By
     */
    public String getAssigned_By() {
        return Assigned_By;
    }

    /**
     * @param Assigned_By the Assigned_By to set
     */
    public void setAssigned_By(String Assigned_By) {
        this.Assigned_By = Assigned_By;
    }

    /**
     * @return the Loss_Percentage
     */
    public String getLoss_Percentage() {
        return Loss_Percentage;
    }

    /**
     * @param Loss_Percentage the Loss_Percentage to set
     */
    public void setLoss_Percentage(String Loss_Percentage) {
        this.Loss_Percentage = Loss_Percentage;
    }

    /**
     * @return the GIVEN_GOLD
     */
    public String getGIVEN_GOLD() {
        return GIVEN_GOLD;
    }

    /**
     * @param GIVEN_GOLD the GIVEN_GOLD to set
     */
    public void setGIVEN_GOLD(String GIVEN_GOLD) {
        this.GIVEN_GOLD = GIVEN_GOLD;
    }

    /**
     * @return the Return_GOLD
     */
    public String getReturn_GOLD() {
        return Return_GOLD;
    }

    /**
     * @param Return_GOLD the Return_GOLD to set
     */
    public void setReturn_GOLD(String Return_GOLD) {
        this.Return_GOLD = Return_GOLD;
    }

    /**
     * @return the Return_Stone
     */
    public String getReturn_Stone() {
        return Return_Stone;
    }

    /**
     * @param Return_Stone the Return_Stone to set
     */
    public void setReturn_Stone(String Return_Stone) {
        this.Return_Stone = Return_Stone;
    }

    /**
     * @return the Given_Stone
     */
    public String getGiven_Stone() {
        return Given_Stone;
    }

    /**
     * @param Given_Stone the Given_Stone to set
     */
    public void setGiven_Stone(String Given_Stone) {
        this.Given_Stone = Given_Stone;
    }

    /**
     * @return the WorkerType
     */
    public String getWorkerType() {
        return WorkerType;
    }

    /**
     * @param WorkerType the WorkerType to set
     */
    public void setWorkerType(String WorkerType) {
        this.WorkerType = WorkerType;
    }

    /**
     * @return the Working
     */
    public String getWorking() {
        return Working;
    }

    /**
     * @param Working the Working to set
     */
    public void setWorking(String Working) {
        this.Working = Working;
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
  
}
