package com.tourism_bbs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.CommentBean;
import com.tourism_bbs.bean.PostBean;


public class ShowMyPostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId=request.getParameter("postId");
		ArrayList commentList=new ArrayList();
		CommentBean comment=new CommentBean();
		PostBean postBean=new PostBean();
		try {
			PostBean post=new PostBean();
			post=postBean.showMyPostDetail(postId);
			commentList=comment.showComment(1, postId);
			request.setAttribute("post", post);
			request.setAttribute("commentList", commentList);
			request.setAttribute("currentPage", 1);
			request.setAttribute("pageCount", comment.getCommentCount(postId));
			RequestDispatcher rd=request.getRequestDispatcher("myPostDetail.jsp");
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
