package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PostListBean {
	private int postId;
	private int postUserId;
	private String title;
	private String picture;
	private String styleLabel;
	private String placeLabel;
	private String postContent;
	private String postTime;
	private int postCollectionNum;
	private int postCommentNum;
	private String userName;
	private String photo;
	private int attentionNum;
	private int collectionNum;
	
	/**
	 *@Description�����ݲ�ͬ��ѡ�񣬻�ȡ��ʾ����ҳ�������б�
	 *@param sql
	 *@return: ArrayList<PostListBean>
	 * @throws Exception 
	 *@Author:xupengfei
	 */
	public ArrayList<PostListBean> getPostList(String sql,String pageNo) throws Exception{
		ArrayList<PostListBean> postlist=new ArrayList<PostListBean>();
		Connection con=null;
		DBBean dbBean=new DBBean();
		ResultSet rs;
		con=dbBean.getConnection();
		rs=dbBean.executeQuery(sql);
		//Ҫ��ʾ��ҳ�룬Ĭ��ֵΪ1
		int iPageNo=1;
		iPageNo=Integer.parseInt(pageNo);
		//Ҫ��ʾ�ĵ�һ����¼,ÿҳ��ʾ������¼
		int begin=(iPageNo-1)*5+1;
		//Ҫ��ʾ�����һ����¼
		int end=iPageNo*5;
		//ѭ��������
		int index=0;
		//�Խ��������
		while(rs.next()){
			index++;
			//�����û�е�Ҫ��ʾ�ĵ�һ����¼���ͼ�������
			if(index<begin){
				continue;
			}
			if(index>end){
				break;
			}
			//��ȡ�������Ϣ��
		     int postId=rs.getInt(1);
		     int postUserId=rs.getInt(2);
			 String title=rs.getString(3);
			 String picture=rs.getString(4);
			 String styleLabel=rs.getString(5);
			 String placeLabel=rs.getString(6);
			 String postContent=rs.getString(7);
			 String postTime=rs.getString(8);
			 int postCollectionNum=rs.getInt(9);
			 int postCommentNum=rs.getInt(10);
			 String userName=rs.getString(11);
			 String photo=rs.getString(12);
			 int attentionNum=rs.getInt(13);
			 int collectionNum=rs.getInt(14);
			 PostListBean post=new PostListBean();
			 post.setPostId(postId);
			 post.setPostUserId(postUserId);
			 post.setTitle(title);
			 post.setPicture(picture);
			 post.setStyleLabel(styleLabel);
			 post.setPlaceLabel(placeLabel);
			 post.setPostContent(postContent);
			 post.setPostTime(postTime);
			 post.setPostCollectionNum(postCollectionNum);
			 post.setPostCommentNum(postCommentNum);
			 post.setUserName(userName);
			 post.setPhoto(photo);
			 post.setAttentionNum(attentionNum);
			 post.setCollectionNum(collectionNum);
			 postlist.add(post);
			
			 
			
		}
		
		
		
		
		dbBean.close();
		return postlist;
		
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
	public int getPostCollectionNum() {
		return postCollectionNum;
	}
	public void setPostCollectionNum(int postCollectionNum) {
		this.postCollectionNum = postCollectionNum;
	}
	public int getPostCommentNum() {
		return postCommentNum;
	}
	public void setPostCommentNum(int postCommentNum) {
		this.postCommentNum = postCommentNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	
	
	
}
