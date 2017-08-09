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

<br/>
<br/>

</body>
</html>