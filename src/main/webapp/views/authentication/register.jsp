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
    <form action="${pageContext.request.contextPath}/customer" method="post">
        <p>
            <label for="handle">Enter your handle: </label>
            <input name="handle" id="handle" type="text"/>
        </p>
        <p>
            <label for="email">Enter your email: </label>
            <input name="email" id="email" type="text"/>
        </p>
        <p>
            <label for="password">Enter your password: </label>
            <input name="password" id="password" type="password"/>
        </p>
        <p>
            <label for="firstName">Enter your first name: </label>
            <input name="firstName" id="firstName" type="text"/>
        </p>
        <p>
            <label for="lastName">Enter your last name: </label>
            <input name="lastName" id="lastName" type="text"/>
        </p>
        <p>
            <input type="submit" value="Register">
        </p>
    </form>
    <a href="/login">Already have an account?</a>
</body>
</html>
