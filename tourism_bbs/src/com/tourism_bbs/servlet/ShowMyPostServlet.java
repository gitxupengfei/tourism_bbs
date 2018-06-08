package com.tourism_bbs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourism_bbs.bean.PostBean;



public class ShowMyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostBean postBean=new PostBean();
		ArrayList posts=new ArrayList();
		HttpSession session=request.getSession();
		int userId=(int) session.getAttribute("userid");
		String postUserId=String.valueOf(userId);
		posts=postBean.showMyPost(1, postUserId);
		request.setAttribute("myPosts", posts);
		RequestDispatcher rd=request.getRequestDispatcher("myPost.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
