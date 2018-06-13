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
		//�ж��Ƿ���������ť������servlet
		if(searchObject!=null){
			 search=searchObject.toString();
			 session.removeAttribute("order");
			 session.removeAttribute("style");
		}
		//�ж��Ƿ��Ѿ�������
		else if(searchSession!=null){
			search=searchSession.toString();
		}
		else search=""; 
		session.setAttribute("search", search);
		Object orderSession=session.getAttribute("order");
		//�ж��Ƿ����������
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
		//Ĭ���ǰ�ʱ������
		else order="postId";
		session.setAttribute("order", order);
		//�ж��Ƿ�ѡ���˳��з�ʽ
		Object styleSession=session.getAttribute("style");
		if(styleObject!=null){
			style=styleObject.toString();
			if(style.equals("any")) style="";
			else if(style.equals("foot")) style="����";
			else if(style.equals("bike")) style="���г�";
			else if(style.equals("bus")) style="����";
			else if(style.equals("train")) style="��";
			else if(style.equals("plane")) style="�ɻ�";
			else if(style.equals("boat")) style="�ִ�";
			
		}
		else if(styleSession!=null){
			style=styleSession.toString();
			if(style.equals("any")) style="";
			else if(style.equals("foot")) style="����";
			else if(style.equals("bike")) style="���г�";
			else if(style.equals("bus")) style="����";
			else if(style.equals("train")) style="��";
			else if(style.equals("plane")) style="�ɻ�";
			else if(style.equals("boat")) style="�ִ�";
			
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
