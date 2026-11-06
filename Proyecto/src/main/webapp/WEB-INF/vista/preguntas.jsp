<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Preguntas de Seguridad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="card">
        <h2>Verificación de Seguridad</h2>
        <p class="subtitle">Paso 2: Responde tus preguntas guardadas</p>

        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) { 
        %>
            <div class="alert-error"><%= error %></div>
        <% } %>

        <form action="VerificarPreguntasServlet" method="post">
            <div class="form-group">
                <label><%= request.getAttribute("pregunta1") %></label>
                <input type="text" id="respuesta1" name="respuesta1" placeholder="Tu respuesta" required>
            </div>
            <div class="form-group">
                <label><%= request.getAttribute("pregunta2") %></label>
                <input type="text" id="respuesta2" name="respuesta2" placeholder="Tu respuesta" required>
            </div>
            <button type="submit" id="btnVerificar" class="btn">Validar y Acceder</button>
        </form>
    </div>
</body>
</html>