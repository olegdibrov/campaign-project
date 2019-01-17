<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
</head>
<body>

<style>
    .login {
        text-align: center;
    }

    form {
        margin: 0 auto;
        width: 300px
    }

    input {
        margin-bottom: 3px;
        padding: 10px;
        width: 100%;
        border: 1px solid #CCC;
    }

    button {
        padding: 0.35em 1.2em;
        background-color: wheat;
    }

    label {
        cursor: pointer
    }

    #form-switch {
        display: none
    }

    #register-form {
        display: none
    }

    #form-switch:checked ~ #register-form {
        display: block
    }

    #form-switch:checked ~ #login-form {
        display: none
    }

    button:hover {
        color: #000000;
        background-color: #FFFFFF;
    }

</style>

<%@include file="view/main.jsp" %>

<div class="login">
    <input type='checkbox' id='form-switch'>


    <h1><fmt:message key="index.hello"/></h1>
    <form id='login-form' method="post" action="Servlet">
        <fmt:message key="index.email"/><input type="email" placeholder="example@test.com" name="email" maxlength="40" required>
        <fmt:message key="index.password"/><input type="password" placeholder="Password (maximum 40 character)" name="password" maxlength="40" required>
        <button type='submit' name="command" value="login"><fmt:message key="index.login"/></button>
        <label for='form-switch'><span><fmt:message key="index.register"/></span></label>
        <p>${requestScope.notFound}</p>
    </form>
    <form id='register-form' method="post" action="Servlet">
        <fmt:message key="index.name"/><input type="text" placeholder="Name: (maximum 40 character)" name="name" maxlength="40" required pattern="(^[A-Z]{1}[a-z]+)|(^[А-Я]{1}[а-я]+)">
        <fmt:message key="index.surname"/><input type="text" placeholder="Surname: (maximum 40 character)" name="surname" maxlength="40" required pattern="(^[A-Z]{1}[a-z]+)|(^[А-Я]{1}[а-я]+)">
        <fmt:message key="index.email"/><input type="email" placeholder="example@test.com" name="email" maxlength="40" required>
        <fmt:message key="index.password"/><input type="password" placeholder="Password (maximum 40 character)" name="password" maxlength="40" required>
        <button type='submit' name="command" value="registration"><fmt:message key="index.register"/></button>
        <label for='form-switch'><fmt:message key="index.switch"/></label>
    </form>
</div>
</body>
</html>
