/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author hd
 */
public class UserDAO {
    private static final String LOGIN="SELECT FullName, RoleID,Gmail,Address FROM tbl_User WHERE (UserId=? OR Gmail=?) AND Password=?  AND Status = 1";
    private static final String SEARCH="SELECT * FROM tbl_User WHERE FullName LIKE ? ";
    private static final String DELETE="DELETE tbl_User WHERE UserId=?";
    private static final String UPDATE="UPDATE tbl_User SET FullName=?, Password=?,  Gmail=?, Address=? WHERE UserId=?";
    private static final String UPDATE2="UPDATE tbl_User SET FullName=?, Password=?, RoleID=?,  Gmail=?, Address=? WHERE UserId=?";
    private static final String CHECK_DUPLICATE="SELECT UserId FROM tbl_User WHERE UserId=?  ";
    private static final String INSERT="INSERT INTO tbl_User(UserId, FullName, Password, RoleID, Gmail, Address, Status) "
            + "                         VALUES(?,?,?,?,?,?,?)";
    private static final String GET_USER = "SELECT UserId, FullName, Password, RoleID, Gmail, Address FROM tbl_User WHERE UserId = ? AND Status = 1";
    public UserDTO checkLogin(String UserIdorEmail, String Password) throws SQLException {
    UserDTO user= null;
    Connection conn= null;
    PreparedStatement ptm= null;
    ResultSet rs= null;
    try {
        conn= DBUtils.getConnection();
        if(conn!= null){
            ptm= conn.prepareStatement(LOGIN);
            ptm.setString(1, UserIdorEmail);
            ptm.setString(2, UserIdorEmail);
            ptm.setString(3, Password);
            rs= ptm.executeQuery();
            if(rs.next()){
                String FullName= rs.getString("FullName");
                String RoleID= rs.getString("RoleID");
                String Gmail= rs.getString("Gmail");
                String Address= rs.getString("Address");
                user= new UserDTO(UserIdorEmail, FullName, Password, RoleID, Gmail, Address, 1);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(rs!= null) rs.close();
        if(ptm!= null) ptm.close();
        if(conn!= null) conn.close();
    }
    return user;
}

    public List<UserDTO> getListUser(String search) throws SQLException {
    List<UserDTO> list= new ArrayList<>();
    Connection conn= null;
    PreparedStatement ptm= null;
    ResultSet rs= null;
    try {
        conn= DBUtils.getConnection();
        if(conn!= null){
            ptm= conn.prepareStatement(SEARCH);
            ptm.setString(1, "%"+search+"%");
            rs= ptm.executeQuery();
            while(rs.next()){
                String UserId= rs.getString("UserId");
                String FullName= rs.getString("FullName");
                String Password= rs.getString("Password");
                String RoleID= rs.getString("RoleID");
                String Gmail= rs.getString("Gmail");
                String Address= rs.getString("Address");
                
                list.add(new UserDTO(UserId, FullName, Password, RoleID, Gmail, Address,1));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(rs!= null) rs.close();
        if(ptm!= null) ptm.close();
        if(conn!= null) conn.close();
    }
    return list;
}
public UserDTO getUser(String UserId) throws SQLException {
    UserDTO user = null;
    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;
    try {
        conn = DBUtils.getConnection();
        if (conn != null) {
            ptm = conn.prepareStatement(GET_USER);
            ptm.setString(1, UserId);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String FullName = rs.getString("FullName");
                String Password = rs.getString("Password");
                String RoleID = rs.getString("RoleID");
                String Gmail = rs.getString("Gmail");
                String Address = rs.getString("Address");

                user = new UserDTO(UserId, FullName, Password, RoleID, Gmail, Address,1);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (ptm != null) ptm.close();
        if (conn != null) conn.close();
    }
    return user;
}

    public boolean delete(String UserId) throws SQLException {
        boolean checkDelete= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(DELETE);
                ptm.setString(1, UserId);
                checkDelete= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return checkDelete;
    }

    public boolean update(UserDTO user) throws SQLException {
    boolean checkUpdate= false;
    Connection conn= null;
    PreparedStatement ptm= null;
    try {
        conn= DBUtils.getConnection();
        if(conn!= null){
            ptm= conn.prepareStatement(UPDATE);
            ptm.setString(1, user.getFullName());
            ptm.setString(2, user.getPassword());
            
            ptm.setString(3, user.getGmail());
            ptm.setString(4, user.getAddress());
            ptm.setString(5, user.getUserId());
            checkUpdate= ptm.executeUpdate()>0?true:false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(ptm!= null) ptm.close();
        if(conn!= null) conn.close();
    }
    return checkUpdate;
}
    public boolean update2(UserDTO user) throws SQLException {
    boolean checkUpdate= false;
    Connection conn= null;
    PreparedStatement ptm= null;
    try {
        conn= DBUtils.getConnection();
        if(conn!= null){
            ptm= conn.prepareStatement(UPDATE2);
            ptm.setString(1, user.getFullName());
            ptm.setString(2, user.getPassword());
            ptm.setString(3, user.getRoleID());
            ptm.setString(4, user.getGmail());
            ptm.setString(5, user.getAddress());
            ptm.setString(6, user.getUserId());
            checkUpdate= ptm.executeUpdate()>0?true:false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(ptm!= null) ptm.close();
        if(conn!= null) conn.close();
    }
    return checkUpdate;
}

    public boolean checkDuplicate(String UserId) throws SQLException {
        boolean check= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, UserId);
                rs= ptm.executeQuery();
                if(rs.next()){
                    check= true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean checkInsert= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserId());
                ptm.setString(2, user.getFullName());              
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getRoleID());
                checkInsert= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return checkInsert;
    }

    public boolean insertUser(UserDTO user) throws ClassNotFoundException, SQLException {
    boolean checkInsert= false;
    Connection conn= null;
    PreparedStatement ptm= null;
    try {
        conn= DBUtils.getConnection();
        if(conn!= null){
            ptm= conn.prepareStatement(INSERT);
            ptm.setString(1, user.getUserId());
            ptm.setString(2, user.getFullName());
            ptm.setString(3, user.getPassword());
            ptm.setString(4, user.getRoleID());
            ptm.setString(5, user.getGmail());
            ptm.setString(6, user.getAddress());
            ptm.setInt(7, user.getStatus());
            checkInsert= ptm.executeUpdate()>0?true:false;
        }
    } finally{
        if(ptm!= null) ptm.close();
        if(conn!= null) conn.close();
    }
    return checkInsert;
}
public List<UserDTO> getAllUsers() throws SQLException {
    List<UserDTO> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;
    try {
        conn = DBUtils.getConnection();
        if (conn != null) {
            String sql = "SELECT * FROM tbl_User";
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String UserId = rs.getString("UserId");
                String FullName = rs.getString("FullName");
                String Password = rs.getString("Password");
                String RoleID = rs.getString("RoleID");
                String Gmail = rs.getString("Gmail");
                String Address = rs.getString("Address");

                list.add(new UserDTO(UserId, FullName, Password, RoleID, Gmail, Address, 1));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (ptm != null) ptm.close();
        if (conn != null) conn.close();
    }
    return list;
}
    
}
