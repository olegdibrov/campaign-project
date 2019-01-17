<%--
  Created by IntelliJ IDEA.
  User: maild
  Date: 25.12.2018
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    div {
        text-align: center;
    }
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
<div>
<h1>Successful Registration!</h1>
<form action="Servlet" method="post">
   <button name="command" value="speciality">Next</button>
</form>
</div>

</body>
</html>
