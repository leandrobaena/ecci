<%@page contentType="text/html" pageEncoding="UTF-8" import="database.*, java.util.*" %>
<%
    Properties dbProperties = new Properties();
    dbProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/database.properties"));
    ConexionMySQL conn = new ConexionMySQL(dbProperties);
    //ArrayList lista;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
