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


public class FindPasswordOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName=request.getParameter("username");
		String telephone=request.getParameter("telephone");
		String info=null;
		String forward = null;
		UserBean userdb=new UserBean();
		UserBean passwordInfo=userdb.findPassword(userName, telephone);
		request.setAttribute("passwordInfo", passwordInfo);
		request.setAttribute("answer1", passwordInfo.getAnswer1());
		request.setAttribute("answer2", passwordInfo.getAnswer2());
		
		if(passwordInfo==null){
			info="您查找的用户不存在，请重新输入！";
			request.setAttribute("findPasswordOneInfo", info);
			forward="findPasswordOne.jsp";
		}
		else forward="findPasswordTwo.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
