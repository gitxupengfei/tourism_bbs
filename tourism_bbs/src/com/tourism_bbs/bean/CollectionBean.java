package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *@Description：收藏Bean
 * @author：xupengfei
 *
 */
public class CollectionBean {
	private int collectionId;
	
	/**
	 * 收藏的文章ID
	 */
	private int colPostId;
	/**
	 * 收藏者的用户ID
	 */
	private int colUserId;
	
	/**
	 * 收藏文章的作者ID
	 */
	private String colPostUserName;
	/**
	 * 收藏文章的标题
	 */
	private String colPostTitle;
	
	/**
	 * 收藏文章的发表时间
	 */
	private String colPostTime;
	
	
	
	/**
	 *@Description：添加收藏
	 *@throws Exception: void
	 *@Author:xupengfei
	 */
	public void addCollection() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		sql.append("insert into collection_table(colPostId,colUserId) values ('");
		sql.append(colPostId);
		sql.append("','");
		sql.append(colUserId);
		sql.append("')");
		con=dbBean.getConnection();
		dbBean.executeUpdate(sql.toString());
		dbBean.close();
		
	}
	
	/**
	 *@Description：判断用户是否已经收藏该文章
	 *@param postId
	 *@param userId
	 *@return
	 *@throws Exception: boolean
	 *@Author:xupengfei
	 */
	public boolean hasCollection(int postId,int userId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		ResultSet rs;
		String sql="select * from collection_table where colPostId='"+postId+"' and colUserId='"+userId+"'";
		
		con=dbBean.getConnection();
		rs=dbBean.executeQuery(sql);
		if(rs.next()){
			return true;
		}
		return false;
		
	}
	
	
	/**
	 *@Description：展示我的收藏
	 *@param pageNo
	 *@param userId
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showCollection(int pageNo,String userId){
			
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
			String sql="select *  from mycollection_view where colUserId='"+userId+"' order by collectionId desc";
			
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
					int collectionId=rs.getInt(1);
					int colPostId=rs.getInt(2);
					int colUserId=rs.getInt(3);
					String title=rs.getString(4);
					String postTime=rs.getString(5);
					CollectionBean collection=new CollectionBean();
					collection.setCollectionId(collectionId);
					collection.setColPostId(colPostId);
					collection.setColUserId(colUserId);
					collection.setColPostTitle(title);
					collection.setColPostTime(postTime);
					posts.add(collection);
					
					
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
	 *@Description：删除收藏
	 *@param collectionId
	 *@return
	 *@throws Exception: int
	 *@Author:xupengfei
	 */
	public int deleteCollection(String collectionId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		
		String sql="delete from collection_table where collectionId='"+collectionId+"'";
		con=dbBean.getConnection();
		int i=dbBean.executeUpdate(sql);
		dbBean.close();
		return i;
		
		
			
		}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getColPostId() {
		return colPostId;
	}
	public void setColPostId(int colPostId) {
		this.colPostId = colPostId;
	}
	public int getColUserId() {
		return colUserId;
	}
	public void setColUserId(int colUserId) {
		this.colUserId = colUserId;
	}
	public String getColPostUserName() {
		return colPostUserName;
	}
	public void setColPostUserName(String colPostUserName) {
		this.colPostUserName = colPostUserName;
	}
	public String getColPostTitle() {
		return colPostTitle;
	}
	public void setColPostTitle(String colPostTitle) {
		this.colPostTitle = colPostTitle;
	}
	public String getColPostTime() {
		return colPostTime;
	}
	public void setColPostTime(String colPostTime) {
		this.colPostTime = colPostTime;
	}
	
}
