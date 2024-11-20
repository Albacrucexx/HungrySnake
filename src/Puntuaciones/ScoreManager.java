package Puntuaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que gestiona el registro y recuperación de puntuaciones.
 */
public class ScoreManager {
    private final String ARCHIVO_PUNTUACIONES = "puntuaciones.txt";

    /**
     * Guarda una nueva puntuación en el archivo de puntuaciones.
     * @param nombreJugador Nombre del jugador.
     * @param puntuacion Puntuación obtenida.
     */
    public void saveScore(String nombreJugador, int puntuacion) {
        try (FileWriter writer = new FileWriter(ARCHIVO_PUNTUACIONES, true)) {
            writer.write(nombreJugador + "," + puntuacion + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera las puntuaciones más altas del archivo.
     * @return Lista de puntuaciones ordenadas.
     */
    public ArrayList<String> getTopScores() {
        ArrayList<String> puntuaciones = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_PUNTUACIONES))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                puntuaciones.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        puntuaciones.sort((s1, s2) -> {
            int puntuacion1 = Integer.parseInt(s1.split(",")[1]);
            int puntuacion2 = Integer.parseInt(s2.split(",")[1]);
            return Integer.compare(puntuacion2, puntuacion1); // De mayor a menor
        });

        return puntuaciones;
    }

    /**
     * Limpia las puntuaciones si exceden un límite.
     * @param limite Máximo número de puntuaciones a mantener.
     */
    public void cleanScores(int limite) {
        ArrayList<String> puntuaciones = getTopScores();
        if (puntuaciones.size() > limite) {
            try (FileWriter writer = new FileWriter(ARCHIVO_PUNTUACIONES, false)) {
                for (int i = 0; i < limite; i++) {
                    writer.write(puntuaciones.get(i) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Guarda una puntuación y limpia el archivo si supera el límite especificado.
     * @param nombreJugador Nombre del jugador.
     * @param puntuacion Puntuación obtenida.
     * @param maxPuntuaciones Máximo número de puntuaciones a mantener.
     */
    public void saveAndCleanScores(String nombreJugador, int puntuacion, int maxPuntuaciones) {
        saveScore(nombreJugador, puntuacion); // Guarda la puntuación
        cleanScores(maxPuntuaciones); // Limpia si excede el límite
    }
}

