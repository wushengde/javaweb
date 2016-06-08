package com.wushengde.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.domain.Book;

public class BookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.��ȡҪ�������id����ѯ���ݿ��ҳ������ϸ��Ϣ��

		String id = request.getParameter("id");
		Book book = BookDao.getBook(id);
		if (book == null) {
			response.getWriter().write("�Ҳ����Ȿ��");
			return;
		} else {
			response.getWriter().write("<h1>������" + book.getName() + "</h1>");
			response.getWriter().write(
					"<h3>�۸�" + book.getPrice() + "Ԫ" + "</h3>");
			response.getWriter().write("<h3>���ߣ�" + book.getAuthor() + "</h3>");
			response.getWriter()
					.write("<h3>�����磺" + book.getPublish() + "</h3>");
			response.getWriter().write(
					"<h3>������" + book.getDescrption() + "</h3>");
		}

		// 2.����cookie���濴������:
		String ids = "";
		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if (cs != null) {
			for (Cookie c : cs) {
				if ("last".equals(c.getName())) {
					findC = c;
				}
			}
		}
		if (findC == null) {
			ids += book.getId();
		} else {
			String[] olds = findC.getValue().split(",");
			StringBuffer buffer = new StringBuffer();
			buffer.append(book.getId() + ",");
			for (int i = 0; i < olds.length
					&& buffer.toString().split(",").length < 3; i++) {
				String old = olds[i];
				if (!old.equals(book.getId())) {
					buffer.append(old + ",");
				}
			}
			ids = buffer.substring(0, buffer.length() - 1);
		}
		// �˾��Ǵ���һ��Cookie�Ķ��󣺲��Ҵ˶���û���޲ι��캯����Ҫֱ��������name�Լ���value
		Cookie lastC = new Cookie("last", ids);
		// �˾�����Cookie������������б����ʱ�䣺������Ϊ��λ�����±�ʾ�洢һ���£�
		lastC.setMaxAge(3600 * 24 * 30);
		// �˾�����Cookie���󶼴��뵽�ĸ�·���µ�����servletҳ��
		lastC.setPath(request.getContextPath());
		// �˾��ʾ�����Cookie���͸������ʹ�䱣���Cookie
		response.addCookie(lastC);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}