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
	
	private int userId;
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
	 * 用户经验值
	 */
	private int experienceNum;
	
	/**
	 * 用户等级
	 */
	private int level;
	
	


	/**
	 * 用户的粉丝数量
	 */
	private int attentionNum;
	
	/**
	 * 用户发表的文章总的收藏量
	 */
	private int collectionNum;




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
	 *@Description：登录处理
	 *@param username
	 *@param password
	 *@return: UserBean
	 *@Author:xupengfei
	 */
	public UserBean login(String username,String password){
		
		DBBean dbBean=new DBBean();
		Connection con=null;
		ResultSet rs=null;
		String sql="select userId,userName,password,photo,status from User_Table where userName='"+username+"'";
		
		try {
			con=dbBean.getConnection();
			rs=dbBean.executeQuery(sql);
			if(rs.next()){
				int rsuserId=rs.getInt(1);
				String rsusername=rs.getString(2);
				String rspassword=rs.getString(3);
				String rsphoto=rs.getString(4);
				
				int rsstatus=rs.getInt(5);
				if(password.equals(rspassword)){
					UserBean userBean=new UserBean();
					userBean.setUserId(rsuserId);
					userBean.setUserName(rsusername);
					userBean.setPasswrd(rspassword);
					userBean.setPhotoPath(rsphoto);
					userBean.setStatus(rsstatus);
					return userBean;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败！");
			System.out.println(e);
		}
		finally{
			try {
				dbBean.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
		
		
		
		
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
	
	/**
	 * 
	 *@Description：根据id查询用户信息
	 *@param userid
	 *@return: UserBean
	 *@Author:xupengfei
	 */
	public UserBean findUserById(String userid){
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		String sql="select * from User_Table where userId='"+userid+"'";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			if(rs.next()){
				int rsUserId=rs.getInt(1);
				String rsUserName=rs.getString(2);
				String rsPassword=rs.getString(3);
				String rsQuestion1=rs.getString(4);
				String rsAnswer1=rs.getString(5);
				String rsQuestion2=rs.getString(6);
				String rsAnswer2=rs.getString(7);
				String rsSex=rs.getString(8);
				String rsAge=rs.getString(9);		
				String rsHometown=rs.getString(10);
				String rsSchool=rs.getString(11);
				String rsTelephone=rs.getString(12);
				String rsQQ=rs.getString(13);
				String rsIntroduce=rs.getString(14);
				String rsPhoto=rs.getString(15);
				UserBean user=new UserBean();
				user.setUserId(rsUserId);
				user.setUserName(rsUserName);
				user.setPasswrd(rsPassword);
				user.setQuestion1(rsQuestion1);
				user.setAnswer1(rsAnswer1);
				user.setQuestion2(rsQuestion2);
				user.setAnswer2(rsAnswer2);
				user.setSex(rsSex);
				user.setAge(rsAge);
				user.setHometown(rsHometown);
				user.setSchool(rsSchool);
				user.setTelephone(rsTelephone);
				user.setQQ(rsQQ);
				user.setIntroduce(rsIntroduce);
				user.setPhoto(rsPhoto);
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return null;
		
		
		
	}
	
	
	/**
	 *@Description：修改用户信息
	 *@return
	 *@throws Exception: int
	 *@Author:xupengfei
	 */
	public int update() throws Exception{
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		StringBuffer sql=new StringBuffer()	;
		sql.append("update User_Table set ");
		sql.append("userName='");
		sql.append(userName);
		sql.append("',sex='");
		sql.append(sex);
		sql.append("',age='");
		sql.append(age);
		sql.append("',hometown='");
		sql.append(hometown);
		sql.append("',school='");
		sql.append(school);
		sql.append("',telephone='");
		sql.append(telephone);
		sql.append("',QQ='");
		sql.append(QQ);
		sql.append("',introduce='");
		sql.append(introduce);
		sql.append("',photo='");
		sql.append(photo);
		sql.append("'where userId='");
		sql.append(userId);
		sql.append("'");
		try {
			con=db.getConnection();
			
			return db.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			db.close();
		}
		
		
		return 0;
		
		
	}
	
	/**
	 *@Description：修改密码
	 *@return
	 *@throws Exception: int
	 *@Author:xupengfei
	 */
	public int changePassword() throws Exception{
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		StringBuffer sql=new StringBuffer()	;
		sql.append("update User_Table set ");
		sql.append("password='");
		sql.append(password);
		sql.append("',question1='");
		sql.append(question1);
		sql.append("',answer1='");
		sql.append(answer1);
		sql.append("',question2='");
		sql.append(question2);
		sql.append("',answer2='");
		sql.append(answer2);
		sql.append("'");
		try {
			con=db.getConnection();
			
			return db.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			db.close();
		}
		
		
		return 0;
	}
	
	/**
	 *@Description：找回密码
	 *@param userName
	 *@param telephone
	 *@return: UserBean
	 *@Author:xupengfei
	 */
	public UserBean findPassword(String userName,String telephone){
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		String sql="select userName,password,question1,answer1,question2,answer2 from User_Table where userName='"
		+userName+"' or telephone='"+telephone+"'";
		try {
			con=db.getConnection();
			System.out.println(sql);
			rs=db.executeQuery(sql);
			if(rs.next()){
				
				String rsUserName=rs.getString(1);
				String rsPassword=rs.getString(2);
				String rsQuestion1=rs.getString(3);
				String rsAnswer1=rs.getString(4);
				String rsQuestion2=rs.getString(5);
				String rsAnswer2=rs.getString(6);
				
				UserBean user=new UserBean();
				
				user.setUserName(rsUserName);
				user.setPasswrd(rsPassword);
				user.setQuestion1(rsQuestion1);
				user.setAnswer1(rsAnswer1);
				user.setQuestion2(rsQuestion2);
				user.setAnswer2(rsAnswer2);
				
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
		
	}
	
	/**
	 *@Description：获取用户的粉丝、经验、等级
	 *@param userId
	 *@return: UserBean
	 *@Author:xupengfei
	 */
	public UserBean getUserLevel(String userId) throws Exception{
		
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		String sql="select * from user_view where userId='"+userId+"'";
		db.getConnection();
		rs=db.executeQuery(sql);
		if(rs.next()){
			int userid=rs.getInt(1);
			String userName=rs.getString(2);
			String photo=rs.getString(3);
			String introduce=rs.getString(4);
			int attentionNum=rs.getInt(5);
			int collectionNum=rs.getInt(6);
			int experience=(attentionNum*10)+collectionNum;
			int level=(experience/100)+1;
			UserBean user=new UserBean();
			user.setUserId(userid);
			user.setUserName(userName);
			user.setPhoto(photo);
			user.setIntroduce(introduce);
			user.setAttentionNum(attentionNum);
			user.setExperienceNum(experience);
			user.setLevel(level);
			return user;
			
		}
		db.close();
		
		
		return null;
		
	} 
	
	
	
	
	public int getUserId() {
	return userId;
   }


   public void setUserId(int userId) {
	this.userId = userId;
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
	
	public int getAttentionNum() {
		return attentionNum;
	}



	public void setAttentionNum(int attentionNum) {
		this.attentionNum = attentionNum;
	}



	public int getCollectionNum() {
		return collectionNum;
	}



	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}

	public int getExperienceNum() {
		return experienceNum;
	}



	public void setExperienceNum(int experienceNum) {
		this.experienceNum = experienceNum;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



}
