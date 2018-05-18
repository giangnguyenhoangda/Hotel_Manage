/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Hoang Giang
 */
public class MyConnection {
    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSanV2;user=sa;password=hot10000%";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection con=MyConnection.getConnection();
        if(con!=null){
            System.out.println("Kết nối thành công");
        }
        else {
            System.out.println("Kết nối thất bại");
        }
    }
}
