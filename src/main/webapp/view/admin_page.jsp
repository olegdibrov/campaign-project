<%--
  Created by IntelliJ IDEA.
  User: maild
  Date: 28.12.2018
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="main.jsp" %>
<style>
    form {
        text-align: center;
    }
    button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
    }
</style>
<form action="Servlet" method="post">

    <button name="command" value="exams">Mark exams</button>
    <button name="command" value="rating">Show rating</button>


</form>
</body>
</html>
