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
		//��ô����ļ���Ŀ����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //��ȡ�ļ���Ҫ�ϴ�����·��  
        String path = request.getRealPath("/picture");  
      
          
        factory.setRepository(new File(path));  
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024*1024) ;  
          
        //��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          
        try {  
             List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            for(FileItem item : list)  
            {  
                //��ȡ������������  
                String name = item.getFieldName();  
                  
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ  
                if(item.isFormField())  
                {                     
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�  
                	
                	String value = new String(item.getString().getBytes("iso-8859-1"),"utf-8") ;  
                    request.setAttribute(name, value);  
                }  
                else  
                {  
                    /** 
                     * ������������Ҫ��ȡ �ϴ��ļ������� 
                     */  
                    //��ȡ·����  
                    String value = item.getName() ; 
                    //���������һ����б��  
                    int start = value.lastIndexOf("\\");  
                    //��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�  
                    String filename = value.substring(start+1);  
                    request.setAttribute("picture", filename);  
                      
                    //����д��������  
                    //���׳����쳣 ��exception ��׽  
                      
                    //item.write( new File(path,filename) );//�������ṩ��  
                      
                    //�ֶ�д��  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //��   buf ������ ȡ������ д�� ���������������  
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
		//��ȡ��¼���û�id
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
		//��ֵ��PostBean
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
			info="�����ɹ�����ǰ���ҵķ����鿴��";
			forward="spacePostingSuccess.jsp";
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		info="ϵͳ�쳣������ʧ�ܣ�";
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
