/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Jewelry.JewelryDAO;
import Jewelry.JewelryDTO;
import Jewelry.JewelryError;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 *
 * @author hd
 */
@MultipartConfig
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "createJewelry.jsp";
    private static final String SUCCESS = "createJewelry.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        JewelryDAO dao = new JewelryDAO();
        JewelryError  JewelryError = new JewelryError();
        try {
            Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            // Write the file to your server
            File uploads = new File(getServletContext().getRealPath("/") + "/images");
            File file = new File(uploads, fileName);
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            String JewelryId = request.getParameter("JewelryId");
            String JewelryName = request.getParameter("JewelryName");
            String priceStr = request.getParameter("Price");
            float Price = Float.parseFloat(priceStr);
            String Description = request.getParameter("Description");
            String Type = request.getParameter("Type");
            Integer Status = 1;

            boolean checkValidation = true;
            if (JewelryId.length() > 50 ) {
                JewelryError.setJewelryId("JewelryId must be <50");
                checkValidation = false;    
            }
            if (JewelryName.length() > 50 ) {
                JewelryError.setJewelryName("JewelryName must be <50");
                checkValidation = false;    
            }
            if (Description.length() > 250 ) {
                JewelryError.setDescription("Description must be <250");
                checkValidation = false;    
            }
            if (Type.length() > 50 ) {
                JewelryError.setType("Type must be <50");
                checkValidation = false;    
            }
            
            if (checkValidation) {
                JewelryDTO Jewelry = new JewelryDTO(JewelryId, JewelryName, Description, Type, fileName, Price, Status);
                boolean checkInsert = dao.createJewelry(Jewelry);
                if (checkInsert) {
                    url = SUCCESS;
                    request.setAttribute("message", "Create successfully.");
                }
            } else {
                request.setAttribute("Jewelry_ERROR",  JewelryError);
              }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            
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
