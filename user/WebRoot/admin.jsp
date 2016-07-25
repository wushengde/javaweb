<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.wushengde.com/UserTag" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员页面</title>
  <style>
  td{
  text-align:center;
  }
  </style>
  </head>
  <body>
    <h1 style="text-align:center;">管理员页面</h1>
    <p style="text-align:left;">欢迎，${sessionScope.admin.username }! <a href="${pageContext.request.contextPath }/servlet/AdminLogoutServlet">注销</a></p>
 			<form
			action="${pageContext.request.contextPath }/servlet/AddMsgServlet"
			method="POST">
			
			文章标题：<input type="text" name="title"/><br><br>
			文章内容：<textarea name="context" style="height:200px;width:80%;"></textarea><br><br>
			
			发布时间：<input type="text" name="time" /><br>
			<p style="color:red">注：时间格式：XXXX-XX-XX</p>
			<input type="submit" value="添加文章" />
			</form>
			<hr>
	<table border="1">
	 <tr>
	 <td>序号</td>
	 <td>标题</td>
	 <td>文章内容</td>
	 <td>发布日期</td>
	 <td>编辑</td>
	 <td>删除</td>
	 </tr>
	 <%int i=1; %>
	<c:forEach items="${sessionScope.adminmsg}" var="message">
	<tr>
	<td style="width:5%;"><%=i %><%i++; %></td>
	<td style="width:10%;">${message.title}</td>
	<td style="width:70%;">${message.context }</td>
	<td style="width:5%;">${message.time}</td>
	<td style="width:5%;"><a href="${pageContext.request.contextPath}/servlet/EditServlet?id=${message.id }">编辑</a></td>	
	<td style="width:5%;"><a href="${pageContext.request.contextPath }/servlet/DeleteServlet?id=${message.id }">删除</a></td>
	</tr>
	</c:forEach>
    </table> 
  </body>
</html>
