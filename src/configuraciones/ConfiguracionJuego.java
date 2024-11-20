package configuraciones;

import Paneles.PanelJuego;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para la configuración del juego (nombres de jugadores, colores, y dificultad).
 */
public class ConfiguracionJuego extends JFrame {

    private boolean modoDosJugadores;

    public ConfiguracionJuego() {
        this(false);
    }

    public ConfiguracionJuego(boolean modoDosJugadores) {
        this.modoDosJugadores = modoDosJugadores;

        setTitle("Configuración del Juego");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel labelJugador1 = new JLabel("Nombre Jugador 1:");
        JTextField textJugador1 = new JTextField("Jugador 1");
        JLabel labelColor1 = new JLabel("Color Jugador 1:");
        JComboBox<String> comboColor1 = new JComboBox<>(new String[]{"Verde", "Rojo", "Azul", "Amarillo"});

        JLabel labelJugador2 = new JLabel("Nombre Jugador 2:");
        JTextField textJugador2 = new JTextField("Jugador 2");
        JLabel labelColor2 = new JLabel("Color Jugador 2:");
        JComboBox<String> comboColor2 = new JComboBox<>(new String[]{"Verde", "Rojo", "Azul", "Amarillo"});

        JLabel labelDificultad = new JLabel("Dificultad:");
        JComboBox<String> comboDificultad = new JComboBox<>(new String[]{"Fácil", "Media", "Difícil"});

        panel.add(labelJugador1);
        panel.add(textJugador1);
        panel.add(labelColor1);
        panel.add(comboColor1);
        panel.add(labelJugador2);
        panel.add(textJugador2);
        panel.add(labelColor2);
        panel.add(comboColor2);
        panel.add(labelDificultad);
        panel.add(comboDificultad);

        JButton iniciarButton = new JButton("Iniciar Juego");
        iniciarButton.addActionListener(e -> {
            String nombreJugador1 = textJugador1.getText();
            String nombreJugador2 = textJugador2.getText();
            String color1 = (String) comboColor1.getSelectedItem();
            String color2 = (String) comboColor2.getSelectedItem();
            String dificultad = (String) comboDificultad.getSelectedItem();

            // Iniciar el juego según la configuración
            new PanelJuego(nombreJugador1, color1, dificultad, nombreJugador2, color2, modoDosJugadores);
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(iniciarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}