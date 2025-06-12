package modelo;

public class ValidacionDeportistaException extends Exception {
    public ValidacionDeportistaException(String mensaje) {
        super(mensaje);
    }

    // Subclase para nombre vacío
    public static class NombreVacio extends ValidacionDeportistaException {
        public NombreVacio(String mensaje) {
            super(mensaje);
        }
    }

    // Subclase para DNI vacío
    public static class DniVacio extends ValidacionDeportistaException {
        public DniVacio(String mensaje) {
            super(mensaje);
        }
    }

    // Subclase para cantidad insuficiente
    public static class CantidadInsuficiente extends ValidacionDeportistaException {
        public CantidadInsuficiente(String mensaje) {
            super(mensaje);
        }
    }
}