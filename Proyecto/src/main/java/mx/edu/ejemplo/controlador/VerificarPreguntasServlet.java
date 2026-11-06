package mx.edu.ejemplo.controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.ejemplo.modelo.Seguridad;
import mx.edu.ejemplo.modelo.Usuario;

@WebServlet("/VerificarPreguntasServlet")
public class VerificarPreguntasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioTemp") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioTemp");
        String resp1 = request.getParameter("respuesta1");
        String resp2 = request.getParameter("respuesta2");

        boolean ok1 = Seguridad.compararRespuestas(usuario.getRespuesta1(), resp1);
        boolean ok2 = Seguridad.compararRespuestas(usuario.getRespuesta2(), resp2);

        if (ok1 && ok2) {
            session.setAttribute("usuarioAutenticado", usuario);
            session.removeAttribute("usuarioTemp");
            session.removeAttribute("paso1Completado");
            response.sendRedirect("ExitoServlet");
        } else {
            request.setAttribute("error", "Una o ambas respuestas son incorrectas");
            request.setAttribute("pregunta1", usuario.getPregunta1());
            request.setAttribute("pregunta2", usuario.getPregunta2());
            request.getRequestDispatcher("/WEB-INF/vista/preguntas.jsp").forward(request, response);
        }
    }
}