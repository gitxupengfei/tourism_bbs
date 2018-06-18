package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SystemNoteBean {
	private int systemNoteId;
	private int postId;
	private int userId;
	private String title;
	private String noteTime;
	private int noteStatus;
	
	/**
	 *@Description：添加系统信息
	 *@throws Exception: void
	 *@Author:xupengfei
	 */
	public void addNote() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		noteTime=df.format(day);
		sql.append("insert into systemNote_table(postId,userId,title,noteTime) values ('");
		sql.append(postId);
		sql.append("','");
		sql.append(userId);
		sql.append("','");
		sql.append(title);
		sql.append("','");
		sql.append(noteTime);
		sql.append("')");
		con=dbBean.getConnection();
		dbBean.executeUpdate(sql.toString());
		dbBean.close();
		
	}
	
	
	
	/**
	 *@Description：展示系统消息
	 *@param userid
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showNote(String userid){
		
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		ArrayList noteList=new ArrayList();
		String sql="select *  from systemNote_table where userId='"+userid+"' order by systemNoteId desc";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			while(rs.next()){
				int systemNoteId=rs.getInt(1);
				int postId=rs.getInt(2);
				int userId=rs.getInt(3);
				String title=rs.getString(4);
				String noteTime=rs.getString(5);
				int noteStatus=rs.getInt(6);
				SystemNoteBean note=new SystemNoteBean();
				note.setSystemNoteId(systemNoteId);
				note.setPostId(postId);
				note.setUserId(userId);
				note.setTitle(title);
				note.setNoteTime(noteTime);
				note.setNoteStatus(noteStatus);
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
	
	public int getSystemNoteId() {
		return systemNoteId;
	}
	public void setSystemNoteId(int systemNoteId) {
		this.systemNoteId = systemNoteId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}
	public int getNoteStatus() {
		return noteStatus;
	}
	public void setNoteStatus(int noteStatus) {
		this.noteStatus = noteStatus;
	}

}
