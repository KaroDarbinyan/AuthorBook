<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<a href="/home">Home</a><br>
<spring:form action="/addAuthor" modelAttribute="author" method="post" enctype="multipart/form-data">
    Name: <spring:input path="name" title="name"/><br>
    Age: <spring:input path="age" title="age"/><br>
    Gender: <form:select path="gender">
    <form:option value="0" label="Select Gender"/>
    <form:option value="MALE"/>
    <form:option value="FEMALE"/>
</form:select><br>
    File: <input type="file" name="picture"><br>
    <input type="submit" value="Save"/>
</spring:form>

</body>
</html>
