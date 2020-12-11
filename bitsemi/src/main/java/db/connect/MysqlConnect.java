package db.connect;

import config.ServerConfig;

import java.sql.*;

public class MysqlConnect {
    String driver = "com.mysql.jdbc.Driver";
    String myurl = "jdbc:mysql://bitsemiproject.czdy8aphntzg.ap-northeast-2.rds.amazonaws.com:3306/bitsemi";
    String myurl_test = "jdbc:mysql://bitsemiproject.czdy8aphntzg.ap-northeast-2.rds.amazonaws.com:3306/bitsemi_test";
    String myid = "admin";
    String mypass = "a1234a1234";

    public MysqlConnect() {
        // TODO Auto-generated constructor stub
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getMyConnection() {
        Connection conn = null;
        try {
            String url = myurl;
            if (ServerConfig.isTestMode()) {
                url = myurl_test;
            }

            System.out.println("url : " + url);
            conn = DriverManager.getConnection(url, myid, mypass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void dbClose(Connection conn, Statement stmt) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }

    public void dbClose(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }

    public void dbClose(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }

    public void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }
}


















