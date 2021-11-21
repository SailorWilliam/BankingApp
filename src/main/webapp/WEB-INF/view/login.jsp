<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<h2>Login</h2>
<br><br>

<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <br><br>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <br><br>
    <div><input type="submit" value="Sign In"/></div>
</form>

</body>
</html>