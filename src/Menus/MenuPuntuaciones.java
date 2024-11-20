package Menus;

import Principales.VentanaPrincipal;
import Puntuaciones.ScoreManager;

import javax.swing.*;
import java.awt.*;

/**
 * Pantalla que muestra las puntuaciones más altas.
 */
public class MenuPuntuaciones extends JPanel {
    public MenuPuntuaciones(VentanaPrincipal ventana) {
        setLayout(new BorderLayout());

        // Título del menú de puntuaciones
        JLabel titulo = new JLabel("Puntuaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Área de texto para mostrar puntuaciones
        JTextArea areaPuntuaciones = new JTextArea();
        areaPuntuaciones.setEditable(false);
        add(new JScrollPane(areaPuntuaciones), BorderLayout.CENTER);

        // Botón para volver al menú principal
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> ventana.mostrarJuego("MenuPrincipal"));
        add(botonVolver, BorderLayout.SOUTH);

        // Cargar las puntuaciones desde el gestor
        ScoreManager scoreManager = new ScoreManager();
        StringBuilder puntuaciones = new StringBuilder();
        for (String linea : scoreManager.getTopScores()) {
            puntuaciones.append(linea).append("\n");
        }
        areaPuntuaciones.setText(puntuaciones.toString());
    }
}


