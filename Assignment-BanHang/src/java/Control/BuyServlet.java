/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import Dao.Dao;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thaim
 */
@WebServlet(name = "BuyServlet", urlPatterns = {"/buy"})
public class BuyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lấy id và num từ request
        String id = request.getParameter("id");
        String num = request.getParameter("num");

        // Kiểm tra nếu id hoặc num là null hoặc rỗng
        if (id == null || id.isEmpty() || num == null || num.isEmpty()) {
            // Xử lý khi id hoặc num không hợp lệ, ví dụ: gán giá trị mặc định
            id = "2";
            num = "1";
        }

        // Lấy Cookie cart từ request
        Cookie[] cookies = request.getCookies();
        String cartContent = "";

        // Tạo map lưu trữ sản phẩm và số lượng
        Map<String, Integer> cartMap = new HashMap<>();

        // Phân tích chuỗi cartContent để tìm xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cartContent = cookie.getValue();
                    String[] items = cartContent.split("/");
                    for (String item : items) {
                        String[] parts = item.split(":");
                        if (parts.length == 2) {
                            cartMap.put(parts[0], Integer.parseInt(parts[1]));
                        }
                    }
                    break;
                }
            }
        }

        // Tăng số lượng của sản phẩm nếu đã tồn tại, hoặc thêm mới nếu chưa
        int quantity = cartMap.getOrDefault(id, 0);
        quantity += Integer.parseInt(num);
        cartMap.put(id, quantity);

        // Xây dựng lại chuỗi cartContent từ map
        StringBuilder cartBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            cartBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append("/");
        }
        cartContent = cartBuilder.toString();
        cartContent = cartContent.substring(0, cartContent.length() - 1); // Loại bỏ dấu / ở cuối

        // Tạo Cookie mới chứa thông tin giỏ hàng
        Cookie cartCookie = new Cookie("cart", cartContent);
        cartCookie.setMaxAge(24 * 60 * 60); // Thời gian sống của cookie: 1 ngày

        // Thêm cookie vào response
        response.addCookie(cartCookie);

        // Chuyển hướng đến servlet /show để hiển thị giỏ hàng
        response.sendRedirect(request.getContextPath() + "/show");
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
