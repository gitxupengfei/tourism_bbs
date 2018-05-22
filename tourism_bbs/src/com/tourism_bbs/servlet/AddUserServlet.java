package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tourism_bbs.bean.UserBean;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class AddUserServlet
 */

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//从request获取各属性的值
		//String userId=request.getParameter("userId");
		request.setCharacterEncoding("utf-8");
		
		String userName=request.getParameter("register_username");
		String password=request.getParameter("register_password");
		String question1=request.getParameter("question1");
		String answer1=request.getParameter("answer1");
		String question2=request.getParameter("question2");
		String answer2=request.getParameter("answer2");
		String  sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String hometown=request.getParameter("hometown");
		String school=request.getParameter("school");
		String telephone=request.getParameter("phone");
		String QQ=request.getParameter("QQ");
		String introduce=request.getParameter("introduce");
		String photoPath=request.getParameter("photoPath");
		UserBean userBean=new UserBean();
		//属性赋值
		System.out.println(userName);
		userBean.setUserName(userName);
		userBean.setPasswrd(password);
		userBean.setQuestion1(question1);
		userBean.setAnswer1(answer1);
		userBean.setQuestion2(question2);
		userBean.setAnswer2(answer2);
		userBean.setAge(age);
		userBean.setSex(sex);
		userBean.setHometown(hometown);
		userBean.setSchool(school);
		userBean.setTelephone(telephone);
		userBean.setQQ(QQ);
		userBean.setIntroduce(introduce);
		userBean.setPhotoPath(photoPath);
		System.out.println("图片："+photoPath);
		//跳转的页面
		String forward = null;
		//页面的提示信息
		String info = null;
		
		try {
			
				userBean.addUser();
				forward="registerSucess.jsp";
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="系统异常，注册失败！";
			forward="register.jsp";
			
		}
		
		request.setAttribute("info", info);
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
