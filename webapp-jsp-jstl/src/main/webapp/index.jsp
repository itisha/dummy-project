<%@ page import="java.io.File" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    List<String> fileNames = new LinkedList<>();
    for (int i = 0; i < files.length; i++) {
        if (files[i].isFile() && files[i].getName().length() != 0) {
            out.println(files[i].getName() + ": " + files[i].getCanonicalPath());
            out.println("<br/>");
            out.println(files[i].getName() + ": " + files[i].getAbsoluteFile());
            out.println("<br/>");
            fileNames.add(files[i].getName());
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