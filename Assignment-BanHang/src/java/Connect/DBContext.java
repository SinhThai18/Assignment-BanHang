/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author thaim
 */
public class DBContext {
    protected Connection con;
    public DBContext(){
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSP";
            String username = "sa";
            String password = "160203";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username , password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }     
    }
    
     public Connection getConnection() {
        return con;
    }
//      public void checkConnection() {
//        try {
//            if (con != null && !con.isClosed()) {
//                System.out.println("Connected to SQL Server");
//                
//                // Example: Execute a query to fetch data from a table
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
//                while (rs.next()) {
//                    // String column1Value = rs.getString("column1");
//                    int column2Value = rs.getInt("column2");
//                }
//            } else {
//                System.out.println("Failed to make connection to SQL Server");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//    
//    public static void main(String[] args) {
//        DBContext dbContext = new DBContext();
//        dbContext.checkConnection();
//    }
}
