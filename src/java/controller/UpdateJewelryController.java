/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.CartDAO;
import Jewelry.JewelryDAO;
import Jewelry.JewelryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.UserDAO;
import user.UserDTO;
import user.UserError;

/**
 *
 * @author hd
 */
@WebServlet(name = "UpdateJewelryController", urlPatterns = {"/UpdateJewelryController"})
public class UpdateJewelryController extends HttpServlet {

    private static final String ERROR = "Jewelry.jsp";
    private static final String SUCCESS = "Jewelry.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String url = ERROR;
    try {
        String JewelryId = request.getParameter("JewelryId");
        String JewelryName = request.getParameter("JewelryName");
        String Description = request.getParameter("Description");
        String Type = request.getParameter("Type");
        String image = request.getParameter("image");
        float Price = Float.parseFloat(request.getParameter("Price"));
        int Status = 1;

        JewelryDTO Jewelry = new JewelryDTO(JewelryId, JewelryName, Description, Type, image, Price, Status);
        JewelryDAO dao = new JewelryDAO();
        boolean checkUpdate = dao.updateJewelry(Jewelry);
        if (checkUpdate) {
            url = SUCCESS;
            request.setAttribute("message", "Update Jewelry successfully.");
        } else {
            request.setAttribute("message", "Update fail!");
        }

    } catch (Exception e) {
        log("Error at UpdateJewelryController: " + e.toString());
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
