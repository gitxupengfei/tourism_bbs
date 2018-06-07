package com.tourism_bbs.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class test {

	public static void main(String[] args)  {
		
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String time=df.format(day);
		System.out.println(time);   
		
	}
	
	
}
