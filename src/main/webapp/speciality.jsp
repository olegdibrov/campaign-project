<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.entity.Speciality" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Servlet" method="post">
<table >
      <c:forEach items="${specialityList}" var="speciality" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index+1}"/></td>
            <td><c:out value="${speciality.specialityName}"/></td>
            <td>
                <div class="radio">
                    <label>
                        <input class="radiobtn" type="radio" name="chosenSpeciality"
                               value="${speciality.idSpeciality}">
                    </label>
                </div>
            </td>
        </tr>
    </c:forEach>
    <button name="command" value="university">Choose university</button>
</table>
</form>

</body>
</html>
