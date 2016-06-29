package com.wushengde.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.dao.MysqlUserDao2;
import com.wushengde.dao.UserDao;
import com.wushengde.domain.Admin;
import com.wushengde.domain.User;
import com.wushengde.service.UserService;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.������������
		response.setContentType("text/html;charset=utf-8");
		//2.����POST�ύ������
		request.setCharacterEncoding("utf-8");
		//3.��ȡ�ͻ����ṩ���û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//4.����service��������û�������
		UserService service = new UserService();
		Admin admin = service.isAdmin(username, password);
		//5.�������ȷ����ʾ
		if(admin==null){
			request.setAttribute("msg", "�û������벻��ȷ��");
			request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
			return;
		//6.�����ȷ���¼�û����ض�����ҳ
		}else{
			List list = new ArrayList();
			list=service.findMessage(); 
			//7.����û���ѡ�˼�ס�û���������cookie������������û���
			 request.getSession().setAttribute("adminmsg", list);
			 request.getSession().setAttribute("admin", admin);
			if("ok".equals(request.getParameter("rename"))){
				Cookie reNameC = new Cookie("rename",URLEncoder.encode(admin.getUsername(),"utf-8") );
				reNameC.setMaxAge(3600*24*30);
				reNameC.setPath(request.getContextPath());
				response.addCookie(reNameC);
			}else{
			//8.����û�û�й�ѡ��ס�û�������ɾ����ʷ��cookie��ɾ����ʽ������ͬ��ͬpath��������MaxAgeΪ0��cookie�������
				Cookie reNameC = new Cookie("rename","");
				reNameC.setPath(request.getContextPath());
				reNameC.setMaxAge(0);
				response.addCookie(reNameC);
			}
			response.sendRedirect(request.getContextPath()+"/admin.jsp");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}