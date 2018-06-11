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

import com.tourism_bbs.bean.CollectionBean;
import com.tourism_bbs.bean.PostBean;



public class ShowMyCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollectionBean collectionBean=new CollectionBean();
		ArrayList collection=new ArrayList();
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("userid");
		String userId=String.valueOf(id);
		collection=collectionBean.showCollection(1, userId);
		request.setAttribute("collection", collection);
		RequestDispatcher rd=request.getRequestDispatcher("myCollection.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
