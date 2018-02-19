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
<a href="/add_book">Add Book</a><br>
<ul>
    <c:forEach items="${books}" var="book">
        <img src="/bookImage?fileName=${book.picUrl}" width="100"/>
        <li>Name: ${book.name}<br> Price: ${book.price}<br> Count: ${book.count} <br>Author ${book.author.name}</li>
        <br>
    </c:forEach></ul>
</body>
</html>
