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


public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("register_password");
		String question1=new String(request.getParameter("question1").getBytes("iso-8859-1"),"utf-8");
		String answer1=new String(request.getParameter("answer1").getBytes("iso-8859-1"),"utf-8");
		String question2=new String(request.getParameter("question2").getBytes("iso-8859-1"),"utf-8");
		String answer2=new String(request.getParameter("answer2").getBytes("iso-8859-1"),"utf-8");;
		System.out.println(question1);
		String info;
		UserBean userBean=new UserBean();
		userBean.setPasswrd(password);
		userBean.setQuestion1(question1);
		userBean.setAnswer1(answer1);
		userBean.setQuestion2(question2);
		userBean.setAnswer2(answer2);
		try {
			int result= userBean.changePassword();
			System.out.println(result);
			HttpSession session=request.getSession();
			session.setAttribute("password", password);
			RequestDispatcher rd=request.getRequestDispatcher("passwordChangeOK.jsp");
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
