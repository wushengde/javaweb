package com.wushengde;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.service.Service;

/**
 * 
 * ServletContext��ȡ�ļ�
 *
 */
public class Demo04Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	Properties prop = new Properties();
		prop.load(new FileReader(this.getServletContext().getRealPath("config.properties")));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));*/
		
	
		Service service = new Service();
		service.method();

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}