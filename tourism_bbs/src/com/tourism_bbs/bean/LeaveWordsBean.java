package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;

public class LeaveWordsBean {
	private int leaveWordsId;
	private int leaveFromUserId;
	private int leaveToUserId;
	private String leaveFromUserName;
	private String leaveWords;
	private String leaveTime;
	private int leaveStatus;
	
	
	
	
	/**
	 *@Description£∫: void ÃÌº”¡Ù—‘
	 *@Author:xupengfei
	 */
	public void addLeaveWords() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		leaveTime=df.format(day);
		sql.append("insert into leavewords_table(leaveFromUserId,leaveToUserId,leaveWords,leaveTime) values(' ");
		sql.append(leaveFromUserId);
		sql.append("','");
		sql.append(leaveToUserId);
		sql.append("','");
		sql.append(leaveWords);
		sql.append("','");
		sql.append(leaveTime);
		sql.append("')");
		con=dbBean.getConnection();
		dbBean.executeUpdate(sql.toString());
		dbBean.close();
	}
	
	/**
	 *@Description£∫’π æ¡Ù—‘
	 *@param userid
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showLeaveWords(String userid){
		
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		ArrayList noteList=new ArrayList();
		String sql="select *  from leave_view where leaveToUserId='"+userid+"' order by leaveWordsId desc";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			while(rs.next()){
				int leaveWordsId=rs.getInt(1);
				String leaveFromUserName=rs.getString(2);
				int leaveToUserId=rs.getInt(3);
				String leaveWords=rs.getString(4);
				String leaveTime=rs.getString(5);
				int leaveStatus=rs.getInt(6);
				LeaveWordsBean note=new LeaveWordsBean();
				note.setLeaveWordsId(leaveWordsId);
				note.setLeaveFromUserName(leaveFromUserName);
				note.setLeaveToUserId(leaveToUserId);
				note.setLeaveWords(leaveWords);
				note.setLeaveTime(leaveTime);
				note.setLeaveStatus(leaveStatus);
				noteList.add(note);
				
				
				
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
		
		
		return noteList;
		

		
		
	}
	
	public int getLeaveWordsId() {
		return leaveWordsId;
	}
	public void setLeaveWordsId(int leaveWordsId) {
		this.leaveWordsId = leaveWordsId;
	}
	public int getLeaveFromUserId() {
		return leaveFromUserId;
	}
	public void setLeaveFromUserId(int leaveFromUserId) {
		this.leaveFromUserId = leaveFromUserId;
	}
	public int getLeaveToUserId() {
		return leaveToUserId;
	}
	public void setLeaveToUserId(int leaveToUserId) {
		this.leaveToUserId = leaveToUserId;
	}
	public String getLeaveWords() {
		return leaveWords;
	}
	public void setLeaveWords(String leaveWords) {
		this.leaveWords = leaveWords;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(int leaveStatus) {
		this.leaveStatus = leaveStatus;
	}



	public String getLeaveFromUserName() {
		return leaveFromUserName;
	}



	public void setLeaveFromUserName(String leaveFromUserName) {
		this.leaveFromUserName = leaveFromUserName;
	}
	
	
}
