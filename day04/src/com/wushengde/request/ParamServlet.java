package com.wushengde.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String username = request.getParameter("username");
		 * System.out.println(username); response.getWriter().write(username);
		 */
		//֪ͨ��������ʲô�������http������ʵ������ݣ���ֻ�ܽ��post�ύ�����󣬲��ܽ��get�ύ�������е��������⣡
		//����get����ֻ��ʹ���ֶ�������룡
		request.setCharacterEncoding("utf-8");
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {

			String name = enumeration.nextElement();
			String value = request.getParameter(name);
			//�˴��ֶ�������������⣺�˷���Ҳ�ʺ�post������ύ��ʽ��
			value = new String(value.getBytes("iso-8859-1"),"utf-8");
			System.out.println(name + ":" + value + " ");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}