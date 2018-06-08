package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.PostBean;


public class ShowMyPostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId=request.getParameter("postId");
		System.out.println(postId);
		PostBean postBean=new PostBean();
		try {
			PostBean post=new PostBean();
			post=postBean.showMyPostDetail(postId);
			request.setAttribute("myPost", post);
			RequestDispatcher rd=request.getRequestDispatcher("myPostDetail.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
