package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.ResultSet;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class AttentionBean {
	private int attentionId;
	private int attFromUserId;
	private int attToUserId;
	
	
	
	
	
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
}
