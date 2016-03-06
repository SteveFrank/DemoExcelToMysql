package com.exceltoMysql;
import java.sql.*;

public class JDBCUtil {

	Connection conn = null;
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root"; 
		String passWord = "1234";
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			if (conn != null) {
				System.out.println("连数据库连接成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void insertEmp(String[] str) {
		JDBCUtil iteacher = new JDBCUtil(); 
		Connection conn = iteacher.getConn(); 
		String sql = "insert into tb_empTable  values('" + str[0] + "','" + str[1] + "','" + str[2] + "','" + str[3] + "')";
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
