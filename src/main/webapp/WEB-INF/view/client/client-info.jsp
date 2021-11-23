<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client-info</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>${client.name} ${client.middlename}, добрый день!</h2>

<br>
<br>

<h3>Ваш баланс ${client.balance}</h3>
<br>
<br>

<input type="button" value="Пополнить счет"
       onclick="window.location.href = '/client/replenishment/'">
<br>
<br>
<input type="button" value="Перевод клиенту банка"
       onclick="window.location.href = '/client/transfer/'">
<br>
<br>
<input type="button" value="История операций"
       onclick="window.location.href = '/client/history/'">

<br>
<br>

<h3>Ваш персональный менеджер <a href="/client/manager/">${client.manager}</a></h3>

<br>
<br>
<br>
<br>
<input type="button" value="Log out"
       onclick="window.location.href = '/logout'">

</body>

</html>