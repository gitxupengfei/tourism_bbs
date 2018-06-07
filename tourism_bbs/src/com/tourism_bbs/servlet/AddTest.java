package com.tourism_bbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tourism_bbs.bean.UserBean;

import javafx.scene.control.Alert;


import java.io.File;  
import java.io.*;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
/**
 * Servlet implementation class AddUserServlet
 */

public class AddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//��request��ȡ�����Ե�ֵ
		//String userId=request.getParameter("userId");
		request.setCharacterEncoding("utf-8");
		
		//��ô����ļ���Ŀ����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //��ȡ�ļ���Ҫ�ϴ�����·��  
        String path = request.getRealPath("/userphoto");  
          
        //���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬  
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ  
        /** 
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�  
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��  
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ���� 
         */  
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
                    String value = item.getString() ;  
                      
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
                      
                    System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize());  
  
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
          
        request.setCharacterEncoding("utf-8");  
        String userName=(String) request.getAttribute("register_username");
		String password=(String) request.getAttribute("register_password");
		String question1=(String) request.getAttribute("question1");
		String answer1=(String) request.getAttribute("answer1");
		String question2=(String) request.getAttribute("question2");
		String answer2=(String) request.getAttribute("answer2");
		String  sex=(String) request.getAttribute("sex");
		String age=(String) request.getAttribute("age");
		String hometown=(String) request.getAttribute("hometown");
		String school=(String) request.getAttribute("school");
		String telephone=(String) request.getAttribute("phone");
		String QQ=(String) request.getAttribute("QQ");
		String introduce=(String) request.getAttribute("introduce");
		String photoPath=(String) request.getAttribute("photo");
		
		UserBean userBean=new UserBean();
		//���Ը�ֵ
		
		userBean.setUserName(userName);
		userBean.setPasswrd(password);
		userBean.setQuestion1(question1);
		userBean.setAnswer1(answer1);
		userBean.setQuestion2(question2);
		userBean.setAnswer2(answer2);
		userBean.setAge(age);
		userBean.setSex(sex);
		userBean.setHometown(hometown);
		userBean.setSchool(school);
		userBean.setTelephone(telephone);
		userBean.setQQ(QQ);
		userBean.setIntroduce(introduce);
		userBean.setPhotoPath(photoPath);
		//��ת��ҳ��
		String forward = null;
		//ҳ�����ʾ��Ϣ
		String info = null;
		
		try {
			
				userBean.addUser();
				forward="registerSucess.jsp";
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="ϵͳ�쳣��ע��ʧ�ܣ�";
			forward="register.jsp";
			
		}
		
		request.setAttribute("info", info);
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	} 
          
  
     
  
  

		
		
		
		
		
		
		
		
		
		/*String userName=request.getParameter("register_username");
		String password=request.getParameter("register_password");
		String question1=request.getParameter("question1");
		String answer1=request.getParameter("answer1");
		String question2=request.getParameter("question2");
		String answer2=request.getParameter("answer2");
		String  sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String hometown=request.getParameter("hometown");
		String school=request.getParameter("school");
		String telephone=request.getParameter("phone");
		String QQ=request.getParameter("QQ");
		String introduce=request.getParameter("introduce");
		String photoPath=request.getParameter("photoPath");
		String files=request.getParameter("photoUpload");
		System.out.println("�ļ�"+files);
		UserBean userBean=new UserBean();
		//���Ը�ֵ
		System.out.println(userName);
		userBean.setUserName(userName);
		userBean.setPasswrd(password);
		userBean.setQuestion1(question1);
		userBean.setAnswer1(answer1);
		userBean.setQuestion2(question2);
		userBean.setAnswer2(answer2);
		userBean.setAge(age);
		userBean.setSex(sex);
		userBean.setHometown(hometown);
		userBean.setSchool(school);
		userBean.setTelephone(telephone);
		userBean.setQQ(QQ);
		userBean.setIntroduce(introduce);
		userBean.setPhotoPath(photoPath);
		System.out.println("ͼƬ��"+photoPath);
		//��ת��ҳ��
		String forward = null;
		//ҳ�����ʾ��Ϣ
		String info = null;
		
		try {
			
				userBean.addUser();
				forward="registerSucess.jsp";
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="ϵͳ�쳣��ע��ʧ�ܣ�";
			forward="register.jsp";
			
		}
		
		request.setAttribute("info", info);
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
