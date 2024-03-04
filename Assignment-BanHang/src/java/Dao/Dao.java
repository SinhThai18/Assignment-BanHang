/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connect.DBContext;
import Model.Category;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public Product getLast(){
        String query = "SELECT TOP 1 *FROM Product\n" +
                        "order by id desc";
        try {
              conn = new DBContext().getConnection();
              ps = conn.prepareStatement(query);
              rs = ps.executeQuery();
              while(rs.next()){
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
    
     public static void main(String[] args) {
        Dao dao = new Dao();
        List<Category> list = dao.getAllCategory();
        for (Category o:list){
            System.out.println(o);
        }
    }
}
