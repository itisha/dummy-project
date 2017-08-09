<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/8/2017
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>JSP Built In objects Test</h3>

Request user agent: <%= request.getHeader("User-Agent")%>

<br/>
<br/>

Request language: <%= request.getLocale()%>

</body>
</html>
