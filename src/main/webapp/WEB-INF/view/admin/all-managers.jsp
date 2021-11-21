<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All managers</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<h2>Список менеджеров:</h2>
<br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Middlename</th>
        <th>Email</th>
        <th>Phone number</th>
        <th>Username</th>
        <th>Password</th>
    </tr>

    <c:forEach var="manager" items="${allManagers}">

<%--        <c:url var="updateButton" value="/updateInfo">--%>
<%--            <c:param name="clientId" value="${client.id}"/>--%>
<%--        </c:url>--%>

<%--        <c:url var="deleteButton" value="/deleteEmployee">--%>
<%--            <c:param name="clientId" value="${client.id}"/>--%>
<%--        </c:url>--%>

        <tr>
            <td>${manager.id}</td>
            <td>${manager.surname}</td>
            <td>${manager.name}</td>
            <td>${manager.middlename}</td>
            <td>${manager.email}</td>
            <td>${manager.phoneNumber}</td>
            <td>${manager.username}</td>
            <td>${manager.password}</td>
<%--            <td>--%>
<%--                <input type="button" value="Update"--%>
<%--                    onclick="window.location.href = '${updateButton}'"/>--%>

<%--                <input type="button" value="Delete"--%>
<%--                       onclick="window.location.href = '${deleteButton}'"/>--%>
<%--            </td>--%>
        </tr>

    </c:forEach>
</table>

</body>
</html>
