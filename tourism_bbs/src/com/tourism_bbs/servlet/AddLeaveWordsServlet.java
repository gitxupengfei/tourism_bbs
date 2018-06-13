package com.tourism_bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.CommentBean;
import com.tourism_bbs.bean.LeaveWordsBean;


public class AddLeaveWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//¡Ù—‘
		Object postUserIdObj=request.getParameter("postUserId");
		int  userId=Integer.parseInt(request.getParameter("userId"));
		
		
		//∆¿¬€
		Object postIdObj=request.getParameter("postId");
		//≈–∂œ «∑ÒŒ™¡Ù—‘
		if(postUserIdObj!=null){
			int postUserId=Integer.parseInt(postUserIdObj.toString());
			String leaveWords=request.getParameter("leaveWords");
			LeaveWordsBean leave=new LeaveWordsBean();
			leave.setLeaveToUserId(postUserId);
			leave.setLeaveFromUserId(userId);
			leave.setLeaveWords(leaveWords);
		try {
			leave.addLeaveWords();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//≈–∂œ «∑Ò «∆¿¬€
		else if(postIdObj!=null){
			int postId=Integer.parseInt(postIdObj.toString());
			String commentContent=request.getParameter("commentContent");
			CommentBean comment=new CommentBean();
			comment.setComFromUserId(userId);
			comment.setComToId(postId);
			comment.setComContent(commentContent);
			try {
				comment.addComment();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
