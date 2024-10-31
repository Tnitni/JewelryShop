/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CartDAO {
    private Connection connection;
    private PreparedStatement ps;
    ResultSet rs;
    public boolean addToCart(String CartId,String JewelryId, float Price, float TotalPrice, int Quantity,String image,String UserId) throws SQLException, ClassNotFoundException {
    String sql = "INSERT INTO tbl_Cart (CartId, JewelryId, UserId , Price, TotalPrice, Quantity,image) VALUES (?, ?, ?, ?, ?, ?, ?);";
    boolean response = false;
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        
        ps.setString(1, CartId);
        ps.setString(2, JewelryId.trim());
        ps.setString(3, UserId);
        ps.setFloat(4, Price);
        ps.setFloat(5, TotalPrice);
        ps.setInt(6, Quantity);
        ps.setString(7, image);
        
        response = ps.executeUpdate() > 0;
    } catch (SQLException ex) {
    } finally {
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return response;
}

    public boolean removeFromCart(String CartId) {
        String sql = "DELETE FROM tbl_Cart WHERE CartId = ?;";
        boolean response = true;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, CartId);
            response = ps.executeUpdate() > 0 ? true : false;
        } catch (Exception ex) {
        }
        return response;
    }
    
    public List<CartDTO> getCart(String UserId) throws SQLException {
    List<CartDTO> cartList = new ArrayList<CartDTO>();
    CartDTO cart;
    String sql = "SELECT * FROM tbl_Cart WHERE UserId = ?;";
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, UserId); // Set the UserId parameter
        rs = ps.executeQuery();
        while (rs.next()) {
            cart = new CartDTO(rs.getString("CartId"), rs.getString("JewelryId"), rs.getString("UserId"), rs.getFloat("Price"), rs.getFloat("TotalPrice"), rs.getInt("Quantity"),rs.getString("image"));
            cartList.add(cart);
        }
    } catch (Exception ex) {
        // Handle your exception here
    } finally {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(connection != null) connection.close();
    }
    return cartList;
}

    public boolean updateCart(CartDTO cart) throws ClassNotFoundException {
    String sql = "UPDATE tbl_Cart SET TotalPrice = ?, Quantity = ? WHERE CartId = ?;";
    boolean response = false;
    try {
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        
        ps.setFloat(1, cart.getPrice() * cart.getQuantity()); // Set TotalPrice
        ps.setInt(2, cart.getQuantity()); // Set Quantity
        ps.setString(3, cart.getCartId()); // Set CartId
        
        response = ps.executeUpdate() > 0;
    } catch (SQLException ex) {
        // Handle your exception here
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            // Handle your exception here
        }
    }
    return response;
}

    public CartDTO getCartByJewelryId(String JewelryId, String UserId) throws ClassNotFoundException {
        String sql = "SELECT * FROM tbl_Cart WHERE JewelryId = ? and UserId =?;";
        CartDTO cart = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, JewelryId);
            ps.setString(2, UserId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String CartId = rs.getString("CartId");
                float Price = rs.getFloat("Price");
                float TotalPrice = rs.getFloat("TotalPrice");
                int Quantity = rs.getInt("Quantity");
                String image = rs.getString("image");
                cart = new CartDTO(CartId, JewelryId, UserId, Price, TotalPrice, Quantity, image);
            }
        } catch (SQLException ex) {
            // Handle your exception here
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // Handle your exception here
            }
        }
        return cart;
    }
    public CartDTO getCartById(String CartId) throws ClassNotFoundException {
        String sql = "SELECT * FROM tbl_Cart WHERE CartId = ?;";
        CartDTO cart = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, CartId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String JewelryId = rs.getString("JewelryId");
                String UserId = rs.getString("UserId");
                float Price = rs.getFloat("Price");
                float TotalPrice = rs.getFloat("TotalPrice");
                int Quantity = rs.getInt("Quantity");
                String image = rs.getString("image");
                cart = new CartDTO(CartId, JewelryId, UserId, Price, TotalPrice, Quantity, image);
            }
        } catch (SQLException ex) {
            // Handle your exception here
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // Handle your exception here
            }
        }
        return cart;
    }

}
