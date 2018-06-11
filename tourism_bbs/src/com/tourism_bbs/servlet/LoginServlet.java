package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.tourism_bbs.bean.UserBean;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String info=null;
		String forward=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean userBean=new UserBean();
		
		UserBean user=userBean.login(username, password);

		if(user==null){
		
			info="用户名或密码输入错误！";
			forward="home";
		}
		else{
		HttpSession session=request.getSession();
		session.setAttribute("userid",user.getUserId());
		session.setAttribute("username", user.getUserName());
		session.setAttribute("photo", user.getPhotoPath());
		session.setAttribute("password", user.getPassword());
		int status=user.getStatus();
	
		if(status==5){
			forward="admin.jsp";
		}
		else if(status==0){
			info="该账号已被禁止登陆！";
			forward="home.jsp";
		}
		else{
			forward="home";
		}
		
		}
		request.setAttribute("loginInfo", info);
	
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
