/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

/**
 *
 * @author Admin
 */

public class CartDTO {
    private String CartId;
    private String JewelryId;
    private String UserId;
    private float Price;
    private float TotalPrice;
    private Integer Quantity;
    private String image;
    public CartDTO() {
    }

    public CartDTO(String CartId, String JewelryId, String UserId, float Price, float TotalPrice, Integer Quantity, String image) {
        this.CartId = CartId;
        this.JewelryId = JewelryId;
        this.UserId = UserId;
        this.Price = Price;
        this.TotalPrice = TotalPrice;
        this.Quantity = Quantity;
        this.image = image;
    }
    


    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    

    public String getCartId() {
        return CartId;
    }

    public void setCartId(String CartId) {
        this.CartId = CartId;
    }

    public String getJewelryId() {
        return JewelryId;
    }

    public void setJewelryId(String JewelryId) {
        this.JewelryId = JewelryId;
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

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    
    
}
