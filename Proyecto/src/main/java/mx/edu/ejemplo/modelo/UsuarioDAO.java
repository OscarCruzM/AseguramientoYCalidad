package mx.edu.ejemplo.modelo;

public class UsuarioDAO {

    public Usuario validarCredenciales(String user, String pass) {
        System.out.println("Intentando ingresar con usuario: " + user);

        // Usuario 1: Carlos
        if ("carlos".equalsIgnoreCase(user) && "123456".equals(pass)) {
            System.out.println("-> Acceso concedido para Carlos");
            return new Usuario(
                1, 
                "carlos", 
                "123456", 
                "¿Cuál es tu color favorito?", 
                "Azul", 
                "¿Nombre de tu primera mascota?", 
                "Juan"
            );
        }

        // Usuario 2: Ana
        if ("ana".equalsIgnoreCase(user) && "ana2024".equals(pass)) {
            System.out.println("-> Acceso concedido para Ana");
            return new Usuario(
                2, 
                "ana", 
                "ana2024", 
                "¿Ciudad de nacimiento?", 
                "Madrid", 
                "¿Nombre de tu escuela primaria?", 
                "Hidalgo"
            );
        }

        // Usuario 3: Luis
        if ("luis".equalsIgnoreCase(user) && "luispass".equals(pass)) {
            System.out.println("-> Acceso concedido para Luis");
            return new Usuario(
                3, 
                "luis", 
                "luispass", 
                "¿Comida favorita?", 
                "Tacos", 
                "¿Modelo de tu primer coche?", 
                "Civic"
            );
        }

        System.out.println("-> Credenciales incorrectas.");
        return null;
    }
}