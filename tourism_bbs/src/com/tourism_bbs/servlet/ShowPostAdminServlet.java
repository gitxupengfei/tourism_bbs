package com.tourism_bbs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.PostListBean;
import com.tourism_bbs.bean.UserBean;

@WebServlet("/ShowPostAdminServlet")
public class ShowPostAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object pageObj=request.getParameter("pageNo");
		Object postIdObj=request.getParameter("postId");
		Object userNameObj=request.getParameter("userName");
		
		String pageNo;
		String forward;
		String sql;
		
		//·ÖÒ³Ìø×ª
		if(pageObj!=null ){
				pageNo=pageObj.toString();
				forward="postAdminAjax.jsp";
				sql="select *  from post_user_view order by postId asc";
		}
		//²éÑ¯
		else if(postIdObj!=null || userNameObj!=null){
			String postId=postIdObj.toString();
			String userName=userNameObj.toString();
			pageNo="1";
			forward="postAdminAjax.jsp";
			sql="select * from post_user_view where postId='"
					+postId+"' or userName='"+userName+"'";
					
			}
			else{
					pageNo="1";
					forward="adminPost.jsp";
					sql="select *  from post_user_view order by postId asc";
				}
		ArrayList<PostListBean> postList=new ArrayList<PostListBean>();
		PostListBean postListBean=new PostListBean();
		int pageCount = 0;
		try {
			postList=postListBean.getPostList(sql,pageNo);
			 pageCount = postListBean.getPageCount(sql);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("postList", postList);
		request.setAttribute("currentPage", Integer.parseInt(pageNo));
		request.setAttribute("pageCount",pageCount);
		
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
