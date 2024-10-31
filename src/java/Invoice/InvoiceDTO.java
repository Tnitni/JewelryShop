/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invoice;

/**
 *
 * @author Admin
 * 
 */
public class InvoiceDTO {
    private String InvId;
    private String UserId;
    private float Total;
    private String DateBuy;
    private String Gmail;
    private String Address;
    
    public InvoiceDTO() {
    }

    public InvoiceDTO(String InvId, String UserId, float Total, String DateBuy, String Gmail, String Address) {
        this.InvId = InvId;
        this.UserId = UserId;
        this.Total = Total;
        this.DateBuy = DateBuy;
        this.Gmail = Gmail;
        this.Address = Address;
    }

    

    public String getInvId() {
        return InvId;
    }

    public void setInvId(String InvId) {
        this.InvId = InvId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getDateBuy() {
        return DateBuy;
    }

    public void setDateBuy(String DateBuy) {
        this.DateBuy = DateBuy;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    
    

    
    
}
