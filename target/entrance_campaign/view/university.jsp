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
<form action="Servlet" method="post">
<table>
    <c:forEach items="${universityList}" var="university" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index+1}"/></td>
            <td><c:out value="${university.universityName}"/></td>
            <td>
                <div class="radio">
                    <label>
                        <input class="radiobtn" type="radio" name="chosenUniversity"
                               value="${university.idUniversity}" checked>
                    </label>
                </div>
            </td>
        </tr>
    </c:forEach>
    <button name="command" value="department">Choose university</button>
</table>
</form>
</body>
</html>
