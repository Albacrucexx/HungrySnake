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

    public static List<Mission> getMisiones() {
        return misiones;
    }

    public static void verificarMisiones(int puntuacion, int tiempo, int manzanasSeguidas) {
        for (Mission mision : misiones) {
            if (!mision.isCompletada()) {
                switch (mision.getDescripcion()) {
                    case "Alcanza 10 puntos en una partida":
                        if (puntuacion >= 10) {
                            mision.completar();
                        }
                        break;
                    case "Sobrevive 2 minutos":
                        if (tiempo >= 120) { // Tiempo en segundos
                            mision.completar();
                        }
                        break;
                    case "Come 5 manzanas seguidas":
                        if (manzanasSeguidas >= 5) {
                            mision.completar();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
