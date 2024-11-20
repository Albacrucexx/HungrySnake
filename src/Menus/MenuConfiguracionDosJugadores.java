package Menus;

import Principales.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConfiguracionDosJugadores extends JPanel {
    public MenuConfiguracionDosJugadores(VentanaPrincipal ventana) {
        setLayout(new GridLayout(7, 2, 10, 10));

        JLabel lblNombre1 = new JLabel("Nombre Jugador 1:");
        JTextField txtNombre1 = new JTextField();

        JLabel lblColor1 = new JLabel("Color Jugador 1:");
        JComboBox<String> cbColor1 = new JComboBox<>(new String[] { "Rojo", "Verde", "Azul" });

        JLabel lblNombre2 = new JLabel("Nombre Jugador 2:");
        JTextField txtNombre2 = new JTextField();

        JLabel lblColor2 = new JLabel("Color Jugador 2:");
        JComboBox<String> cbColor2 = new JComboBox<>(new String[] { "Amarillo", "Cian", "Magenta" });

        JLabel lblDificultad = new JLabel("Dificultad:");
        JComboBox<String> cbDificultad = new JComboBox<>(new String[] { "Fácil", "Media", "Difícil" });

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnVolver = new JButton("Volver");

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Configurar valores y pasar al juego
                ventana.mostrarJuego("PanelJuego");
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarJuego("MenuPrincipal");
            }
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
        add(btnAceptar);
        add(btnVolver);
    }
}
