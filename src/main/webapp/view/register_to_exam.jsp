<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    form {
        text-align: center;
    }

    div {
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
<h2>Your exam will be: </h2>
<ul>
    <c:forEach items="${subjects}" var="subjects" varStatus="loop">
        <li><c:out value="${subjects.subjectName}"/></li>
    </c:forEach>
</ul>
<form action="Servlet" method="post">
    <button name="command" value="index">Go Home</button>
</form>
</div>
</body>
</html>
