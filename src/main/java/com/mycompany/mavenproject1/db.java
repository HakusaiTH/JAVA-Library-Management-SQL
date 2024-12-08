package com.mycompany.mavenproject1;

import java.sql.*;

public class db {
    public Connection conn = null;
    public Statement stm = null;
    public ResultSet rs = null;

    private String url = "jdbc:mysql://127.0.0.1:3306/book_shop";  // database name: topanime
    private String username = "root";
    private String password = "Fujiwara2312";

    // Get connection and execute SELECT query
    public ResultSet GetConnect(String sql){
        try{
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
            stm = conn.createStatement();
            rs = stm.executeQuery(sql); // Execute SELECT query
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs; // Return result set for SELECT queries
    }

    // Get connection and execute UPDATE/DELETE/INSERT query
    public void GetUpdate(String sql) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
            stm = conn.createStatement();
            stm.executeUpdate(sql); // Execute INSERT, UPDATE, DELETE queries
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Disconnect from the database
    public void DisConnect(){
        try {
            if (rs != null) rs.close();  // Close the ResultSet if it's not null
            if (stm != null) stm.close();  // Close the Statement if it's not null
            if (conn != null && !conn.isClosed()) conn.close();  // Close the connection if it's not already closed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
