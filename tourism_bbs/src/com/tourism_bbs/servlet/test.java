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


public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//获取从页面中传递的第几页信息To do:
				String pageNo=request.getParameter("pageNo");
				request.setAttribute("currentPage", pageNo);
				
				PostListBean postListBean=new PostListBean();
				ArrayList<PostListBean> postList=new ArrayList<PostListBean>();
				HttpSession session=request.getSession();
				Object searchObject=session.getAttribute("search");
				
				String sql;
				//判断是否搜索过
				if(searchObject!=null ){
					String search=searchObject.toString();
					sql="select * from post_user_view where title like '%"+ search+
							"%' or styleLabel like '%"+search+"%' or placeLabel like '%"+
							search+"%' or userName like '%"+search+"%' order by postId desc";
					
				}
				else
					sql="select * from post_user_view order by postId desc";
				try {
					
					postList=postListBean.getPostList(sql, pageNo);
					request.setAttribute("postList", postList);
					int pageCount=postListBean.getPageCount(sql);
					request.setAttribute("pageCount",pageCount);

					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd=request.getRequestDispatcher("postListAjax.jsp");
				rd.forward(request, response);
				
				
			}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
