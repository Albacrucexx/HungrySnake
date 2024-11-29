package Paneles;

import javax.swing.*;
import java.awt.*;

public class SnakeGame {
    private JFrame frame;
    private PanelJuego panelJuego;

    public SnakeGame(boolean dosJugadores, String colorJugador1, String colorJugador2) {
        frame = new JFrame("Snake Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Convertir las cadenas a colores
        Color color1 = obtenerColor(colorJugador1);
        Color color2 = obtenerColor(colorJugador2);

        panelJuego = new PanelJuego(dosJugadores, color1, color2);

        frame.add(panelJuego);
        frame.setVisible(true);

        // Iniciar el juego
        iniciarJuego();
    }

    private void iniciarJuego() {
        panelJuego.reiniciarJuego(); // Llama al método definido en PanelJuego
    }

    private Color obtenerColor(String colorStr) {
        try {
            return Color.decode("#" + colorStr);
        } catch (NumberFormatException e) {
            return Color.BLACK; // Color por defecto en caso de error
        }
    }

    public static void main(String[] args) {
        // Iniciar la aplicación con parámetros de prueba
        new SnakeGame(true, "FF0000", "00FF00"); // Rojo y Verde
    }
}
