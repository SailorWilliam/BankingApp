<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>History</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<h2>Ваши операции</h2>
<br>

<table border="1">
    <tr>
        <th>Дата операции</th>
        <th>Тип операции</th>
        <th>Сумма операции</th>
    </tr>

    <c:forEach var="operation" items="${allOperations}">

        <tr>
            <td>${operation.time}</td>
            <td>${operation.type}</td>
            <td>${operation.sum}</td>

        </tr>

    </c:forEach>
</table>

</body>
</html>
