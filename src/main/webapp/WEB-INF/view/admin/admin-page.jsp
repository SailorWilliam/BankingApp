<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>Админ, добрый день!</h2>

<br>
<br>

<input type="button" value="Список клиентов"
       onclick="window.location.href = '/admin/clients'">
<br><br>
<input type="button" value="Список менеджеров"
       onclick="window.location.href = '/admin/managers'">

<br><br>
<br><br>
<input type="button" value="Log out"
       onclick="window.location.href = '/logout'">

</body>

</html>