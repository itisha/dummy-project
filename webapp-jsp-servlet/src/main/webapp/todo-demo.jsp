<%--
  Created by IntelliJ IDEA.
  User: tkuprevich
  Date: 8/8/2017
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>TODO Demo</title>
</head>
<body>

<%-- step 1 create form --%>

<form action="todo-demo.jsp">
    Add new item: <input type="text" name="theItem"/>
    <br/><br/>
    <input type="submit" value="Submit">
</form>

<%-- step 2 add new item to list --%>

<%
    List<String> items = (List<String>) session.getAttribute("myToDoList");

    if (items == null) {
        items = new ArrayList<>();
        session.setAttribute("myToDoList", items);
    }

    String theItem = request.getParameter("theItem");
    if (theItem != null) {
        items.add(theItem);
    }
%>

<hr/>
<b>TODO List Items:</b><br/>
<ol>
    <%
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
    %>
</ol>

<%-- step 3 display items from settings --%>

</body>
</html>
