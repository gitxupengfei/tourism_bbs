package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *@Description：帖子Bean
 * @author：xupengfei
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
	
	
	
	/**
	 *@Description：上传帖子（发帖）
	 *@throws Exception: void
	 *@Author:xupengfei
	 */
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
		finally{
			dbBean.close();
		}
		
		
		
	}
	
	
	
	
	/**
	 *@Description：展示：“我的帖子”
	 *@param pageNo
	 *@param userId
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showMyPost(int pageNo,String userId){
		
		Connection con=null;
		ResultSet rs=null;
		//一页显示的记录数
		int number=10;
		int begin=(pageNo*number)-9;
		int end=pageNo * number;
		//循环计数器，默认为1
		int index=1;
		DBBean db=new DBBean();
		ArrayList posts=new ArrayList();
		String sql="select postId,title,postTime  from Post_Table where postUserId='"+userId+"' order by postId desc";
		
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
				int postId=rs.getInt(1);
				String title=rs.getString(2);
				String postTime=rs.getString(3);
				PostBean postBean=new PostBean();
				postBean.setPostId(postId);
				postBean.setTitle(title);
				postBean.setPostTime(postTime);
				posts.add(postBean);
				
				
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
		
		
		return posts;
		

		
		
	}
	
	
		/**
		 *@Description：删除我的帖子
		 *@param postId: void
		 * @throws Exception 
		 *@Author:xupengfei
		 */
		public int deleteMyPost(String postId) throws Exception{
			Connection con=null;
			DBBean dbBean=new DBBean();
			
			String sql="delete from Post_Table where postId='"+postId+"'";
			con=dbBean.getConnection();
			int i=dbBean.executeUpdate(sql);
			dbBean.close();
			return i;
			
			
				
			}
		
	
	/**
	 *@Description：展示自己帖子的详细内容
	 *@param postId
	 *@return
	 *@throws Exception: PostBean
	 *@Author:xupengfei
	 */
	public PostBean showMyPostDetail(String postId) throws Exception{
		Connection con=null;
		ResultSet rs=null;
		DBBean db=new DBBean();
		PostBean post=new PostBean();
		String sql="select * from Post_Table where postId='"+postId+"'";
		db.getConnection();
		rs=db.executeQuery(sql);
		if(rs.next()){
			int postid=rs.getInt(1);
			int postUserId=rs.getInt(2);
			String title=rs.getString(3);
			String picture=rs.getString(4);
			String styleLabel=rs.getString(5);
			String placeLabel=rs.getString(6);
			String postConten=rs.getString(7);
			String postTime=rs.getString(8);
			post.setPostId(postid);
			post.setPostUserId(postUserId);
			post.setTitle(title);
			post.setPicture(picture);
			post.setStyleLabel(styleLabel);
			post.setPlaceLabel(placeLabel);
			post.setPostContent(postConten);
			post.setPostTime(postTime);
			db.close();
			
		}
		return post;
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
