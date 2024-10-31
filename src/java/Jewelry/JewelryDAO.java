/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jewelry;


import Jewelry.JewelryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Tony
 */
public class JewelryDAO {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
 public List<JewelryDTO> getAllByIdAndName(String JewelryName) {
    List<JewelryDTO> JewelryList = new ArrayList<JewelryDTO>();
    JewelryDTO Jewelry;
    String sql = "SELECT * FROM tbl_Jewelry WHERE JewelryName LIKE ?;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, '%' + JewelryName + '%');
        
        rs = ps.executeQuery();
        while (rs.next()) {
            Jewelry = new JewelryDTO(
                    rs.getString("JewelryId"), 
                    rs.getString("JewelryName"), 
                    rs.getString("Description"),
                    rs.getString("Type"),
                    rs.getString("image"),
                    rs.getFloat("Price"), 
                    rs.getInt("Status")
            );
            if(Jewelry.getStatus()==1){
                JewelryList.add(Jewelry);
            }
            
        }
    } catch (Exception ex) {
        // Handle exception
    }
    
    return JewelryList;
}
public List<JewelryDTO> getAllByPriceRange(float minPrice, float maxPrice) throws SQLException {
    List<JewelryDTO> JewelryList = new ArrayList<JewelryDTO>();
    JewelryDTO Jewelry;
    String sql = "SELECT * FROM tbl_Jewelry WHERE Price BETWEEN ? AND ?;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setFloat(1, minPrice);
        ps.setFloat(2, maxPrice);
        
        rs = ps.executeQuery();
        while (rs.next()) {
            Jewelry = new JewelryDTO(
                    rs.getString("JewelryId"), 
                    rs.getString("JewelryName"), 
                    rs.getString("Description"),
                    rs.getString("Type"),
                    rs.getString("image"),
                    rs.getFloat("Price"), 
                    rs.getInt("Status")
            );
            if(Jewelry.getStatus()==1){
                JewelryList.add(Jewelry);
            }
            
        }
    } catch (Exception ex) {
        // Handle exception
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    
    return JewelryList;
} 
 public List<JewelryDTO> getAllByType(String Type) {
    List<JewelryDTO> JewelryList = new ArrayList<JewelryDTO>();
    JewelryDTO Jewelry;
    String sql = "SELECT * FROM tbl_Jewelry WHERE Type LIKE ?;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, '%' + Type + '%');
        
        rs = ps.executeQuery();
        while (rs.next()) {
            Jewelry = new JewelryDTO(
                    rs.getString("JewelryId"), 
                    rs.getString("JewelryName"), 
                    rs.getString("Description"),
                    rs.getString("Type"),
                    rs.getString("image"),
                    rs.getFloat("Price"), 
                    rs.getInt("Status")
            );
            if(Jewelry.getStatus()==1){
                JewelryList.add(Jewelry);
            }
            
        }
    } catch (Exception ex) {
        // Handle exception
    }
    
    return JewelryList;
}   
public List<JewelryDTO> getAllJewelry() throws SQLException {
        List<JewelryDTO> JewelryList = new ArrayList<JewelryDTO>();
        JewelryDTO Jewelry;
        String sql = "SELECT * FROM tbl_Jewelry;";
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Jewelry = new JewelryDTO(
                        rs.getString("JewelryId"), 
                        rs.getString("JewelryName"), 
                        rs.getString("Description"),
                        rs.getString("Type"),
                        rs.getString("image"),
                        rs.getFloat("Price"), 
                        rs.getInt("Status")
                );
                if(Jewelry.getStatus()==1){
                    JewelryList.add(Jewelry);
                }
                
            }
        } catch (Exception ex) {
            // Handle exception
        } finally {
             if(ps != null) ps.close();
            if(connection != null) connection.close();
        }
        
        return JewelryList;
    }    
    
    
    
    
  public boolean createJewelry(JewelryDTO Jewelry) throws ClassNotFoundException, SQLException {
    String sql = "INSERT INTO tbl_Jewelry (JewelryId, JewelryName, Description, Type, image, Price, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    boolean response = false;
   
    try {
        connection = DBUtils.getConnection();
        if(connection != null){
            ps = connection.prepareStatement(sql);
            ps.setString(1, Jewelry.getJewelryId().trim());
            ps.setString(2, Jewelry.getJewelryName());
            ps.setString(3, Jewelry.getDescription());
            ps.setString(4, Jewelry.getType());
            ps.setString(5, Jewelry.getImage());
            ps.setFloat(6, Jewelry.getPrice());
            ps.setInt(7, Jewelry.getStatus());
            response = ps.executeUpdate() > 0?true:false;
        }
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return response;
}
public boolean deleteJewelry(String JewelryId) throws ClassNotFoundException, SQLException {
    String sql = "DELETE FROM tbl_Jewelry WHERE JewelryId = ?";
    boolean response = false;
   
    try {
        connection = DBUtils.getConnection();
        if(connection != null){
            ps = connection.prepareStatement(sql);
            ps.setString(1, JewelryId.trim());
            response = ps.executeUpdate() > 0;
        }
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return response;
}
public boolean updateJewelry(JewelryDTO Jewelry) throws ClassNotFoundException, SQLException {
    String sql = "UPDATE tbl_Jewelry SET JewelryName = ?, Description = ?, Type = ?, image = ?, Price = ?, Status = ? WHERE JewelryId = ?";
    boolean response = false;
   
    try {
        connection = DBUtils.getConnection();
        if(connection != null){
            ps = connection.prepareStatement(sql);
            ps.setString(1, Jewelry.getJewelryName());
            ps.setString(2, Jewelry.getDescription());
            ps.setString(3, Jewelry.getType());
            ps.setString(4, Jewelry.getImage());
            ps.setFloat(5, Jewelry.getPrice());
            ps.setInt(6, Jewelry.getStatus());  
            ps.setString(7, Jewelry.getJewelryId().trim());
            response = ps.executeUpdate() > 0;
        }
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return response;
}

}
