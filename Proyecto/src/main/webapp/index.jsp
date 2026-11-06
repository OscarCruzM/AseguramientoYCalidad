<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <div class="card">
        <h2>Bienvenido</h2>
        <p class="subtitle">Paso 1: Autenticación de usuario</p>

        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) { 
        %>
            <div class="alert-error"><%= error %></div>
        <% } %>

        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" placeholder="Ingresa tu usuario" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required>
            </div>
            <button type="submit" id="btnIngresar" class="btn">Continuar</button>
        </form>
    </div>
</body>
</html>