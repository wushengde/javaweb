package com.wushengde.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * �漰�����������������⣺get�����е�������������
 * 
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ǵ��ĸ�ҳ����ת�����ģ�����ȡ���������prod��ֵ���жϣ�
		String prod = request.getParameter("prod");
		//������������е����ĵ�����(�˴���get�ύ��ʽ����ʹ��request.setCharacterEncoding("utf-8")����Ч����ֻ��post��ʽ��Ч)
		//���·�ʽ�����get��������е��������⣺
		prod = new String(prod.getBytes("iso-8859-1"),"utf-8");
		
		//����һ��session����,ÿһ��session�ڴ���ʱ���ᴴ��һ��idΪJSESSIONID��Cookie���������Cookie������������Ĺرն���ʧ
		//session�Ĺ���ԭ��������cookie�������ģ����������session������idΪjsession��cookie���ã��ˣ�������ٴη���ʱ��Я�����cookie
		//�����������ҵ���Ӧ��session��Ȼ����ܻ�ȡ���б�������ݣ�����session�Լ����������cookieû������MaxAge��������ر�ʱ�������ᱣ�����cookie
		//�����Ҫ�ֶ�����һ�������cookie��ȫ��ͬ��cookie��Ȼ������������MaxAge���������ð�Сʱ��session����������ͬ����������cookie��
		HttpSession session = request.getSession();
		//������session�����ɵ���ͬ��cookie��Ȼ��������MaxAge��������ر��������ʧidΪjsession��cookie
		Cookie jc = new Cookie("JSESSIONID",session.getId());
		jc.setPath(request.getContextPath());
		jc.setMaxAge(1800);
		response.addCookie(jc);
		session.setAttribute("prod", prod); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}