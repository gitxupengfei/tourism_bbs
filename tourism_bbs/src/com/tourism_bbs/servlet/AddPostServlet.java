package com.tourism_bbs.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tourism_bbs.bean.PostBean;


public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("picture", null);
		//获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
        String path = request.getRealPath("/picture");  
      
          
        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          
        try {  
             List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            for(FileItem item : list)  
            {  
                //获取表单的属性名字  
                String name = item.getFieldName();  
                  
                //如果获取的 表单信息是普通的 文本 信息  
                if(item.isFormField())  
                {                     
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                	
                	String value = new String(item.getString().getBytes("iso-8859-1"),"utf-8") ;  
                    request.setAttribute(name, value);  
                }  
                else  
                {  
                    /** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    //获取路径名  
                    String value = item.getName() ; 
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename = value.substring(start+1);  
                    request.setAttribute("picture", filename);  
                      
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                      
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
                        out.write(buf, 0, length);  
                          
                    }  
                      
                    in.close();  
                    out.close();  
                }  
            }  
              
              
              
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        catch (Exception e) {  
            // TODO Auto-generated catch block  
              
            e.printStackTrace();  
        }  
		HttpSession session=request.getSession();
		//获取登录的用户id
        int postUserId=(Integer) session.getAttribute("userid");
		String title=(String)request.getAttribute("title");
		String picture=(String)request.getAttribute("picture");
		String styleLabel=(String)request.getAttribute("style");
		String placeLabel=(String)request.getAttribute("place");
		String postHTML=(String)request.getAttribute("postContent");
		System.out.println("--<br/>"+postHTML+"<br/>--");
		String postContent=postHTML.replaceAll(" ","&nbsp;&nbsp;").replaceAll("\r","<br/>");  
		request.setAttribute("postContent", postContent);
		System.out.println(postContent);
		PostBean post=new PostBean();
		//传值至PostBean
		post.setPostUserId(postUserId);
		post.setTitle(title);
		post.setPicture(picture);
		post.setStyleLabel(styleLabel);
		post.setPlaceLabel(placeLabel);
		post.setPostContent(postContent);
		
		String forward=null;
		String info=null;
		try {
			
			post.addPost();
			info="发布成功！可前往我的发帖查看！";
			forward="spacePostingSuccess.jsp";
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		info="系统异常，发布失败！";
		forward="spacePosting.jsp";
		
	}
	
	request.setAttribute("postinginfo", info);
	RequestDispatcher rd=request.getRequestDispatcher(forward);
	rd.forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
