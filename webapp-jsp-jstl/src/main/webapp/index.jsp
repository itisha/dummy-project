<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello JSTL world!</title>
</head>
<body>
<h2>Hello JSTL world!</h2>

<c:set var="stuff" value="<%= new java.util.Date() %>"/>
<c:set var="myVar" value="xxx"/>

<p align="canter">
    The time on <b>JSTL</b> the server is ${stuff}
    <br/>
    The myVar is ${myVar}
</p>

<%
    File directory = new File(request.getRealPath("."));
    File[] files = directory.listFiles();
    String[] fileNames = new String[files.length];
    for (int i = 0; i < files.length; i++) {
        if (files[i].isFile()) {
            fileNames[i] = files[i].getName();
        }
    }

    pageContext.setAttribute("fileNames", fileNames);
%>


<br/>
<c:forEach var="fileName" items="${fileNames}">
    <a href="${fileName}">${fileName}</a><br/>
</c:forEach>

<br/>
<br/>

</body>
</html>