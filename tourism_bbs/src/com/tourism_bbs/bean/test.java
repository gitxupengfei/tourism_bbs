package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class test {

	public static void main(String[] args)  {
		
		String url="jdbc:mysql://localhost:3306/bbs";
		String dbuser="root";
		String dbpass="123456";
		System.out.println("��ȡ���ӳɹ�00000��");
	   Connection con = null;
			//�����������򣬲������������������
			try {
				System.out.println("��ʼ");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("��ȡ����1111��");
				//��������
			 con=DriverManager.getConnection(url,dbuser,dbpass);
				System.out.println(con);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		finally{
			try {
				con.close();
			System.out.println("���ӹر�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
