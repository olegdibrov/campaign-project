<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
                               value="${university.idUniversity}">
                    </label>
                </div>
            </td>
        </tr>
    </c:forEach>
    <button name="command" value="university">Choose department</button>
</table>
</form>
</body>
</html>
