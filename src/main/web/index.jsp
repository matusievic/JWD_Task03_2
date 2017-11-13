<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main Page - Database Extractor</title>
</head>
<body>
<form action="/controller" method="GET">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname"></td>
        </tr>
    </table>
    <input type="submit" value="search">
</form>
<c:if test="${not empty incorrectDataMessage}">
    <c:out value="${incorrectDataMessage}"/>
</c:if>
</body>
</html>
