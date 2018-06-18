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
		Object pageObj=request.getParameter("pageNo");
		int pageNo;
		String postId=request.getParameter("postId");
		ArrayList commentList=new ArrayList();
		CommentBean comment=new CommentBean();
		PostBean postBean=new PostBean();
		String forward = null;
		if(pageObj!=null){
			pageNo=Integer.parseInt(pageObj.toString());
			forward="commentAjax.jsp";
			commentList=comment.showComment(pageNo, postId);
			request.setAttribute("commentList", commentList);
		}
		else{
			pageNo=1;
		
		try {
			PostBean post=new PostBean();
			post=postBean.showMyPostDetail(postId);
			commentList=comment.showComment(pageNo, postId);
			int postid=post.getPostId();
			request.setAttribute("postId", postid);
			request.setAttribute("post", post);
			request.setAttribute("commentList", commentList);
			request.setAttribute("currentPage", pageNo);
			request.setAttribute("pageCount", comment.getCommentCount(postId));
			forward="myPostDetail.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
