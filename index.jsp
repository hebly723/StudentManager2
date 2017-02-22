<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/title.ico" media="screen" />
    <base href="<%=basePath%>">
<%
    //String color = request.getParameter("color");
    //if ("red".equals(color)) {
    //    response.sendRedirect("red.jsp");
    //} else if ("green".equals(color)) {
        response.sendRedirect("https://hebly723.github.io/");
    //}
%>
<title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is wzq's page. <br>
  </body>
</html>

