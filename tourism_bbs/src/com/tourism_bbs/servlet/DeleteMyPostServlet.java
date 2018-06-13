package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.AttentionBean;
import com.tourism_bbs.bean.CollectionBean;
import com.tourism_bbs.bean.PostBean;


/**
 *@Description：删除我的帖子、收藏、关注。
 * @author：xupengfei
 *
 */
public class DeleteMyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postid=request.getParameter("postId");
		String collectionId=request.getParameter("collectionId");
		String attentionId=request.getParameter("attentionId");
		PostBean postBean=new PostBean();
		CollectionBean collection=new CollectionBean();
		AttentionBean attention=new AttentionBean();
		
		try {
			if(postid!=null){
				int result1=postBean.deleteMyPost(postid);
			}
			else if(collectionId!=null){
				 int result2=collection.deleteCollection(collectionId);
			 }
			else if(attentionId!=null){
				int result3=attention.deleteAttention(attentionId);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

}
}
