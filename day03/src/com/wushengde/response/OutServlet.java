package com.wushengde.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ����������ϰ
 */
public class OutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������й������֣�������������������뼰���������ı������ͣ�
		
		//�˾����������������ԡ�utf-8������ʽ����
		// response.setHeader("Content-Type", "text/html; charset=utf-8");
		
		//�˾�����Ƿ������Ͻ����й��������ԡ�utf-8������ʽ����Ϊ�����ƴ���
		// response.getOutputStream().write("�й�".getBytes("utf-8"));
		
		//�˾�����Ƿ������Ͻ����������������ԡ�gbk������ʽ�������Ϊ�����ƴ���
		// response.setCharacterEncoding("gbk");

		// ���д��뽫������з�����������������⣬ͳһ�涨�˷��������������������ͣ�utf-8;
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write("����");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}