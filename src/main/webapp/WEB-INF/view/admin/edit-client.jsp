<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit client</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>Редактирование клиента</h2>

<form:form method="PATCH" modelAttribute="client">
    Фамилия <form:input path="surname" field="${client.surname}"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Имя <form:input path="name" field="${client.name}"/>
    <form:errors path="name"/>
    <br>
    <br>
    Отчество <form:input path="middlename" field="${client.middlename}"/>
    <form:errors path="middlename"/>
    <br>
    <br>
    Возраст <form:input path="age" field="${client.age}"/>
    <form:errors path="age"/>
    <br>
    <br>
    Номер телефона <form:input path="phoneNumber" field="${client.phoneNumber}"/>
    <form:errors path="phoneNumber"/>
    <br>
    <br>
    Email <form:input path="email" field="${client.email}"/>
    <form:errors path="email"/>
    <br>
    <br>
    Логин <form:input path="username" field="${client.username}"/>
    <form:errors path="username"/>
    ${usernameError}
    <br>
    <br>
    Пароль <form:input path="password" field="${client.password}"/>
    <form:errors path="password"/>
    <br>
    <br>
    <input type="submit" value="Edit"/>

</form:form>


</body>

</html>