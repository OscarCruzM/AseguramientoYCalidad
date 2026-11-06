package mx.edu.ejemplo.modelo;

public class Seguridad {
    // Normaliza respuestas para evitar fallos por mayúsculas o espacios extra
    public static boolean compararRespuestas(String esperada, String ingresada) {
        if (esperada == null || ingresada == null) return false;
        return esperada.trim().equalsIgnoreCase(ingresada.trim());
    }
}