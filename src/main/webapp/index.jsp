<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
<script>document.documentElement.style.background = '#ccc'</script>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>_________</h3><br>
<strong>Current Time is</strong>: <%=new Date() %>
<br>
<h4>spring_basic</h4><br>
<br>
    <form action="add">
        1st :<input type="text" name="num1" /> </br>
        1st :<input type="text" name="num2" /> </br>
        <input type="submit" />
    <form>
<br>
</body>
</html>