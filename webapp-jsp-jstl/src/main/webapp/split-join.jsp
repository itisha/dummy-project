<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/9/2017
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Split Join Functions</title>
</head>
<body>
<c:set var="data" value="Minsk,Tallin,Helsinki,Ahens,Warsaw"/>
<c:set var="cities" value="${fn:split(data, ',')}"/>
<c:forEach items="${cities}" var="city">
    ${city}<br/>
</c:forEach>
<c:set var="join" value="${fn:join(cities, '*')}"/>
Result of joining: ${join}
</body>
</html>
