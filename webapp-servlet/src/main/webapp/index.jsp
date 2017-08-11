<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="org.tisha.servlet.org.tisha.utils.RequestUtils" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    File directory = new File(request.getRealPath("."));
    File[] files = directory.listFiles();
    List<String> fileNames = new LinkedList<>();
    for (int i = 0; i < files.length; i++) {
        if (files[i].isFile() && files[i].getName().length() != 0) {

            fileNames.add(files[i].getName());
        }
    }
    pageContext.setAttribute("fileNames", fileNames);

    Collection<String> requestMappings = RequestUtils.getRequestMappings(request);
    pageContext.setAttribute("requestMappings", requestMappings);
%>


<br/>
<c:forEach var="fileName" items="${fileNames}">
    <a href="${fileName}">${fileName}</a><br/>
</c:forEach>
<hr/>
<c:forEach var="mapping" items="${requestMappings}">
    <a href="${pageContext.request.contextPath.concat(mapping)}">${mapping}</a><br/>
</c:forEach>


</body>
</html>