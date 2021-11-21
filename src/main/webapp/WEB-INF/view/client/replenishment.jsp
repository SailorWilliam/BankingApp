<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Replenishment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>Пополнение счета</h2>

<br>
<br>

На какую сумму пополнить счет?
<br>

<form action="/client/replenishment" method="post" >
    Сумма пополнения: <input name="sum"/>
    ${negativeSumError}
    <br><br>
    <input type="submit" value="Пополнить" />
</form>


</body>
</html>
