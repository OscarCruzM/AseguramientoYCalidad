package mx.edu.ejemplo.controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.ejemplo.modelo.Usuario;
import mx.edu.ejemplo.modelo.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");

        Usuario usuario = usuarioDAO.validarCredenciales(user, pass);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioTemp", usuario);
            session.setAttribute("paso1Completado", true);
            response.sendRedirect("PreguntasServlet");
        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}