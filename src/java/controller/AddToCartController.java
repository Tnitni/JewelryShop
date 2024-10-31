/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.CartDAO;
import Cart.CartDTO;
import Jewelry.JewelryDAO;
import Jewelry.JewelryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author hd
 */
@MultipartConfig
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    private static final String ERROR="shop.jsp";
    private static final String SUCCESS="shop.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String url= ERROR;
    try {
        CartDAO dao = new CartDAO();
        String UserId = request.getParameter("UserId").trim();
        if (UserId == null || UserId.isEmpty()) {
            JewelryDAO JewelryDao = new JewelryDAO();
            List<JewelryDTO> JewelryList = JewelryDao.getAllJewelry();
            request.setAttribute("Jewelry_List", JewelryList);
            request.setAttribute("message", "Please login to add product.");
            
     
        }else{
            
               
            
        String JewelryId = request.getParameter("JewelryId");
        float Price = Float.parseFloat(request.getParameter("Price"));
        String image = request.getParameter("image");
        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
        float TotalPrice = Price*Quantity;
        String CartId = "B" + new Random().nextInt(10000);
        
        // Check if the Jewelry already exist in the cart
        CartDTO existingCart = dao.getCartByJewelryId(JewelryId,UserId);
        if (existingCart != null) {
            // If the Jewelry already exist in the cart, update the Quantity
            existingCart.setQuantity(existingCart.getQuantity() + Quantity);
            existingCart.setTotalPrice(Price*existingCart.getQuantity());
            boolean check = dao.updateCart(existingCart);
            if (check) {
                request.setAttribute("message", "Updated Quantity of item in cart successfully.");
            } else {
                request.setAttribute("message", "Failed to update Quantity of item.");
            }
        } else {
            // If the Jewelry do not exist in the cart, add a new entry
           
            boolean check = dao.addToCart(CartId, JewelryId, Price, TotalPrice, Quantity,image,UserId);
            if (check) {
                url = SUCCESS;
                request.setAttribute("message", "Add to cart successfully.");
            } else {
                request.setAttribute("message", "Failed to add to cart.");
            }
        }
        }
      

    } catch (Exception e) {
        log("Error at AddToCartController: "+ e.toString());
    } finally {
        request.getRequestDispatcher(url).forward(request, response);
    }
}


    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short Description of the servlet.
     *
     * @return a String containing servlet Description
     */
    @Override
    public String getServletInfo() {
        return "Short Description";
    }// </editor-fold>

}
