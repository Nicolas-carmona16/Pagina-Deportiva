<%-- 
    Document   : add
    Created on : 24/09/2022, 11:46:18 PM
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
            <form action="Controlador" method="POST">
                <div class="card border-info mb-3" style="max-width: 100rem;">
                    <div class="card-header">ADD ATHLETE</div>
                    <div class="card-body text-info">
                        <div class="form-group">
                            <label>Names</label>
                            <input type="text" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Last names</label>
                            <input type="text" name="txtApellidos" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Club/Distance</label>
                            <input type="text" name="txtClub" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nacional team/Time</label>
                            <input type="text" name="txtSeleccion" class="form-control">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Agregar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ml-2">Go back</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>