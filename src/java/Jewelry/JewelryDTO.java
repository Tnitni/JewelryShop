/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jewelry;

/**
 *
 * @author Admin
 * 
 */
public class JewelryDTO {
    private String JewelryId;
    private String JewelryName;
    private String Description;
    private String Type;
    private String image;
    private float Price;
    private Integer Status;

    public JewelryDTO() {
    }

    public JewelryDTO(String JewelryId, String JewelryName, String Description, String Type, String image, float Price, Integer Status) {
        this.JewelryId = JewelryId;
        this.JewelryName = JewelryName;
        this.Description = Description;
        this.Type = Type;
        this.image = image;
        this.Price = Price;
        this.Status = Status;
    }

    public String getJewelryId() {
        return JewelryId;
    }

    public void setJewelryId(String JewelryId) {
        this.JewelryId = JewelryId;
    }

    public String getJewelryName() {
        return JewelryName;
    }

    public void setJewelryName(String JewelryName) {
        this.JewelryName = JewelryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }

  
    
    
}
