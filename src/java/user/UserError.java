/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Admin
 * 
 */
public class UserError {
    private String UserId;
    private String FullName;
    private String Password;
    private String RoleID;
    private String Gmail;
    private String Address;
    private Integer Status;
    private String confirm;
    public UserError(String UserId, String FullName, String Password, String RoleID, String Gmail, String Address, Integer Status, String confirm) {
        this.UserId = UserId;
        this.FullName = FullName;
        this.Password = Password;
        this.RoleID = RoleID;
        this.Gmail = Gmail;
        this.Address = Address;
        this.Status = Status;
        this.confirm=confirm;
    }

    
    public UserError() {
        this.UserId = "";
        this.FullName = "";
        this.Password = "";
        this.RoleID = "";
        this.Gmail = "";
        this.Address = "";
        this.Status = 0;
        this.confirm="";
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
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

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }
    
}
