<%@ page import="org.tisha.jsp.FunUtils" %>
<html>
<head>
    <title>Hello world!</title>
</head>
<body>
<h2>Hello World!</h2>

The time on the server is <%= new java.util.Date() %>

<br/>
<br/>

Converting String to Uppercase: <%= "Hello World".toUpperCase() %>

<br/>
<br/>

<%-- scriptlet --%>
<%
    for (int i = 0; i < 5; i++) {
        out.println("<br/> i=" + i);
    }
%>

<%-- declaration of a method --%>
<%!
    public String hello(String data) {
        return data.toLowerCase();
    }
%>


<br/>
<br/>

Call of the hello() method: <%= hello("bla lba") %>


<br/>
<br/>

<%-- call methos from actual class: --%>
Call of method from FunUtils: <%= FunUtils.makeItLower("FUN FUN FUN") %>


</body>
</html>