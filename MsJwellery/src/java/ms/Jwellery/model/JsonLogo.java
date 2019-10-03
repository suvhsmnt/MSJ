/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
/**
 *
 * @author sum
 */
public class JsonLogo implements Serializable {
    @JsonProperty
    private String image;  

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
