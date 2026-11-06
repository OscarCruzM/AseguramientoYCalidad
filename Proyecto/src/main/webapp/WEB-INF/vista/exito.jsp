<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mx.edu.ejemplo.modelo.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Acceso Concedido</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="card">
        <% 
            Usuario user = (Usuario) session.getAttribute("usuarioAutenticado"); 
        %>
        <h2>¡Autenticación Exitosa!</h2>
        <p class="subtitle">Bienvenido al sistema, <strong><%= user != null ? user.getUsuario() : "" %></strong>.</p>
        
        <p style="color: #4a5568; font-size: 0.9rem; margin-bottom: 20px;">
            Has completado correctamente ambos factores de verificación.
        </p>

        <a href="LogoutServlet" class="btn btn-logout">Cerrar Sesión</a>
    </div>
</body>
</html>