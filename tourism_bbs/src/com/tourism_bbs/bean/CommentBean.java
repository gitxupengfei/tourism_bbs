package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CommentBean {
	private int commentId;
	private int comFromUserId;
	private String comFromUserName;
	private int comToId;
	private String comUserName;
	private String comUserPhoto;
	private String stype;
	private String comContent;
	private String comTime;
	private int comStatus;
	private String postTitle;
	
	/**
	 * 评论的文章的作者id
	 */
	private int comToUserId;
	
	
	/**
	 *@Description：添加评论
	 *@throws Exception: void
	 *@Author:xupengfei
	 */
	public void addComment() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		comTime=df.format(day);
		sql.append("insert into comment_table(comFromUserId,comToId,stype,comContent,comTime) values(' ");
		sql.append(comFromUserId);
		sql.append("','");
		sql.append(comToId);
		sql.append("','");
		sql.append("post");
		sql.append("','");
		sql.append(comContent);
		sql.append("','");
		sql.append(comTime);
		sql.append("')");
		con=dbBean.getConnection();
		dbBean.executeUpdate(sql.toString());
		dbBean.close();
	}
	
	/**
	 *@Description：展示文章的评论
	 *@param pageNo
	 *@param postId
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showComment(int pageNo,String postId){
		
		Connection con=null;
		ResultSet rs=null;
		//一页显示的记录数
		int number=3;
		int begin=(pageNo*number)-2;
		int end=pageNo * number;
		//循环计数器，默认为1
		int index=1;
		DBBean db=new DBBean();
		ArrayList commentList=new ArrayList();
		String sql="select *  from comment_view where comToId='"+postId+"' order by commentId desc";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			while(rs.next()){
				//在begin之前的记录不显示。
				if(index<begin){
					index++;
					continue;
				}
				//在end之后的记录不显示
				if(index>end)
					break;
				index++;
				int commentId=rs.getInt(1);
				int comFromUserId=rs.getInt(2);
				int comToId=rs.getInt(3);
				String comUserName=rs.getString(4);
				String comUserPhoto=rs.getString(5);
				String stype=rs.getString(6);
				String comContent=rs.getString(7);
				String comTime=rs.getString(8);
				CommentBean comment=new CommentBean();
				comment.setCommentId(commentId);
				comment.setComFromUserId(comFromUserId);
				comment.setComToId(comToId);
				comment.setComUserName(comUserName);
				comment.setComUserPhoto(comUserPhoto);
				comment.setStype(stype);
				comment.setComContent(comContent);
				comment.setComTime(comTime);
				commentList.add(comment);
				
				
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
		
		
		return commentList;
		

		
		
	}
public ArrayList showCommentNote(String userId){
		
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		ArrayList noteList=new ArrayList();
		String sql="select * from commentnote_view where comToUserId='"+userId+"' order by commentId desc";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			while(rs.next()){
				
				int commentId=rs.getInt(1);
				String comFromUserName=rs.getString(2);
				int comToUserId=rs.getInt(3);
				String postTitle=rs.getString(4);
				String comContent=rs.getString(5);
				String comTime=rs.getString(6);
				CommentBean comment=new CommentBean();
				comment.setCommentId(commentId);
				comment.setComFromUserName(comFromUserName);
				comment.setComToUserId(comToUserId);
				comment.setPostTitle(postTitle);
				comment.setComContent(comContent);
				comment.setComTime(comTime);
				
				noteList.add(comment);
				
				
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

	/**
	 *@Description：删除评论
	 *@param commentId
	 *@return
	 *@throws Exception: int
	 *@Author:xupengfei
	 */
	public int deleteComment(String commentId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		
		String sql="delete from comment_table where commentId='"+commentId+"'";
		con=dbBean.getConnection();
		int i=dbBean.executeUpdate(sql);
		dbBean.close();
		return i;
		}
	
		/**
		 *@Description：获取评论的总数
		 *@param postId
		 *@return
		 *@throws Exception: int
		 *@Author:xupengfei
		 */
		public int getCommentCount(String postId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		ResultSet rs;
		String sql="select * from comment_table where comToId='"+postId+"'";
		con=dbBean.getConnection();
		rs=dbBean.executeQuery(sql);
		int num=0;
		while(rs.next()){
			num++;
			
		}
		dbBean.close();
		return num;
		
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getComFromUserId() {
		return comFromUserId;
	}
	public void setComFromUserId(int comFromUserId) {
		this.comFromUserId = comFromUserId;
	}
	public int getComToId() {
		return comToId;
	}
	public void setComToId(int comToId) {
		this.comToId = comToId;
	}
	public String getComUserName() {
		return comUserName;
	}
	public void setComUserName(String comUserName) {
		this.comUserName = comUserName;
	}
	public String getComUserPhoto() {
		return comUserPhoto;
	}
	public void setComUserPhoto(String comUserPhoto) {
		this.comUserPhoto = comUserPhoto;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public String getComTime() {
		return comTime;
	}
	public void setComTime(String comTime) {
		this.comTime = comTime;
	}
	public int getComStatus() {
		return comStatus;
	}
	public void setComStatus(int comStatus) {
		this.comStatus = comStatus;
	}

	public String getComFromUserName() {
		return comFromUserName;
	}

	public void setComFromUserName(String comFromUserName) {
		this.comFromUserName = comFromUserName;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public int getComToUserId() {
		return comToUserId;
	}

	public void setComToUserId(int comToUserId) {
		this.comToUserId = comToUserId;
	}
	

}
