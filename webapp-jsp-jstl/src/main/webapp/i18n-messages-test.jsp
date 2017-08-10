<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/10/2017
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="i18n.mylabels"/>
<html>
<head>
    <title><fmt:message key="label.welcome"/></title>
</head>
<body>
<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>
|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a>
|
<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>

<hr/>

<fmt:message key="label.greeting"/><br/><br/>

<fmt:message key="label.firstName"/>: <i>John</i><br/><br/>

<fmt:message key="label.lastName"/>: <i>Doe</i><br/><br/>

<fmt:message key="label.welcome"/>

<hr/>

Selected locale: ${theLocale}

</body>
</html>
