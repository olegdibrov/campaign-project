<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rating</title>
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
    table {
        margin: auto;
    }
</style>

<p>${requestScope.ratingAction}</p>
<form action="Servlet" method="post">
    <select name="departmentName">
        <c:forEach items="${departments}" var="department">
            <option value="${department.departmentName}" ${department.departmentName == selectedModule ? 'selected':''}>${department.departmentName}</option>
        </c:forEach>
    </select>
    <br>
    <button name="command" value="rating" onclick="chooseDepartmentBtn();">Choose department</button>
    <br>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <button id="send" name="command" value="send_notification" >Send Notifications</button>
        <p>${requestScope.messages}</p>
    </c:if>
</form>
<table>
    <c:forEach items="${ratings}" var="ratings">
        <c:if test="${ratings.rating != 0}">
            <tr>
                <td><c:out value="${ratings.idRating}"/></td>
                <td><c:out value="${ratings.userName}"/></td>
                <td><c:out value="${ratings.userSurname}"/></td>
                <td><c:out value="${ratings.department}"/></td>
                <td><c:out value="${ratings.rating}"/></td>
            </tr>
        </c:if>
    </c:forEach>

</table>

<script type = "text/javascript" language = "javascript">
    function chooseDepartmentBtn(){
        document.getElementById("send").disabled=false;

    }

    function sendStatusBtn(){
        document.getElementById("send").disabled=true;
    }
</script>
</body>
</html>
