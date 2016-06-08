package com.wushengde.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * Session��ʹ�ã���ʾһ�λỰ��session��һ����
 * ���÷�Χ����ǰ�Ự�ķ�Χ
 * �������ڣ��������һ�ε��õ�request.getSession()����ʱ��˵���ͻ�����ȷ
 * ����Ҫsession����1.������30���ӣ�����xml���޸ģ�δʹ��sessionʱ��session
 * ��ʱ���Զ����٣�2.��������ȷ������session.nvalidate()����ʱ��session����
 * 3.���������������ر�ʱsession�����٣�
 * session������:�ڻỰ��Χ�ڹ�������
 * session�Ķۻ�����
 * ����������������ر�,��δ��ʱ��session�ᱻ���ļ�����ʽ�����ڷ�������workĿ¼��,������̽���session�Ķۻ�.
 * �´�����������������ʱ,�ۻ��ŵ�session�ᱻ�ָ����ڴ���,������̽���session�Ļ.
 * session�ĳ�ʱ������鿴��ǰwebӦ���µ�web.xml�е�<session-config>��ǩ�е����ݡ�
 */
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("name", "zhangsanfeng");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}