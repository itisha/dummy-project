<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/11/2017
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h3>Students List:</h3>
<c:forEach var="student" items="${students}">
    ${student}<br/>
</c:forEach>
</body>
</html>
