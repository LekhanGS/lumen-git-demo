<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello <%= request.getParameter("name") %>
</h1>
<p>${param.get("country")}</p>
<div>
    <%
        List<String> cities = List.of("Bengaluru", "Mumbai", "Kolkata", "Delhi");
        cities.forEach(c -> {
            try {
                response.getWriter().println("<p>" + c + "</p>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    %>
</div>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>