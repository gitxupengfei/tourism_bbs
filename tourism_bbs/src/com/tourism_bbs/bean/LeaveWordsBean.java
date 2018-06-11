package com.tourism_bbs.bean;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.DVFactoryException;

public class LeaveWordsBean {
	private int leaveWordsId;
	private int leaveFromUserId;
	private int leaveToUserId;
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
	
}
