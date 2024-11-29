package Menus;

import Principales.VentanaPrincipal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConfiguracion extends JPanel {
    public MenuConfiguracion(VentanaPrincipal ventana) {
        setLayout(null);

        JLabel titulo = new JLabel("Configuración del Juego");
        titulo.setBounds(300, 20, 200, 30);
        add(titulo);

        // Campo de texto para nombre del jugador
        JTextField campoNombre = new JTextField("Nombre Jugador");
        campoNombre.setBounds(300, 100, 200, 30);
        add(campoNombre);

        // ComboBox para seleccionar color
        JComboBox<String> colores = new JComboBox<>(new String[]{"Rojo", "Verde", "Azul"});
        colores.setBounds(300, 150, 200, 30);
        add(colores);

        // ComboBox para seleccionar dificultad
        JComboBox<String> dificultad = new JComboBox<>(new String[]{"Fácil", "Medio", "Difícil"});
        dificultad.setBounds(300, 200, 200, 30);
        add(dificultad);

        // Botón para iniciar el juego
        JButton botonIniciar = new JButton("Iniciar");
        botonIniciar.setBounds(300, 300, 200, 40);
        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarJuego("PanelJuego");
            }
        });
        add(botonIniciar);

        // Botón para regresar al menú principal
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(300, 350, 200, 40);
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarMenuPrincipal();
            }
        });
        add(botonRegresar);
    }
}
