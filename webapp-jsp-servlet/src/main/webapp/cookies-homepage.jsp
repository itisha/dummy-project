<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/8/2017
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training Portal</title>
</head>
<body>
<h3>Training Portal</h3>

<%
    String favLang = "Java";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("myApp.favoriteLanguage".equals(cookie.getName())) {
                favLang = cookie.getValue();
                break;
            }
        }

    }
%>

<h4>New books for <%= favLang%>
</h4>
<ul>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
</ul>

<h4>Latest news reports for <%= favLang%>
</h4>
<ul>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
</ul>

<h4>Hot jobs for <%= favLang%>
</h4>
<ul>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
    <li>dah</li>
</ul>

<a href="cookies-personalize-form.html">Personalize this page</a>

</body>
</html>
