package com.wushengde.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//requestʵ������ת����request.getRequestDispatcher("����·��").forward(request,response);
public class Demo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// requestʵ������ת������this.getServletContext.getRequestDispatecher("/servlet/Demo6").forward(request,response);һ���Ĺ��ܡ�
		response.setContentType("text/html;charset=utf-8");
		// response.getOutputStream().write("��ð�".getBytes("utf-8"));
		response.getWriter().write("from Demo5");
		// �˾���뽫������ݴ�ӡ�������������һ���������Ӧ��ע���������һ������ֻ�ܶ�Ӧ��������һ����Ӧ��
		// ���û��������䣬��ʵ������ת����response�еĻ������ݽ�����ա�
		// response.getWriter().flush();
		// �˾���뽫�����쳣��
		request.getRequestDispatcher("/servlet/Demo6").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}