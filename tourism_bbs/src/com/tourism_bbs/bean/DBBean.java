package com.tourism_bbs.bean;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 *@Description：连接数据库的辅助Bean
 * @author：xupengfei
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
	 *@Description：获取数据库连接对象
	 *@return Connection con
	 *@throws Exception:Connection
	 *@Author:xupengfei
	 */
	public Connection getConnection() {
		//连接数据库的url

		String url="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf-8";
		String dbuser="root";
		String dbpass="123456";
	   
			//加载驱动程序，参数是驱动程序的名字
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
			 con=DriverManager.getConnection(url,dbuser,dbpass);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con; 
		
	}
	/**
	 * 
	 *@Description：执行有结果集返回的SQL语句
	 *@param sql
	 *@return ResultSet rs
	 *@throws Exception:ResultSet
	 *@Author:xupengfei
	 */
	public ResultSet executeQuery(String sql) throws Exception{
		if(con==null){
			throw new Exception("没有连接对象可用");
		}
			//创建语句对象
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
		
		    return rs;
	
	
}
	/**
	 * 
	 *@Description：
	 *@param sql
	 *@return
	 *@throws Exception: int：
	 *@Author:xupengfei
	 */
	public int executeUpdate(String sql) throws Exception{
		
		if(con==null){
			throw new Exception("没有连接可用");
		}
			stmt=con.createStatement();
			return stmt.executeUpdate(sql);
		
		
	}
	
	/**
	 * 
	 *@throws SQLException 
	 * @Description：关闭数据库连接
	 *: void：
	 *@Author:xupengfei
	 */
	//注意关闭的顺序
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
