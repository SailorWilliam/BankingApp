<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><!DOCTYPE html>
<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>Введите данные для регистрации</h2>

<form:form method="POST" modelAttribute="clientForm">
    Фамилия <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Имя <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Отчество <form:input path="middlename"/>
    <form:errors path="middlename"/>
    <br>
    <br>
    Возраст <form:input path="age"/>
    <form:errors path="age"/>
    <br>
    <br>
    Номер телефона <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br>
    <br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br>
    <br>
    Логин <form:input path="username"/>
    <form:errors path="username"></form:errors>
    ${usernameError}
    <br>
    <br>
    Пароль <form:input path="password"/>
    <form:errors path="password"/>
    <br>
    <br>
    <input type="submit" value="OK"/>

</form:form>


<br><br>

</body>
</html>
