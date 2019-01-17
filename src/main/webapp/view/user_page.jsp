<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
    div {
        text-align: center;
    }
    table {
        margin: auto;
    }
</style>
<div>
<h1>Hello <c:out value="${user.name}"></c:out>  <c:out value="${user.surname}"></c:out></h1>
    <p>Your email: <c:out value="${user.email}"></c:out></p>
    <p>Chosen department:  ${rating.department}</p>
    <p>Your exams: </p>
        <form action="Servlet" method="post">
            <button name="command" value="show_exams">Show exams</button>
            <table>
                <c:forEach items="${userExams}" var="exam" varStatus="loop">
                <tr>
                    <td><c:out value="${loop.index+1}"/></td>
                    <td><c:out value="${exam.subjectName}"/></td>
                    <td><c:out value="${exam.mark}"/></td>
                </tr>
                </c:forEach>
            </table>
        </form>

    <h3>Status: ${rating.status}</h3>

</div>

</body>
</html>
