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

import com.tourism_bbs.bean.PostListBean;



public class ShowPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=1;
		String forward;
		request.setAttribute("currentPage", pageNo);
		HttpSession session=request.getSession();
		PostListBean postListBean=new PostListBean();
		ArrayList<PostListBean> postList=new ArrayList<PostListBean>();
		String sql="select * from post_user_view order by postId desc";
		try {
			
			postList=postListBean.getPostList(sql, String.valueOf(pageNo));
			int pageCount=postListBean.getPageCount(sql);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("postList", postList);
			session.removeAttribute("search");
			session.removeAttribute("order");
			session.removeAttribute("style");
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object userid=session.getAttribute("userid");
		
		
		//ÅÐ¶ÏÓÃ»§ÊÇ·ñµÇÂ¼
		if (userid==null ){
			
			forward="home.jsp";
		}
		else forward="personalhome.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
