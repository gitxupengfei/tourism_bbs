package com.tourism_bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourism_bbs.bean.AttentionBean;
import com.tourism_bbs.bean.CollectionBean;


public class AddCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId=Integer.parseInt(request.getParameter("postId"));
		HttpSession session=request.getSession();
		int  userId=(int)session.getAttribute("userid");
		CollectionBean collection=new CollectionBean();
		collection.setColPostId(postId);
		collection.setColUserId(userId);
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("utf-8");
		String info;
		try {
			if(!collection.hasCollection(postId, userId)){
				collection.addCollection();
				info="OK";
				
			}
			
			else info="Error";
			
			out.print(info);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
