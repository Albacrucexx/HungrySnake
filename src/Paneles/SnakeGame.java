package Paneles;

import javax.swing.*;

public class SnakeGame extends JFrame {

    private final PanelJuego panelJuego;

    public SnakeGame(String nombreJugador1, String colorJugador1, String dificultad, String nombreJugador2, String colorJugador2, boolean modoDosJugadores) {
        setTitle("Juego de la Serpiente");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelJuego = new PanelJuego(nombreJugador1, colorJugador1, dificultad, nombreJugador2, colorJugador2, modoDosJugadores);
        add(panelJuego);

        setVisible(true);
    }
}




