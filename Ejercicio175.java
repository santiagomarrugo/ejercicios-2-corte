import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Ejercicio175 {
    public static void main(String[] args) {
        // Obtener la fecha actual del usuario en formato (AAAA-MM-DD)
        String fechaActualStr = JOptionPane.showInputDialog("Ingrese la fecha actual en formato AAAA-MM-DD:");

        // Validar el formato de la fecha
        if (validarFormatoFecha(fechaActualStr)) {
            // Obtener la fecha del día anterior
            String fechaAnterior = obtenerFechaAnterior(fechaActualStr);

            // Mostrar el resultado utilizando JOptionPane
            JOptionPane.showMessageDialog(null, "La fecha del día anterior es: " + fechaAnterior);
        } else {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Ingrese en formato AAAA-MM-DD.");
        }
    }

    // Método para validar el formato de la fecha
    private static boolean validarFormatoFecha(String fecha) {
        // El formato debe ser AAAA-MM-DD
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    // Método para obtener la fecha del día anterior
    private static String obtenerFechaAnterior(String fechaActualStr) {
        try {
            // Parsear la fecha actual
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaActual = sdf.parse(fechaActualStr);

            // Obtener el objeto Calendar y establecer la fecha actual
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaActual);

            // Restar un día
            calendar.add(Calendar.DAY_OF_MONTH, -1);

            // Obtener la nueva fecha
            Date fechaAnterior = calendar.getTime();

            // Formatear la nueva fecha y devolverla como String
            return sdf.format(fechaAnterior);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al calcular la fecha del día anterior.";
        }
    }

}