<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/9/2017
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL Functions</title>
</head>
<body>

<c:set var="data" value="myValue4"/>

Length of the string <b>${data}</b> is: ${fn:length(data)}<br/>
Uppercase of the string <b>${data}</b> is: ${fn:toUpperCase(data)}<br/>
Does the string <b>${data}</b> starts with <b>my</b>? - ${fn:startsWith(data, "my")}<br/>

</body>
</html>
