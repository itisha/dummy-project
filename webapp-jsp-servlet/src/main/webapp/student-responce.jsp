<html>

<head><title>Student Confirmation Title</title></head>

<body>

The student is confirmed: ${param.firstName} ${param.lastName}

<br/><br/>
Country: ${param.country}

<br/><br/>
Programming Langiage: ${param.progLanguage}

<br/><br/>
Spoken Languages:
<ul>
    <%
        String[] langs = request.getParameterValues("speakLanguage");

        if (langs != null) {
            for (String lang : langs) {
                out.println("<li>" + lang + "</li>");
            }
        }
    %>
</ul>

</body>
</html>
