<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   from 3.jsp......  
   <%-- request.getRequestDispatcher("/index.jsp").include(request,response); --%>
   <%-- @include file="/index.jsp" --%>
   <!-- pageContext静态引入jsp页面的快捷方法，即：jsp页面包含的方法 -->
  <%--  <%pageContext.include("/2.jsp"); %>  --%>
   <!-- pageContext实现请求转发的快捷方法：注不能与页面包含同时使用 -->
   <%pageContext.forward("/index.jsp"); %>
  </body>
</html>