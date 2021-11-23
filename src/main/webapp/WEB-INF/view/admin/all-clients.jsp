<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All clients</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<h2>Список клиентов:</h2>
<br>

<table class="table table-striped table-hover" border="1">
    <tr>
        <th>ID</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Middlename</th>
        <th>Age</th>
        <th>Card number</th>
        <th>Pin</th>
        <th>Balance</th>
        <th>Email</th>
        <th>Phone number</th>
        <th>Username</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="client" items="${allClients}">

        <tr>
            <td>${client.id}</td>
            <td>${client.surname}</td>
            <td>${client.name}</td>
            <td>${client.middlename}</td>
            <td>${client.age}</td>
            <td>${client.cardNumber}</td>
            <td>${client.pin}</td>
            <td>${client.balance}</td>
            <td>${client.email}</td>
            <td>${client.phoneNumber}</td>
            <td>${client.username}</td>
            <td>${client.password}</td>
            <td>
                <input type="submit" value="Edit"
                       onclick="window.location.href = '/admin/clients/${client.id}'"/>
            </td>
            <td>
                <form:form action = "/admin/clients/${client.id}" method="delete">
                    <input type="submit" value="Delete"/>
                </form:form>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
