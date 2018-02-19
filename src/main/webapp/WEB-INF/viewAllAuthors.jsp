<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Karo
  Date: 16.02.2018
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Authors</title>
</head>
<body>
<a href="/home">Home</a><br>
<a href="/addAuthorView">Add Author</a><br>
<ul>
    <c:forEach items="${authors}" var="author">
        <img src="/authorImage?fileName=${author.picUrl}" width="100"/>
        <li>Name: ${author.name}<br> Age: ${author.age}<br> Gender: ${author.gender}</li>
        <br>
    </c:forEach></ul>
</body>
</html>
