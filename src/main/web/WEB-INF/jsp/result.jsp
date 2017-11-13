<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result - Database Extractor</title>
</head>
<body>
<c:if test="${not empty persons}">
    <table>
        <tr>
            <td>Name</td>
            <td>Surname</td>
            <td>Phone</td>
            <td>email</td>
        </tr>
        <c:forEach items="${persons}" var="p">
            <tr>
                <td><c:out value="${p.name}"/></td>
                <td><c:out value="${p.surname}"/></td>
                <td><c:out value="${p.phone}"/></td>
                <td><c:out value="${p.email}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="Index">Go back</a>
</body>
</html>
