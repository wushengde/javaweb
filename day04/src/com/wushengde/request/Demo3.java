package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("banana", "yellow banana");
		//����ת������requestЯ���ļ�ֵ�ԣ�ת����Demo4ҳ��ȥ��
		//this.getServletContext().getRequestDispatcher("/servlet/Demo4").forward(request, response);
		response.sendRedirect("/day04/servlet/Demo4");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}