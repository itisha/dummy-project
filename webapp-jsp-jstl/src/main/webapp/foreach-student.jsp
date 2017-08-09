<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.tisha.jsp.jstl.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/9/2017
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> students = new ArrayList<>();

    students.add(new Student("John", "Doe", false));
    students.add(new Student("Vasily", "Pupkin", false));
    students.add(new Student("Vladimir", "Putin", true));

    pageContext.setAttribute("students", students);
%>
<html>
<head>
    <title>Foreach Student Test</title>
</head>
<body>
<table border="1">
    <tr bgcolor="#5f9ea0">
        <th>Name:</th>
        <th>Last Name:</th>
        <th>Gold Status:</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr bgcolor="#a9a9a9">
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <c:if test="${student.goldCustomer}">
                <td bgcolor="#ffd700">${student.goldCustomer}</td>
            </c:if>
            <c:if test="${not student.goldCustomer}">
                <td bgcolor="#d3d3d3">${student.goldCustomer}</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
