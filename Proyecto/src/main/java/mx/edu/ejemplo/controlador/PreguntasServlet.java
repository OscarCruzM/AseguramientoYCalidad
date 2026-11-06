package mx.edu.ejemplo.controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.ejemplo.modelo.Usuario;

@WebServlet("/PreguntasServlet")
public class PreguntasServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("paso1Completado"))) {
            Usuario usuario = (Usuario) session.getAttribute("usuarioTemp");
            request.setAttribute("pregunta1", usuario.getPregunta1());
            request.setAttribute("pregunta2", usuario.getPregunta2());
            request.getRequestDispatcher("/WEB-INF/vista/preguntas.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}