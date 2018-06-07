package com.tourism_bbs.bean;

import java.sql.Connection;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@Description£ºÌû×ÓBean
 * @author£ºxupengfei
 *
 */
public class PostBean {
	private int postId;
	private int postUserId;
	private String title;
	private String picture;
	private String styleLabel;
	private String placeLabel;
	private String postContent;
	private String postTime;
	
	
	public void addPost() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		postTime=df.format(day);
		sql.append("insert into Post_Table(postUserId,title,picture,styleLabel,placeLabel,postContent,postTime) values('");
		sql.append(postUserId);
		System.out.println(postUserId);
		sql.append("','");
		sql.append(title);
		sql.append("','");
		sql.append(picture);
		sql.append("','");
		sql.append(styleLabel);
		sql.append("','");
		sql.append(placeLabel);
		sql.append("','");
		sql.append(postContent);
		sql.append("','");
		sql.append(postTime);
		sql.append("')");
		try {
			con=dbBean.getConnection();
			dbBean.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
		
	}
	public int getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(int postUserId) {
		this.postUserId = postUserId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getStyleLabel() {
		return styleLabel;
	}
	public void setStyleLabel(String styleLabel) {
		this.styleLabel = styleLabel;
	}
	public String getPlaceLabel() {
		return placeLabel;
	}
	public void setPlaceLabel(String placeLabel) {
		this.placeLabel = placeLabel;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	

	
	
}
