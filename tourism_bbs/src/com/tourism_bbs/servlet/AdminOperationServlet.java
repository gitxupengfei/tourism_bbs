package com.tourism_bbs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.PostBean;
import com.tourism_bbs.bean.PostListBean;
import com.tourism_bbs.bean.UserBean;


public class AdminOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=Integer.parseInt(request.getParameter("pageNo"));
		Object userIdObj=request.getParameter("userId");
		Object postIdObj=request.getParameter("postId");
		String style=request.getParameter("style");
		String forward = null;
		String sql;
		UserBean user=new UserBean();
		
		//status+1
		if(style.equals("add")){
			String userId=userIdObj.toString();
			user.addStatus(userId);
		    forward="userAdminAjax.jsp";
		    sql="select *  from user_admin_view where status<4  order by userId asc";
		    ArrayList<UserBean> userList=new ArrayList<UserBean>();
			
			userList=user.showUserAdmin(sql,pageNo);
			
			
			int	pageCount = user.getUserCount(sql);
			
			request.setAttribute("userList", userList);
			request.setAttribute("currentPage", pageNo);
			request.setAttribute("pageCount",pageCount);
		
		}
		else if(style.equals("sub")){
			String userId=userIdObj.toString();
			user.subStatus(userId);
		    forward="userAdminAjax.jsp";
		    sql="select *  from user_admin_view where status<4  order by userId asc";
		    ArrayList<UserBean> userList=new ArrayList<UserBean>();
			
			userList=user.showUserAdmin(sql,pageNo);
			
			int	pageCount = user.getUserCount(sql);
			
			request.setAttribute("userList", userList);
			request.setAttribute("currentPage", pageNo);
			request.setAttribute("pageCount",pageCount);
			
		}
		
		else if(style.equals("delete")){
			String postId=postIdObj.toString();
			PostBean post=new PostBean();
			PostListBean postListBean=new PostListBean();
			try {
				post.deleteMyPost(postId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    forward="postAdminAjax.jsp";
		    sql="select *  from post_user_view order by postId asc";
		    ArrayList<PostListBean> postList=new ArrayList<PostListBean>();
			
			int pageCount = 0;
			try {
				postList=postListBean.getPostList(sql,String.valueOf(pageNo));
				
				pageCount = postListBean.getPageCount(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("postList", postList);
			request.setAttribute("currentPage", pageNo);
			request.setAttribute("pageCount",pageCount);
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
