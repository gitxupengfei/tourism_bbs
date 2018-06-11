package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.CollectionBean;
import com.tourism_bbs.bean.PostBean;


public class DeleteMyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postid=request.getParameter("postId");
		String collectionId=request.getParameter("collectionId");
		PostBean postBean=new PostBean();
		CollectionBean collection=new CollectionBean();
		System.out.println(postid);
		System.out.println(collectionId);
		
		try {
			if(postid!=null){
				int result1=postBean.deleteMyPost(postid);
			}
			 if(collectionId!=null){
				 int result2=collection.deleteCollection(collectionId);
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
