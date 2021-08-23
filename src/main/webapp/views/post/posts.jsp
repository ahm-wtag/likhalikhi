<%--
  Created by IntelliJ IDEA.
  User: welldev003
  Date: ২৩/৮/২১
  Time: ২:৫২ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Likhalikhi</title>
</head>
<body>
    <h1 style="text-align: center">All the posts</h1>
    <c:if test="${not empty name}"><h1>${name}</h1></c:if>
    <table style="width: 100%; text-align:center;">
        <tr>
            <th>Post id</th>
            <th>Post title</th>
            <th>Post body</th>
        </tr>
    <c:forEach items="${postList}" var="post">
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.body}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
