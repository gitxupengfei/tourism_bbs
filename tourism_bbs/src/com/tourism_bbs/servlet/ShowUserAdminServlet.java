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
import com.tourism_bbs.bean.UserBean;



public class ShowUserAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object pageObj=request.getParameter("pageNo");
		int pageNo;
		if(pageObj!=null){
			 pageNo=Integer.parseInt(pageObj.toString());
		}
		else pageNo=1;
		ArrayList<UserBean> userList=new ArrayList<UserBean>();
		UserBean userBean=new UserBean();
		String sql="select *  from user_admin_view where status<4  order by userId desc";
		userList=userBean.showUserAdmin(sql,pageNo);
		
		
		int	pageCount = userBean.getUserCount(sql);
		
		request.setAttribute("userList", userList);
		request.setAttribute("currentPage", pageNo);
		request.setAttribute("pageCount",pageCount);
		
		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
