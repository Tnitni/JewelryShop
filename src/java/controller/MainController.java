/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */
@MultipartConfig
public class MainController extends HttpServlet {

    private static final String ERROR="error.jsp";
    private static final String HOME="login.jsp";
    
    private static final String LOGIN="Login";
    private static final String LOGIN_CONTROLLER="LoginController";
    private static final String SEARCH="Search";
    private static final String SEARCH_CONTROLLER="SearchController";
    
    private static final String SEARCHInvoice="SearchInvoice";
    private static final String SEARCHInvoice_CONTROLLER="SearchInvoiceController";
    
    private static final String SEARCHuser="SearchUser";
    private static final String SEARCHuser_CONTROLLER="SearchUserController";
    
    private static final String SEARCHCategories="SearchCategories";
    private static final String SEARCHCategories_CONTROLLER="SearchCategoriesController";
    
    private static final String SEARCHCategories2="SearchCategories2";
    private static final String SEARCHCategories2_CONTROLLER="SearchCategoriesController2";
    
    private static final String SEARCHPrice="SearchPrice";
    private static final String SEARCHPrice_CONTROLLER="SearchPriceController";
    
    private static final String UPDATEUSER="Update User";
    private static final String UPDATEUSER_CONTROLLER="UpdateUserController";
    
    private static final String UPDATEUSER2="Update User2";
    private static final String UPDATEUSER2_CONTROLLER="UpdateUserController2";
    
    private static final String DELETE="Delete";
    private static final String DELETE_CONTROLLER="DeleteController";
    
    private static final String DELETEUser="DeleteUser";
    private static final String DELETEUser_CONTROLLER="DeleteUserController";
    
    private static final String UPDATE="UpdateJewelry";
    private static final String UPDATE_CONTROLLER="UpdateJewelryController";
    private static final String LOGOUT="Logout";
    private static final String LOGOUT_CONTROLLER="LogoutController";
    private static final String CREATE="Create";
    private static final String CREATE_CONTROLLER="CreateController";
    
    private static final String ADD="Add";
    private static final String ADD_TO_CART_CONTROLLER="AddToCartController";
    private static final String VIEW="View";
    private static final String VIEW_CART="viewCart.jsp";
    private static final String CHANGE="Change";
    private static final String CHANGE_CONTROLLER="ChangeController";
    private static final String REMOVE="Remove";
    private static final String REMOVE_CONTROLLER="RemoveController";
    private static final String SEARCHCART="SearchCart";
    private static final String SEARCHCART_CONTROLLER="SearchCartController";
    private static final String REGISTER="Register";
    private static final String REGISTER_CONTROLLER="CreateUserController";
    
    private static final String CreateInvoice="CreateInvoice";
    private static final String CreateInvoice_CONTROLLER="CreateInvoiceController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        try {
            
            String action= request.getParameter("action");
            
            if(null == action){
                url= HOME;
            }else switch (action) {
                case LOGIN:
                    url= LOGIN_CONTROLLER;
                    break;
                case SEARCH:
                    url= SEARCH_CONTROLLER;
                    break;
                case SEARCHuser:
                    url= SEARCHuser_CONTROLLER;
                    break;
                case SEARCHInvoice:
                    url= SEARCHInvoice_CONTROLLER;
                    break;
                case DELETE:
                    url= DELETE_CONTROLLER;
                    break;
                case DELETEUser:
                    url= DELETEUser_CONTROLLER;
                    break;
                case UPDATE:
                    url= UPDATE_CONTROLLER;
                    break;
                case LOGOUT:
                    url= LOGOUT_CONTROLLER;
                    break;
                case CREATE:
                    url= CREATE_CONTROLLER;
                    break;
                case ADD:
                    url= ADD_TO_CART_CONTROLLER;
                    break;
                case VIEW:
                    url= VIEW_CART;
                    break;
                case CHANGE:
                    url= CHANGE_CONTROLLER;
                    break;
                case REMOVE:
                    url= REMOVE_CONTROLLER;
                    break;
                case SEARCHCART:
                    url= SEARCHCART_CONTROLLER;
                    break;
                case REGISTER:
                    url= REGISTER_CONTROLLER;
                    break;
                case UPDATEUSER:
                    url= UPDATEUSER_CONTROLLER;
                    break;
                case UPDATEUSER2:
                    url= UPDATEUSER2_CONTROLLER;
                    break;
                case SEARCHCategories:
                    url= SEARCHCategories_CONTROLLER;
                    break;
                case SEARCHCategories2:
                    url= SEARCHCategories2_CONTROLLER;
                    break;
                case SEARCHPrice:
                    url= SEARCHPrice_CONTROLLER;
                    break;
                case CreateInvoice:
                    url= CreateInvoice_CONTROLLER;
                    break;
                default:
                    request.setAttribute("message", "Your action not support");
                    break;
            }
        } catch (Exception e) {
            log("Error at MainController: "+ e.toString());
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
