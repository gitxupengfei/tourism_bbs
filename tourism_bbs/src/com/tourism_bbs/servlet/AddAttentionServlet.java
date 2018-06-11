package com.tourism_bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourism_bbs.bean.AttentionBean;


public class AddAttentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postUserId=Integer.parseInt(request.getParameter("postUserId"));
		int  userId=Integer.parseInt(request.getParameter("userId"));
		AttentionBean attention=new AttentionBean();
		attention.setAttFromUserId(userId);
		attention.setAttToUserId(postUserId);
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("utf-8");
		String info;
		try {
			if(!attention.hasAtteention(postUserId, userId)){
				attention.addAttention();
				info="OK";
				
			}
			
			else info="Error";
			
			out.print(info);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
