package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourism_bbs.bean.UserBean;


public class ShowSpaceGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean=new UserBean();
		HttpSession session=request.getSession();
	String userid=String.valueOf(session.getAttribute("userid"));
	

	

	
		try {
			UserBean user=userBean.getUserLevel(userid);
			request.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("spaceGuide.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
