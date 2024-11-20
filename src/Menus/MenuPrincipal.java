package Menus;

import Principales.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JPanel {

    public MenuPrincipal(VentanaPrincipal ventanaPrincipal) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Apila los botones verticalmente
        setBackground(Color.BLACK); // Fondo negro

        // Crear botones
        JButton btnUnJugador = crearBoton("Un Jugador");
        JButton btnDosJugadores = crearBoton("Dos Jugadores");
        JButton btnMisiones = crearBoton("Misiones");
        JButton btnPuntuaciones = crearBoton("Puntuaciones");
        JButton btnSalir = crearBoton("Salir");

        // Configurar acciones de los botones
        btnUnJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarJuego("Un Jugador"); // Llamar a la función para mostrar el juego de 1 jugador
            }
        });

        btnDosJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.mostrarJuego("Dos Jugadores"); // Llamar a la función para mostrar el juego de 2 jugadores
            }
        });

        btnMisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar navegación hacia el menú de misiones
            }
        });

        btnPuntuaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar navegación hacia el menú de puntuaciones
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa
            }
        });

        // Añadir botones al panel
        add(Box.createVerticalGlue()); // Espacio flexible arriba
        add(btnUnJugador);
        add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre botones
        add(btnDosJugadores);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnMisiones);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnPuntuaciones);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnSalir);
        add(Box.createVerticalGlue()); // Espacio flexible abajo
    }



    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
        boton.setBackground(Color.GREEN); // Fondo verde
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente personalizada
        return boton;
    }
}




