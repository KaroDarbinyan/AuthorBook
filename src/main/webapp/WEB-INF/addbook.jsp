<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<a href="/home">Home</a><br>
<spring:form action="/addbook" modelAttribute="book" method="post" enctype="multipart/form-data">
    Name: <spring:input path="name" title="name"/><br>
    Price: <spring:input path="price" title="price"/><br>
    Count: <spring:input path="count" title="count"/><br>
    Author: <form:select path="author">
    <form:option value="0" label="Select Author"/>
    <c:forEach items="${authors}" var="author">
        <form:option value="${author.id}">${author.name}, ${author.age}</form:option>
    </c:forEach>
</form:select><br>
    File: <input type="file" name="picture"><br>
    <input type="submit" value="Save"/>
</spring:form>

</body>
</html>
