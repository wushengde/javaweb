package com.wushengde.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NOCacheServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setIntHeader("expires", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("pragma", "no-cache");
		response.setHeader("refresh", "1");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("当前时间是："+new Date().toLocaleString());
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
