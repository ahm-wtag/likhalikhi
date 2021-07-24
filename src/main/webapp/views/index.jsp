<%--
  Created by IntelliJ IDEA.
  User: welldev003
  Date: ২৪/৭/২১
  Time: ৪:১৩ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Likhalikhi</title>
</head>
<body>
    <h1>Hello There!</h1>
    <c:forEach items="${posts}" var="post">
        <h2>${post}<h2>
    </c:forEach>
</body>
</html>
