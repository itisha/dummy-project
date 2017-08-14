<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/14/2017
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div style="width: 50%">
    <div id="wrapper">
        <div id="header">
            <h2>FooBar University</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First name:</th>
                    <th>Last Name:</th>
                    <th>Email:</th>
                </tr>

                <c:forEach var="student" items="${STUDENTS}">
                    <tr>
                        <td>${student.getFirstName()}</td>
                        <td>${student.getLastName()}</td>
                        <td>${student.getEmail()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
