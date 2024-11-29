package Menus;

import javax.swing.*;
import java.awt.*;
import Paneles.PanelJuego;

public class MenuConfiguracionDosJugadores extends JPanel {
    public MenuConfiguracionDosJugadores(JFrame ventana) {
        setLayout(new GridLayout(7, 2, 10, 10));

        JLabel lblNombre1 = new JLabel("Nombre Jugador 1:");
        JTextField txtNombre1 = new JTextField();

        JLabel lblColor1 = new JLabel("Color Jugador 1:");
        JComboBox<String> cbColor1 = new JComboBox<>(new String[]{"Rojo", "Verde", "Azul"});

        JLabel lblNombre2 = new JLabel("Nombre Jugador 2:");
        JTextField txtNombre2 = new JTextField();

        JLabel lblColor2 = new JLabel("Color Jugador 2:");
        JComboBox<String> cbColor2 = new JComboBox<>(new String[]{"Amarillo", "Cian", "Magenta"});

        JLabel lblDificultad = new JLabel("Dificultad:");
        JComboBox<String> cbDificultad = new JComboBox<>(new String[]{"Fácil", "Media", "Difícil"});

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String color1 = (String) cbColor1.getSelectedItem();
            String color2 = (String) cbColor2.getSelectedItem();

            Color jugador1 = obtenerColor(color1);
            Color jugador2 = obtenerColor(color2);

            // Configurar la ventana del juego
            ventana.getContentPane().removeAll();
            PanelJuego panelJuego = new PanelJuego(true, jugador1, jugador2);
            ventana.add(panelJuego);
            ventana.revalidate();
            ventana.repaint();
            panelJuego.requestFocus();
        });

        add(lblNombre1);
        add(txtNombre1);
        add(lblColor1);
        add(cbColor1);
        add(lblNombre2);
        add(txtNombre2);
        add(lblColor2);
        add(cbColor2);
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
            case "amarillo":
                return Color.YELLOW;
            case "cian":
                return Color.CYAN;
            case "magenta":
                return Color.MAGENTA;
            default:
                return Color.BLACK;
        }
    }
}
