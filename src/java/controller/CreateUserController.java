/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;
import user.UserDTO;
import user.UserError;

/**
 *
 * @author hd
 */
@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    private static final String ERROR="register.jsp";
    private static final String SUCCESS="login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        UserDAO dao= new UserDAO();
        UserError userError= new UserError();
        try {
            String UserId= request.getParameter("UserId");
            String FullName= request.getParameter("FullName");
            String RoleID= "US";
            String Password= request.getParameter("Password");
            String confirm= request.getParameter("confirm");
            String Gmail= request.getParameter("Gmail");
            String Address= request.getParameter("Address");
            Integer Status= 1;
            
            boolean checkValidation= true;
            
            if(!Password.equals(confirm)){
                userError.setConfirm("hai Password khong giong nhau");
                checkValidation= false;
            }
            if(checkValidation){
                UserDTO user= new UserDTO(UserId, FullName, Password, RoleID, Gmail, Address, Status);
                boolean checkInsert= dao.insertUser(user);
                if(checkInsert){
                    url= SUCCESS;
                }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController: "+ e.toString());
            if(e.toString().contains("duplicate")){
                userError.setUserId("Trung id roi!");
                request.setAttribute("USER_ERROR", userError);
            }
            
        }finally{
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
