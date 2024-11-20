package Menus;

import Misiones.Mission;
import Misiones.MissionManager;
import Principales.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuMisiones extends JPanel {
    public MenuMisiones(VentanaPrincipal ventana) {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Misiones", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(titulo, BorderLayout.NORTH);

        JTextArea areaMisiones = new JTextArea();
        areaMisiones.setEditable(false);
        areaMisiones.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(areaMisiones);
        add(scroll, BorderLayout.CENTER);

        // Cargar misiones
        List<Mission> misiones = MissionManager.obtenerMisiones();
        StringBuilder sb = new StringBuilder();
        for (Mission mision : misiones) {
            sb.append(mision).append("\n");
        }
        areaMisiones.setText(sb.toString());

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> ventana.mostrarJuego("MenuPrincipal"));
        add(botonVolver, BorderLayout.SOUTH);
    }
}

