package Menus;

import Paneles.PanelJuego;
import Puntuaciones.ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JPanel {

    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public MainMenu(CardLayout cardLayout, JPanel panelPrincipal) {
        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;

        setLayout(new GridLayout(5, 1));

        // Botón Iniciar Juego
        JButton btnIniciarJuego = new JButton("Iniciar Juego");
        btnIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        // Botón Misiones
        JButton btnMisiones = new JButton("Misiones");
        btnMisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMisiones();
            }
        });

        // Botón Puntuaciones
        JButton btnPuntuaciones = new JButton("Puntuaciones");
        btnPuntuaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPuntuaciones();
            }
        });

        // Botón Dos Jugadores
        JButton btnDosJugadores = new JButton("Dos Jugadores");
        btnDosJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuegoDosJugadores();
            }
        });

        // Botón Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar los botones al panel
        add(btnIniciarJuego);
        add(btnMisiones);
        add(btnPuntuaciones);
        add(btnDosJugadores);
        add(btnSalir);

        // Forzar la actualización del panel para que los botones aparezcan correctamente
        revalidate();
        repaint();
    }

    // Función para iniciar el juego
    private void iniciarJuego() {
        String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1:");
        String colorJugador1 = JOptionPane.showInputDialog("Ingrese el color de la serpiente (ejemplo: Verde):");
        String dificultad = JOptionPane.showInputDialog("Seleccione la dificultad (Fácil, Media, Difícil):");

        // Crear y cambiar al panel de juego en vez de abrir una nueva ventana
        PanelJuego panelJuego = new PanelJuego(nombreJugador1, colorJugador1, dificultad, "Jugador 2", "Amarillo", false);
        panelPrincipal.add(panelJuego, "PanelJuego");
        cardLayout.show(panelPrincipal, "PanelJuego");
    }

    // Función para mostrar las misiones
    private void mostrarMisiones() {
        JOptionPane.showMessageDialog(null, "Misiones aún no implementadas.");
    }

    // Función para mostrar las puntuaciones
    private void mostrarPuntuaciones() {
        ScoreManager scoreManager = new ScoreManager();
        ArrayList<String> puntuaciones = scoreManager.getTopScores();
        StringBuilder puntuacionesStr = new StringBuilder("Puntuaciones:\n");

        for (String puntuacion : puntuaciones) {
            puntuacionesStr.append(puntuacion).append("\n");
        }

        JOptionPane.showMessageDialog(null, puntuacionesStr.toString());
    }

    // Función para iniciar el juego en modo dos jugadores
    private void iniciarJuegoDosJugadores() {
        String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1:");
        String colorJugador1 = JOptionPane.showInputDialog("Ingrese el color de la serpiente 1:");
        String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 2:");
        String colorJugador2 = JOptionPane.showInputDialog("Ingrese el color de la serpiente 2:");
        String dificultad = JOptionPane.showInputDialog("Seleccione la dificultad (Fácil, Media, Difícil):");

        // Crear y cambiar al panel de juego en modo dos jugadores
        PanelJuego panelJuego = new PanelJuego(nombreJugador1, colorJugador1, dificultad, nombreJugador2, colorJugador2, true);
        panelPrincipal.add(panelJuego, "PanelJuego");
        cardLayout.show(panelPrincipal, "PanelJuego");
    }
}


