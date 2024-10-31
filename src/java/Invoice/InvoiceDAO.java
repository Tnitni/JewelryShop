/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class InvoiceDAO {
    private Connection connection;
    private PreparedStatement ps;
    ResultSet rs;
    public List<InvoiceDTO> getAllInvoices() throws SQLException {
    List<InvoiceDTO> invoiceList = new ArrayList<InvoiceDTO>();
    InvoiceDTO invoice;
    String sql = "SELECT * FROM tbl_Invoice;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            invoice = new InvoiceDTO(
                    rs.getString("InvId"), 
                    rs.getString("UserId"), 
                    rs.getFloat("Total"),
                    rs.getString("DateBuy"),
                    rs.getString("Gmail"),
                    rs.getString("Address")
                    
            );
            invoiceList.add(invoice);
        }
    } catch (Exception ex) {
        // Handle exception
    } finally {
         if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    
    return invoiceList;
}
public boolean createInvoice(InvoiceDTO invoice) throws ClassNotFoundException, SQLException {
    String sql = "INSERT INTO tbl_Invoice (InvId, UserId, total, dateBuy, gmail, address) VALUES (?, ?, ?, ?, ?, ?)";
    boolean response = false;
   
    try {
        connection = DBUtils.getConnection();
        if(connection != null){
            ps = connection.prepareStatement(sql);
            ps.setString(1, invoice.getInvId());
            ps.setString(2, invoice.getUserId());
             ps.setFloat(3, invoice.getTotal());
            ps.setString(4, invoice.getDateBuy());
            ps.setString(5, invoice.getGmail());
            ps.setString(6, invoice.getAddress());
            
            response = ps.executeUpdate() > 0;
        }
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return response;
}
public List<InvoiceDTO> getInvoicesByUser(String UserId) throws ClassNotFoundException, SQLException {
    List<InvoiceDTO> invoiceList = new ArrayList<InvoiceDTO>();
    InvoiceDTO invoice;
    String sql = "SELECT * FROM tbl_Invoice WHERE UserId = ?;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, UserId);
        
        rs = ps.executeQuery();
        while (rs.next()) {
            invoice = new InvoiceDTO(
                    rs.getString("InvId"), 
                    rs.getString("UserId"), 
                    rs.getFloat("Total"),
                    rs.getString("DateBuy"),
                    rs.getString("Gmail"),
                    rs.getString("Address")
                    
            );
            invoiceList.add(invoice);
        }
    } catch (Exception ex) {
        // Handle exception
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    
    return invoiceList;
}
public boolean invoiceExists(String InvId) throws SQLException {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT InvId FROM tbl_Invoice WHERE InvId = ?";
    try {
        conn = DBUtils.getConnection();
        if (conn != null) {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, InvId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return false;
}

}
