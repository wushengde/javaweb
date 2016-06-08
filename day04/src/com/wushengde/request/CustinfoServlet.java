package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * request��ȡ����ͷ��Ϣ
 */
public class CustinfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ȡ�ͻ���������URL:getRequestURL()
		String url = request.getRequestURL().toString();
		System.out.println(url);
		// 2.��ȡ�ͻ����������Դ��Ϣ��getRequestURI()
		String uri = request.getRequestURI();
		System.out.println(uri);
		// 3.��ȡ�������в������֣�getQueryString()
		String qStr = request.getQueryString();
		System.out.println(qStr);
		// 4.��ȡ����ͻ��˵�ip��ַ��getRemoteAddr()
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		// 5.��ȡ�ͻ��˵�����ʽ��getMethod()
		String method = request.getMethod();
		System.out.println(method);
		// 6.��ȡ��ǰwebӦ�õ�����(ע���˴���Ӧ�����Ʒǹ�������)��getContextPath()
		String name = request.getContextPath();
		System.out.println(name);
		// ע������Ҫʹ��webӦ�����Ƶ�ʱ�򣬲���ʹ��������webӦ�����ƣ���Ҫʹ�����·�ʽ��
		// Ŀ����Ϊ�˷�ֹ���޸��˷�����web����ʱ��Ȼ����ʵ����ת��
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}