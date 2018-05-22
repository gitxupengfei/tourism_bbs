package com.tourism_bbs.bean;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 *@Description���������ݿ�ĸ���Bean
 * @author��xupengfei
 *
 */
public class DBBean {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public DBBean() {
		
	}
	/**
	 * 
	 *@Description����ȡ���ݿ����Ӷ���
	 *@return Connection con
	 *@throws Exception:Connection
	 *@Author:xupengfei
	 */
	public Connection getConnection() {
		//�������ݿ��url

		String url="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf-8";
		String dbuser="root";
		String dbpass="123456";
	   
			//�����������򣬲������������������
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				//��������
			 con=DriverManager.getConnection(url,dbuser,dbpass);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con; 
		
	}
	/**
	 * 
	 *@Description��ִ���н�������ص�SQL���
	 *@param sql
	 *@return ResultSet rs
	 *@throws Exception:ResultSet
	 *@Author:xupengfei
	 */
	public ResultSet executeQuery(String sql) throws Exception{
		if(con==null){
			throw new Exception("û�����Ӷ������");
		}
			//����������
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
		
		    return rs;
	
	
}
	/**
	 * 
	 *@Description��
	 *@param sql
	 *@return
	 *@throws Exception: int��
	 *@Author:xupengfei
	 */
	public int executeUpdate(String sql) throws Exception{
		
		if(con==null){
			throw new Exception("û�����ӿ���");
		}
			stmt=con.createStatement();
			return stmt.executeUpdate(sql);
		
		
	}
	
	/**
	 * 
	 *@throws SQLException 
	 * @Description���ر����ݿ�����
	 *: void��
	 *@Author:xupengfei
	 */
	//ע��رյ�˳��
		public void close() throws SQLException{
			try{
				if(rs!=null) rs.close();
			}catch(Exception e){
				
			}
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	
}
