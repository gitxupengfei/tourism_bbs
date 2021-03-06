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

import com.tourism_bbs.bean.UserBean;
/**
 * 
 *@Description：修改个人信息
 * @author：xupengfei
 *
 */

public class UpdatePersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setAttribute("photo", null);
		//获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
        String path = request.getRealPath("/userphoto");  
          
       
        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          
        try {  
            //可以上传多个文件  
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
                //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
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
                    request.setAttribute("photo", filename);  
                      
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                      
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                    // in.read(buf) 每次读到的数据存放在   buf 数组中  
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
              
            //e.printStackTrace();  
        }  
          
        String userName=(String) request.getAttribute("register_username");
		String  sex=(String) request.getAttribute("sex");
		String age=(String) request.getAttribute("age");
		String hometown=(String) request.getAttribute("hometown");
		String school=(String) request.getAttribute("school");
		String telephone=(String) request.getAttribute("phone");
		String QQ=(String) request.getAttribute("QQ");
		String introduce=(String) request.getAttribute("introduce");
		String photoPath=(String) request.getAttribute("photo");
		
		HttpSession session=request.getSession();
		int userId=(int) session.getAttribute("userid");
		
		
		UserBean userBean=new UserBean();
		//属性赋值
		userBean.setUserId(userId);
		userBean.setUserName(userName);
		userBean.setAge(age);
		userBean.setSex(sex);
		userBean.setHometown(hometown);
		userBean.setSchool(school);
		userBean.setTelephone(telephone);
		userBean.setQQ(QQ);
		userBean.setIntroduce(introduce);
		userBean.setPhoto(photoPath);
		try {
			
			int result=userBean.update();
			//更改用户图片
			session.setAttribute("photo", photoPath);
			session.setAttribute("username", userName);
			RequestDispatcher rd=request.getRequestDispatcher("personalInfoChangeSuccess.jsp");
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
