/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Control;

import Dao.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thaim
 */
@WebServlet(name="DeleteControl", urlPatterns={"/delete"})
public class DeleteControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Lấy productId từ request
        String productId = request.getParameter("productId");
        
        // Xóa sản phẩm có productId khỏi cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    String[] products = cookie.getValue().split("/");
                    StringBuilder updatedCookieValue = new StringBuilder();
                    for (String product : products) {
                        String[] parts = product.split(":");
                        if (parts.length == 2 && !parts[0].equals(productId)) {
                            updatedCookieValue.append(product).append("/");
                        }
                    }
                    // Xóa ký tự '/' cuối cùng nếu có
                    if (updatedCookieValue.length() > 0) {
                        updatedCookieValue.deleteCharAt(updatedCookieValue.length() - 1);
                    }
                    // Cập nhật cookie
                    cookie.setValue(updatedCookieValue.toString());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        
        // Chuyển hướng đến servlet ShowServlet để cập nhật lại trang giỏ hàng
        response.sendRedirect("show");
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
