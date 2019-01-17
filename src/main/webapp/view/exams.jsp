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
        padding: 5px;
        margin: auto;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }
</style>
<div style="float: left">
    <p>${requestScope.markAction}</p>
    <h1>Unmarked exams</h1>
    <tr>
        <td>№</td>
        <td>id user</td>
        <td>Name</td>
        <td>Surname</td>
        <td>Mark</td>
    </tr>
    <c:forEach items="${examList}" var="exam" varStatus="loop">
        <form action="Servlet" method="post">
            <table>

                <tr>
                    <td><c:out value="${loop.index+1}"/></td>
                    <td><c:out value="${exam.id}"/></td>
                    <td><c:out value="${exam.userName}"/></td>
                    <td><c:out value="${exam.userSurname}"/></td>
                    <td><c:out value="${exam.subjectName}"/></td>
                    <td>
                        <div>
                            <label>
                                <input type="number" name="mark" id="mark" min="10" max="100" required>
                                <input type="hidden" name="idExam" value="${exam.id}">
                                <button name="command" value="add_Mark">+</button>
                            </label>
                        </div>
                    </td>
                </tr>

            </table>
        </form>
    </c:forEach>
</div>
<div style="float: right">
    <h1>All marked exams</h1>
    <c:forEach items="${allExams}" var="exams" varStatus="loop">
        <table>
                <c:if test="${exams.mark != 0}">
                    <tr>
                    <td><c:out value="${exams.id}"/></td>
                    <td><c:out value="${exams.userName}"/></td>
                    <td><c:out value="${exams.userSurname}"/></td>
                    <td><c:out value="${exams.subjectName}"/></td>
                    <td><c:out value="${exams.mark}"/></td>
                    </tr>
                </c:if>

        </table>
        </form>
    </c:forEach>

</div>

</body>
</html>
