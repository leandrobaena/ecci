<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE HTML>
<html manifest="">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=10, user-scalable=yes">
        <title>:: ECCI - M&oacute;dulo de administraci&oacute;n ::</title>
        <script id="microloader" data-app="131c39c5-3426-4e7f-b1a9-d7ef11eee6a5" type="text/javascript" src="bootstrap.js"></script>
    </head>
    <body></body>
</html>
