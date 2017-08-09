<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/8/2017
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<%
    String favLang = request.getParameter("favoriteLanguage");
    Cookie cookie = new Cookie("myApp.favoriteLanguage", favLang);
    cookie.setMaxAge(60 * 60 * 24);

    response.addCookie(cookie);
%>

Thanks, we set you favorite language to: ${param.favoriteLanguage}
<a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>
