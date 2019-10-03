/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;

/**
 *
 * @author suvo
 */
public class Item {
 private String Name;    
  private String Type;
   private String Item_Id;

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
     * @return the Item_Id
     */
    public String getItem_Id() {
        return Item_Id;
    }

    /**
     * @param Item_Id the Item_Id to set
     */
    public void setItem_Id(String Item_Id) {
        this.Item_Id = Item_Id;
    }
}
