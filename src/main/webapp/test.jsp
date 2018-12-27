<%--
  Created by IntelliJ IDEA.
  User: maild
  Date: 26.12.2018
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page isELIgnored="false" %>

<%
    ArrayList<String> numList = new ArrayList<String>();
    numList.add("1");
    numList.add("2");
    numList.add("3");
    request.setAttribute("numList", numList);
%>
<html>
<body>
<c:forEach items="${numList}" var="item">
    ${item}
</c:forEach>
</body>
</html>