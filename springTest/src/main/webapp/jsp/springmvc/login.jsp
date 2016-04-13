<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring and Struts Integration Demo</title>
</head>
<body>
<div align="center">
    <h1>Spring mvc Demo</h1>
    <h2>Users Login</h2>
    <sf:form method="post" action="/login" modelAttribute="user">
        username:<sf:input path="username" id="user_name"></sf:input><br><br>
        password:<sf:password path="password" id="user_passwordk"></sf:password><br><br>
        <input type="submit" value="Submit"/>
    </sf:form>
</div>
</body>