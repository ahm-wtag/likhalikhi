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
    <div style="width: 70%;">
    <h1>Hello There!</h1>
    <c:if test="${not empty name}"><h1>${name}</h1></c:if>
    <table>
        <tr>
            <th>Post title</th>
            <th>Post body</th>
        </tr>
    <c:forEach items="${posts}" var="post">
        <tr style="padding-top: 20px">
            <td>${post.title}</td>
            <td style="padding-left: 20px">${post.body}</td>
        </tr>
    </c:forEach>
    </table>
    <a href="/posts/new">Create new Post</a>
    </div>
</body>
</html>
