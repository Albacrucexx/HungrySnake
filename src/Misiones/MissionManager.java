package Misiones;

import java.util.ArrayList;
import java.util.List;

public class MissionManager {
    private static List<Mission> misiones;

    static {
        misiones = new ArrayList<>();
        misiones.add(new Mission("Alcanza 10 puntos en una partida", false, 50));
        misiones.add(new Mission("Sobrevive 2 minutos", false, 100));
        misiones.add(new Mission("Come 5 manzanas seguidas", false, 30));
    }

    public static List<Mission> obtenerMisiones() {
        return misiones;
    }

    public static void verificarMisiones(int puntuacion, int tiempo) {
        for (Mission mision : misiones) {
            if (!mision.isCompletada()) {
                // Agrega lógica para verificar condiciones según la misión
            }
        }
    }
}
