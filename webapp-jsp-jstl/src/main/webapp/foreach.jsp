<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/9/2017
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Foreach test</title>
</head>
<body>
<%
    String[] cities = {"Minsk", "Tallin", "Helsinki"};
    pageContext.setAttribute("myCities", cities);
%>
<c:forEach var="city" items="${myCities}">
    ${city} <br/>
</c:forEach>
</body>
</html>
