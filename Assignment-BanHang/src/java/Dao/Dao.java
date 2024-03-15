/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connect.DBContext;
import Model.Category;
import Model.Product;
import Model.Account;
import Model.Cart;
import Model.Item;
import Model.Order;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thaim
 */
public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT*FROM Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "SELECT TOP 1 *FROM Product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

//    public static void main(String[] args) {
//        Dao dao = new Dao();
//        List<Product> list = dao.getAllProduct();
//        for (Product o:list){
//            System.out.println(o);
//        }
//    }
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT*FROM Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT*FROM Product\n"
                + "where cateID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
//     public static void main(String[] args) {
//        Dao dao = new Dao();
//        List<Category> list = dao.getAllCategory();
//        for (Category o:list){
//            System.out.println(o);
//        }
//    }

    public Product getProductByID(String id) {
        String query = "SELECT*FROM Product\n"
                + "where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT*FROM Product\n"
                + "WHERE NAME LIKE ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "SELECT * FROM Account\n"
                + "WHERE [user] = ? AND pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExit(String user) {
        String query = "SELECT * FROM Account\n"
                + "WHERE [user] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signup(String user, String pass) {
        String query = "INSERT INTO Account\n"
                + "VALUES(?,?,0,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT*FROM Product\n"
                + "where sell_id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String query = "DELETE FROM Product\n"
                + "WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image,
            String price, String description,
            String information, String Category,
            int sid) {
        String query = "INSERT INTO Product ([name], [image], price, [description], cateID, sell_id, information)\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, Category);
            ps.setInt(6, sid);
            ps.setString(7, information);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price,
            String description, String information, String Category,
            String pid) {
        String query = "UPDATE Product\n"
                + "SET name=?,\n"
                + "image=?,\n"
                + "price=?,\n"
                + "description=?,\n"
                + "cateID=?,\n"
                + "information=?\n"
                + "WHERE id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, Category);
            ps.setString(6, information);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi nếu có
        } finally {
            // Đóng các resource (PreparedStatement, Connection) sau khi sử dụng
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        String name = "Updated Product Name";
//        String image = "updated_image_url.jpg";
//        String price = "20";
//        String description = "Updated product description";
//        String information = "Updated product information";
//        String category = "1"; // Assuming category ID
//        String pid = "1"; // Assuming product ID
//        
//        Dao dao = new Dao();
//        
//        try {
//            dao.editProduct(name, image, price, description, information, category, pid);
//            System.out.println("Product updated successfully!");
//        } catch (Exception e) {
//            System.out.println("Error updating product: " + e.getMessage());
//      }
//    }
//    public List<Account> getAllA() {
//        List<Account> list = new ArrayList<>();
//        String query = "SELECT * FROM Account";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("uID");
//                String user = rs.getString("user");
//                String pass = rs.getString("pass");
//                int isSell = rs.getInt("isSell");
//                int isAdmin = rs.getInt("isAdmin");
//
//                Account account = new Account(id, user, pass, isSell, isAdmin);
//                list.add(account);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); // In ra lỗi nếu có
//        } finally {
//            // Đóng các resource (ResultSet, PreparedStatement, Connection) sau khi sử dụng
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return list;
//    }
//    
//    public static void main(String[] args) {
//        Dao accountDAO = new Dao();
//        List<Account> accounts = accountDAO.getAllA();
//
//        for (Account account : accounts) {
//            System.out.println("uID: " + account.getId());
//            System.out.println("Username: " + account.getUser());
//            System.out.println("Password: " + account.getPass());
//            System.out.println("IsSell: " + account.getIsSell());
//            System.out.println("IsAdmin: " + account.getIsAdmin());
//            System.out.println("-------------------------------------");
//        }
//    }
    public void addOrder(Account c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            String query = "INSERT INTO [order] (date, uID, totalmoney) VALUES (?, ?, ?)";
            conn = new DBContext().getConnection();
            conn.setAutoCommit(false); // Tắt chế độ tự động commit

            // Thêm thông tin đơn hàng vào bảng Order
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, date);
            ps.setInt(2, c.getId());
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();

            // Lấy ID của order vừa thêm vào
            ResultSet rs = ps.getGeneratedKeys();
            int oid = -1;
            if (rs.next()) {
                oid = rs.getInt(1);
            }
            rs.close();
            ps.close();

            // Thêm thông tin chi tiết đơn hàng vào bảng OrderLine
            String query2 = "INSERT INTO [OrderLine] (oid, pid, quantity, price) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(query2);
            for (Item i : cart.getItems()) {
                ps.setInt(1, oid);
                ps.setInt(2, i.getProduct().getId());
                ps.setInt(3, i.getQuantity());
                ps.setDouble(4, i.getPrice());
                ps.executeUpdate();
            }

            // Cập nhật số lượng sản phẩm trong bảng Product
            String query3 = "UPDATE product SET quantity = quantity - ? WHERE id = ?";
            ps = conn.prepareStatement(query3);
            for (Item i : cart.getItems()) {
                ps.setInt(1, i.getQuantity());
                ps.setInt(2, i.getProduct().getId());
                ps.executeUpdate();
            }

            // Commit các thay đổi vào cơ sở dữ liệu
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                // Nếu có lỗi, rollback các thay đổi
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Đóng PreparedStatement và Connection
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = new DBContext().getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM [Order]"); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("oid"));
                order.setDate(resultSet.getString("date"));
                order.setCusid(resultSet.getInt("uID"));
                order.setTotalmoney(resultSet.getDouble("totalmoney"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<OrderDetail> getAllOrderLine() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try (Connection connection = new DBContext().getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM [OrderLine]"); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOid(resultSet.getInt("oid"));
                orderDetail.setPid(resultSet.getInt("pid"));
                orderDetail.setQuantity(resultSet.getInt("quantity"));
                orderDetail.setPrice(resultSet.getDouble("price"));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = new DBContext().getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM Account"); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("uID"));
                account.setUser(resultSet.getString("user"));
                account.setPass(resultSet.getString("pass"));
                account.setIsSell(resultSet.getInt("isSell"));
                account.setIsAdmin(resultSet.getInt("isAdmin"));
                account.setPhone(resultSet.getString("phone"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
      public static void main(String[] args) {
        // Tạo một đối tượng DAO
        Dao dao = new Dao();

        // Gọi phương thức để lấy danh sách tài khoản
        List<Account> accounts = dao.getAllAccounts();

        // In ra danh sách tài khoản
        for (Account account : accounts) {
            System.out.println("uID: " + account.getId());
            System.out.println("Username: " + account.getUser());
            System.out.println("Password: " + account.getPass());
            System.out.println("IsSell: " + account.getIsSell());
            System.out.println("IsAdmin: " + account.getIsAdmin());
            System.out.println("Amount: " + account.getAmount());
            System.out.println("Phone: " + account.getPhone());
            System.out.println("-------------------------------------");
        }
    }
}
