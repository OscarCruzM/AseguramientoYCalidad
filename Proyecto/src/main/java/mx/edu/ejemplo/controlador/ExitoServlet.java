package mx.edu.ejemplo.controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ExitoServlet")
public class ExitoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("usuarioAutenticado") != null) {
            request.getRequestDispatcher("/WEB-INF/vista/exito.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}