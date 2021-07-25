<%--
  Created by IntelliJ IDEA.
  User: welldev003
  Date: ২৪/৭/২১
  Time: ৭:০০ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Likhalikhi</title>
</head>
<body>
    <h1>Create a post!</h1>
    <form action="/posts" method="post">
        <p>
            <label for="title">Enter post title: </label>
            <input type="text" name="title" id="title"/>
        </p>
        <p>
            <label for="body">Enter post body: </label>
            <input type="text" name="body" id="body">
        </p>
        <input type="submit" value="Submit"/>
    </form>


</body>
</html>
