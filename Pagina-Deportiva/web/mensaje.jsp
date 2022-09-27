<%-- 
    Document   : mensaje
    Created on : 24/09/2022, 11:53:45 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <div class="${config}" role="alert">
                ${mensaje}!
            </div>
            <a href="Controlador?accion=listar">Go back</a>
        </div>
    </body>
</html>
