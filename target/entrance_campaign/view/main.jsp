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
    ul {
        text-align: center;
        padding: 30px;
        font-size: larger;
    }
    li {
        display: inline;
        margin: 20px;
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
<fmt:setLocale value="${requestScope.locale}"/>
<fmt:setBundle basename="text"/>
<ul>
    <li><a href="${pageContext.request.contextPath}/Servlet?locale=ru_RU&command=localization">ru</a></li>
    <li><a href="${pageContext.request.contextPath}/Servlet?locale=en&command=localization">en</a></li>
    <li><a href="${pageContext.request.contextPath}/Servlet?command=rating"><fmt:message key="main.rating"/></a></li>
    <li><a href="${pageContext.request.contextPath}/Servlet?command=cabinet"><fmt:message key="main.cabinet"/></a></li>
    <li><a href="${pageContext.request.contextPath}/Servlet?command=logout"><fmt:message key="main.logout"/></a></li>

</ul>
</body>
</html>
