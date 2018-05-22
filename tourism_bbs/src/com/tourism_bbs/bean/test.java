package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class test {

	public static void main(String[] args)  {
		
		String url="jdbc:mysql://localhost:3306/bbs";
		String dbuser="root";
		String dbpass="123456";
		System.out.println("获取连接成功00000！");
	   Connection con = null;
			//加载驱动程序，参数是驱动程序的名字
			try {
				System.out.println("开始");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("获取连接1111！");
				//建立连接
			 con=DriverManager.getConnection(url,dbuser,dbpass);
				System.out.println(con);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		finally{
			try {
				con.close();
			System.out.println("连接关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
