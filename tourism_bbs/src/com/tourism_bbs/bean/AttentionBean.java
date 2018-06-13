package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 *@Description����עbean
 * @author��xupengfei
 *
 */
public class AttentionBean {
	private int attentionId;
	private int attFromUserId;
	private int attToUserId;
	/**
	 * �û�����ֵ
	 */
	private int experienceNum;
	
	/**
	 * �û��ȼ�
	 */
	private int attLevel;
	
	


	/**
	 * �û��ķ�˿����
	 */
	private int attentionNum;
	
	/**
	 * �û�����������ܵ��ղ���
	 */
	private int collectionNum;
	
	/**
	 * ����ע���û���
	 */
	private String attToUserName;
	/**
	 * ����ע���û���ѧУ
	 */
	private String attSchool;
	
	/**
	 * ����ע���û�ͷ��
	 */
	private String attPhoto;
	
	
	/**
	 *@Description��: void��ӹ�ע
	 * @throws Exception 
	 *@Author:xupengfei
	 */
	public void addAttention() throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		StringBuffer sql=new StringBuffer();
		sql.append("insert into attention_table(attFromUserId,attToUserId) values ('");
		sql.append(attFromUserId);
		sql.append("','");
		sql.append(attToUserId);
		sql.append("')");
		con=dbBean.getConnection();
		dbBean.executeUpdate(sql.toString());
		dbBean.close();
		
	}
	
	/**
	 *@Description���ж��û��Ƿ��Ѿ���ע�˸�����
	 *@param postUserId ����id
	 *@param userId  �û�id
	 *@return: boolean true:�ѹ�ע��false��δ��ע
	 * @throws Exception 
	 *@Author:xupengfei
	 */
	public boolean hasAtteention(int postUserId,int userId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		ResultSet rs;
		String sql="select * from attention_table where attFromUserId='"+userId+"' and attToUserId='"+postUserId+"'";
		
		con=dbBean.getConnection();
		rs=dbBean.executeQuery(sql);
		if(rs.next()){
			return true;
		}
		return false;
		
	}
	
	/**
	 *@Description��չʾ�û��Ĺ�ע�б�
	 *@param pageNo
	 *@param userId
	 *@return: ArrayList
	 *@Author:xupengfei
	 */
	public ArrayList showAttention(int pageNo,String userId){
		
		Connection con=null;
		ResultSet rs=null;
		//һҳ��ʾ�ļ�¼��
		int number=20;
		int begin=(pageNo*number)-19;
		int end=pageNo * number;
		//ѭ����������Ĭ��Ϊ1
		int index=1;
		DBBean db=new DBBean();
		ArrayList attentionList=new ArrayList();
		String sql="select *  from myattention_view where attFromUserId='"+userId+"' order by attentionId desc";
		
		try {
			con=db.getConnection();
			rs=db.executeQuery(sql);
			while(rs.next()){
				//��begin֮ǰ�ļ�¼����ʾ��
				if(index<begin){
					index++;
					continue;
				}
				//��end֮��ļ�¼����ʾ
				if(index>end)
					break;
				index++;
				int attentionId=rs.getInt(1);
				int attFromUserId=rs.getInt(2);
				int attToUserId=rs.getInt(3);
				int attentionNum=rs.getInt(4);
				int collectionNum=rs.getInt(5);
				int level=((attentionNum*10)+collectionNum)/100+1;
				String attUserName=rs.getString(6);
				String attSchool=rs.getString(7);
				String photo=rs.getString(8);
				AttentionBean attention=new AttentionBean();
				attention.setAttentionId(attentionId);
				attention.setAttFromUserId(attFromUserId);
				attention.setAttToUserId(attToUserId);
				attention.setAttLevel(level);
				attention.setAttToUserName(attUserName);
				attention.setAttSchool(attSchool);
				attention.setAttPhoto(photo);
				
				attentionList.add(attention);
				
				
				
				
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
		
		
		return attentionList;
		

		
		
	}
	
	
	/**
	 *@Description��ȡ����ע��
	 *@param attentionId
	 *@return
	 *@throws Exception: int
	 *@Author:xupengfei
	 */
	public int deleteAttention(String attentionId) throws Exception{
		Connection con=null;
		DBBean dbBean=new DBBean();
		
		String sql="delete from attention_table where attentionId='"+attentionId+"'";
		con=dbBean.getConnection();
		int i=dbBean.executeUpdate(sql);
		dbBean.close();
		return i;
		
		
			
		}
	
	public int getAttentionId() {
		return attentionId;
	}
	public void setAttentionId(int attentionId) {
		this.attentionId = attentionId;
	}
	public int getAttFromUserId() {
		return attFromUserId;
	}
	public void setAttFromUserId(int attFromUserId) {
		this.attFromUserId = attFromUserId;
	}
	public int getAttToUserId() {
		return attToUserId;
	}
	public void setAttToUserId(int attToUserId) {
		this.attToUserId = attToUserId;
	}

	public int getExperienceNum() {
		return experienceNum;
	}

	public void setExperienceNum(int experienceNum) {
		this.experienceNum = experienceNum;
	}

	public int getAttLevel() {
		return attLevel;
	}

	public void setAttLevel(int attLevel) {
		this.attLevel = attLevel;
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

	public String getAttToUserName() {
		return attToUserName;
	}

	public void setAttToUserName(String attToUserName) {
		this.attToUserName = attToUserName;
	}

	public String getAttSchool() {
		return attSchool;
	}

	public void setAttSchool(String attSchool) {
		this.attSchool = attSchool;
	}

	public String getAttPhoto() {
		return attPhoto;
	}

	public void setAttPhoto(String attPhoto) {
		this.attPhoto = attPhoto;
	}
	
}
