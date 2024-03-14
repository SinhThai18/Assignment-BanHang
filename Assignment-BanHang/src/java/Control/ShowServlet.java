package Control;

import Dao.Dao;
import Model.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowCartServlet", urlPatterns = {"/show"})
public class ShowServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Khởi tạo danh sách sản phẩm trong giỏ hàng
        List<Item> cartProducts = new ArrayList<>();
        // Khởi tạo bản đồ lưu trữ số lượng của từng sản phẩm
        Map<String, Integer> productQuantityMap = new HashMap<>();

        // Lấy thông tin sản phẩm từ Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    String[] products = cookie.getValue().split("/");
                    for (String product : products) {
                        String[] parts = product.split(":");
                        if (parts.length == 2) {
                            String productId = parts[0];
                            int quantity = Integer.parseInt(parts[1]);
                            // Lưu trữ số lượng của từng sản phẩm vào bản đồ
                            productQuantityMap.put(productId, quantity);
                        }
                    }
                    break;
                }
            }
        }

        // Lấy thông tin chi tiết về từng sản phẩm từ ID và số lượng, và thêm vào danh sách sản phẩm trong giỏ hàng
        Dao dao = new Dao();
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = dao.getProductByID(productId);
            if (product != null) {
                cartProducts.add(new Item(product, quantity, product.getPrice()));
            }
        }

        double totalPrice = 0;
        for (Item item : cartProducts) {
            totalPrice += item.getQuantity() * item.getPrice();
        }
        // Đặt danh sách sản phẩm vào thuộc tính của request
        request.setAttribute("cart", cartProducts);
        request.setAttribute("totalPrice", totalPrice);

        // Chuyển hướng đến trang Cart.jsp để hiển thị danh sách sản phẩm trong giỏ hàng
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
