<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<!-- 以下使用request.getRequestDispatcher().include(request,response)方式引入jsp页面表示动态引入过程：先翻译引入的jsp页面为servlet后再合并显示 -->
		<%--
			request.getRequestDispatcher("/include/head.jsp").include(request,response);
		--%>
		<!-- 以下使用jsp的include指令引入jsp页面的方式叫做静态引入指令：先合并引入的jsp页面再翻译成一个servlet页面 -->
		
		<%@include file="/include/head.jsp" %>
		from body......
		<%@include file="/include/foot.jsp" %>
		
		<%--
			request.getRequestDispatcher("/include/foot.jsp").include(request,response);
		--%>
		<!-- jsp中的jsp:include,jsp:forward 实现请求包含和请求转发
		这两个标签属于sun公司原生标签，jsp页面可以直接使用，其中还有一个标签
		jsp:param标签表示，在请求转发时，可以携带请求数据，即：设置键值对方式
		 -->
	</body>
</html>
