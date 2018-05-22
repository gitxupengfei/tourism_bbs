package com.tourism_bbs.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.scene.control.Alert;

/**
 * 
 *@Description：封装用户的属性和方法
 * @author：xupengfei
 *
 */

public class UserBean {
	
	
	private String userName;
	private String password;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private String sex;
	private String age;
	private String hometown;
	private  String school;
	private String telephone;
	private String  QQ;
	private String introduce;
	private String photo;
	private String photoPath;
	private int status;
/**
 * 
 *@Description：添加新用户
 *@throws Exception: void
 *@Author:xupengfei
 */
	public void addUser() throws Exception{
	
		
		
		DBBean db=new DBBean();
		Connection con=null;
		ResultSet rs=null;
		
		
//		PreparedStatement pstmt=con.prepareStatement("insert into User_Table (userName,password,question1,answer1,question2,answer2,sex,age,hometown,school,telephone,QQ,introduce,photo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
//		File file=new File(photoPath);
//		InputStream is=new FileInputStream(file);
//		PreparedStatement pstmt=con.prepareStatement("insert into User_Table (userName,password,question1,answer1,question2,answer2,sex,age,hometown,school,telephone,QQ,introduce,photo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//	
//		pstmt.setString(1, userName);
//		pstmt.setString(2, password);
//		pstmt.setString(3, question1);
//		pstmt.setString(4, answer1);
//		pstmt.setString(5, question2);
//		pstmt.setString(6, answer2);
//		pstmt.setString(7, sex);
//		pstmt.setString(8, age);
//		pstmt.setString(9, hometown);
//		pstmt.setString(10,school );
//		pstmt.setString(11, telephone);
//		pstmt.setString(12, QQ);
//		pstmt.setString(13, introduce);
//		pstmt.setBinaryStream(14, is);
	
		StringBuffer sql=new StringBuffer();
		sql.append("insert into User_Table (userName,password,question1,answer1,question2,answer2,sex,age,hometown,school,telephone,QQ,introduce,photo) values('");
		sql.append(userName);
		sql.append("','");
		sql.append(password);
		sql.append("','");
		sql.append(question1);
		sql.append("','");
		sql.append(answer1);
		sql.append("','");
		sql.append(question2);
		sql.append("','");
		sql.append(answer2);
		sql.append("','");
		sql.append(sex);
		sql.append("','");
		sql.append(age);
		sql.append("','");
		sql.append(hometown);
		sql.append("','");
		sql.append(school);
		sql.append("','");
		sql.append(telephone);
		sql.append("','");
		sql.append(QQ);
		sql.append("','");
		sql.append(introduce);
		sql.append("','");
		sql.append(photoPath);
		sql.append("')");
		
		System.out.println(sql.toString());
		try {
			con=db.getConnection();
			System.out.println(con);
			rs=db.executeQuery("select * from User_Table where userName='"+userName+"'");
			if(!rs.next()){
				db.executeUpdate(sql.toString());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败1111");
		}
		finally
		{
			db.close();
		}
	
		
		
	}
	
	/**
	 * 
	 *@Description：判断用户名是否存在
	 *@param id
	 *@return: boolean
	 * @throws Exception 
	 *@Author:xupengfei
	 */
	public boolean hasUserExist(String name) throws Exception{
		DBBean dbBean=new DBBean();
		boolean find=false ;
		Connection con=null;
		ResultSet rs=null;
		String sql="select * from User_Table where userName='"+userName+"'";
		try {
			con=dbBean.getConnection();
			rs=dbBean.executeQuery(sql);
			if(rs.next()){
				find=true;
			}
			else find=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			dbBean.close();
		}
		
		return find;
		
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPasswrd(String password) {
		this.password = password;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String QQ) {
		this.QQ = QQ;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * 
	 *@Description:获取图片的路径
	 *@param photoPath: void
	 *@Author:xupengfei
	 */
	public  void setPhotoPath(String photoPath){
		this. photoPath=photoPath;
	}
	public String getPhotoPath(){
		return photoPath;
	}
	





}
