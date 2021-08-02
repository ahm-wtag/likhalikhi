<%--
  Created by IntelliJ IDEA.
  User: welldev003
  Date: ১/৮/২১
  Time: ১০:৩১ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Likhalikhi</title>
</head>
<body>
    <form action="/session" method="post">
        <p>
            <label for="handle">Enter your handle: </label>
            <input name="handle" id="handle" type="text"/>
        </p>
        <p>
            <label for="password">Enter your password</label>
            <input name="password" id="password" type="password"/>
            <input type="submit" value="Login">
        </p>
    </form>
    <a href="/register">Click here to register.</a>
</body>
</html>
