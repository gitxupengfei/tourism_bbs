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



public class ShowPostListByCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=1;
		HttpSession session=request.getSession();
		request.setAttribute("currentPage", pageNo);
		Object searchObject=request.getParameter("search");
		Object searchSession=session.getAttribute("search");
		Object orderObject=request.getParameter("order");
		Object styleObject=request.getParameter("style");
		String search;
		String order;
		String style;
		PostListBean postListBean=new PostListBean();
		ArrayList<PostListBean> postList=new ArrayList<PostListBean>();
		//判断是否是搜索按钮触发的servlet
		if(searchObject!=null){
			 search=searchObject.toString();
			 session.removeAttribute("order");
			 session.removeAttribute("style");
		}
		//判断是否已经搜索过
		else if(searchSession!=null){
			search=searchSession.toString();
		}
		else search=""; 
		session.setAttribute("search", search);
		Object orderSession=session.getAttribute("order");
		//判断是否采用了排序
		if(orderObject!=null){
			order=orderObject.toString();
			if(order.equals("hot")) order="postCommentNum";
			else if(order.equals("great")) order="postCollectionNum";
			else if(order.equals("famous")) order="(attentionNum*10+collectionNum)";
			else if(order.equals("time")) order="postId";
		}
		
		else if(orderSession!=null){
			order=orderSession.toString();
			if(order.equals("hot")) order="postCommentNum";
			else if(order.equals("great")) order="postCollectionNum";
			else if(order.equals("famous")) order="(attentionNum*10+collectionNum)";
			else if(order.equals("time")) order="postId";
		}
		//默认是按时间排序
		else order="postId";
		session.setAttribute("order", order);
		//判断是否选择了出行方式
		Object styleSession=session.getAttribute("style");
		if(styleObject!=null){
			style=styleObject.toString();
			if(style.equals("any")) style="";
			else if(style.equals("foot")) style="步行";
			else if(style.equals("bike")) style="自行车";
			else if(style.equals("bus")) style="汽车";
			else if(style.equals("train")) style="火车";
			else if(style.equals("plane")) style="飞机";
			else if(style.equals("boat")) style="轮船";
			
		}
		else if(styleSession!=null){
			style=styleSession.toString();
			if(style.equals("any")) style="";
			else if(style.equals("foot")) style="步行";
			else if(style.equals("bike")) style="自行车";
			else if(style.equals("bus")) style="汽车";
			else if(style.equals("train")) style="火车";
			else if(style.equals("plane")) style="飞机";
			else if(style.equals("boat")) style="轮船";
			
		}
		else style="";
		session.setAttribute("style", style);
		String sql="select * from post_user_view where (title like '%"+ search+
				"%' or styleLabel like '%"+search+"%' or placeLabel like '%"+
				search+"%' or userName like '%"+search+"%') and styleLabel like '"
				+style+"%' order by "+order+" desc";
		
		try {
			postList=postListBean.getPostList(sql, String.valueOf(pageNo));
			int pageCount=postListBean.getPageCount(sql);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("postList", postList);
			
			
		
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
