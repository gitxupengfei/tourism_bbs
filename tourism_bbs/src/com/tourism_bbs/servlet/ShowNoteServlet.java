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

import com.tourism_bbs.bean.CommentBean;
import com.tourism_bbs.bean.LeaveWordsBean;
import com.tourism_bbs.bean.SystemNoteBean;


public class ShowNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList noteList=new ArrayList();
		Object styleObj=request.getParameter("style");
		String forward = null;
		HttpSession session=request.getSession();
		String userId= session.getAttribute("userid").toString();
		if(styleObj!=null){
			String style=styleObj.toString();
		if(style.equals("leave")){
			LeaveWordsBean leave=new LeaveWordsBean();
			noteList=leave.showLeaveWords(userId);
			forward="leaveNote.jsp";
			
		}
		if(style.equals("system")){
			SystemNoteBean system=new SystemNoteBean();
			noteList=system.showNote(userId);
			forward="systemNote.jsp";
		}
		if(style.equals("comment")){
			CommentBean comment=new CommentBean();
			noteList=comment.showCommentNote(userId);
			forward="commentNote.jsp";
		}
		
		}
		else{
		SystemNoteBean system=new SystemNoteBean();
		noteList=system.showNote(userId);
		forward="myNote.jsp";
		}
		
		request.setAttribute("noteList", noteList);
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
