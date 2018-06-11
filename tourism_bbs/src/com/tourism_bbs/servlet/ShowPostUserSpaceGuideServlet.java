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


public class ShowPostUserSpaceGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean=new UserBean();
		String forward;
		String postUserId=request.getParameter("postUserId");
		HttpSession session=request.getSession();
		String userid=String.valueOf(session.getAttribute("userid"));
		if(postUserId.equals(userid)){
			forward="spaceGuide.jsp";
		}
		else forward="postUserSpaceGuide.jsp";
		try {
			UserBean user=userBean.getUserLevel(postUserId);
			request.setAttribute("user", user);
			
			RequestDispatcher rd=request.getRequestDispatcher(forward);
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
