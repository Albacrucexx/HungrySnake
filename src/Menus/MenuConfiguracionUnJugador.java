package Menus;

import Paneles.PanelJuego;
import Principales.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;

public class MenuConfiguracionUnJugador extends JPanel {

    public MenuConfiguracionUnJugador(VentanaPrincipal ventana) {
        setLayout(new GridLayout(4, 2, 10, 10)); // Diseño en cuadrícula para organizar los elementos

        // Campo para el nombre del jugador
        JLabel lblNombre = new JLabel("Nombre del Jugador:");
        JTextField txtNombre = new JTextField();

        // Campo para seleccionar el color de la serpiente
        JLabel lblColor = new JLabel("Color de la Serpiente:");
        JComboBox<String> cbColor = new JComboBox<>(new String[]{"Rojo", "Verde", "Azul"});

        // Campo para seleccionar la dificultad
        JLabel lblDificultad = new JLabel("Dificultad:");
        JComboBox<String> cbDificultad = new JComboBox<>(new String[]{"Fácil", "Media", "Difícil"});

        // Botón de aceptación
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String color = (String) cbColor.getSelectedItem();
            String dificultad = (String) cbDificultad.getSelectedItem();

            // Convertir color
            Color colorJugador = obtenerColor(color);

            // Cerrar la ventana de configuración y abrir el juego
            JFrame ventanaJuego = new JFrame("Snake Game");
            ventanaJuego.setSize(800, 600);
            ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJuego panelJuego = new PanelJuego(false, colorJugador, Color.YELLOW);
            ventanaJuego.add(panelJuego);
            ventanaJuego.setVisible(true);

            SwingUtilities.getWindowAncestor(this).dispose(); // Cierra la ventana actual
        });

        // Añadir componentes al panel
        add(lblNombre);
        add(txtNombre);
        add(lblColor);
        add(cbColor);
        add(lblDificultad);
        add(cbDificultad);
        add(new JLabel()); // Espaciador
        add(btnAceptar);
    }

    private Color obtenerColor(String colorStr) {
        switch (colorStr.toLowerCase()) {
            case "rojo":
                return Color.RED;
            case "verde":
                return Color.GREEN;
            case "azul":
                return Color.BLUE;
            default:
                return Color.BLACK; // Por defecto
        }
    }
}
