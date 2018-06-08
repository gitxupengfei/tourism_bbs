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
 *@Description���޸ĸ�����Ϣ
 * @author��xupengfei
 *
 */

public class UpdatePersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setAttribute("photo", null);
		//��ô����ļ���Ŀ����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //��ȡ�ļ���Ҫ�ϴ�����·��  
        String path = request.getRealPath("/userphoto");  
          
       
        factory.setRepository(new File(path));  
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024*1024) ;  
          
        //��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory);  
          
          
        try {  
            //�����ϴ�����ļ�  
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
                //�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ  
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
                    request.setAttribute("photo", filename);  
                      
                    //����д��������  
                    //���׳����쳣 ��exception ��׽  
                      
                    //item.write( new File(path,filename) );//�������ṩ��  
                      
                    //�ֶ�д��  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                      
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������  
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
		//���Ը�ֵ
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
			System.out.println(result);
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
