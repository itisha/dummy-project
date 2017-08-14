<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/14/2017
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/add-student-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>FooBar University</h2>
    </div>
</div>

<div id="container">
    <h3>Update Student</h3>


    <form action="StudentControllerServlet" method="get">

        <input type="hidden" name="command" value="UPDATE"/>

        <input type="hidden" name="studentId" value="${STUDENT.id}"/>

        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><input type="text" name="firstName" value="${STUDENT.firstName}"/></td>
            </tr>
            <tr>
                <td><label>Last Name:</label></td>
                <td><input type="text" name="lastName" value="${STUDENT.lastName}"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email" value="${STUDENT.email}"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" name="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form>

    <div style="clear: both"></div>

    <p>
        <a href="StudentControllerServlet/">Back to List</a>
    </p>

</body>
</html>
