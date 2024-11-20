package Principales;

import Menus.MenuPrincipal;
import Paneles.PanelJuego;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContenedor;

    public VentanaPrincipal() {
        setTitle("Juego de la Serpiente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        // Crear el menú principal
        MenuPrincipal menuPrincipal = new MenuPrincipal(this); // Aquí pasamos 'this' como VentanaPrincipal
        panelContenedor.add(menuPrincipal, "MenuPrincipal");

        // Crear las pantallas de juego (en este caso, solo una por ahora)
        PanelJuego panelJuego = new PanelJuego("Jugador 1", "GREEN", "Facil", "", "", false); // Juego 1 jugador por defecto
        panelContenedor.add(panelJuego, "PanelJuego");

        add(panelContenedor);
        cardLayout.show(panelContenedor, "MenuPrincipal"); // Mostrar el menú principal primero
    }

    public void mostrarJuego(String modo) {
        // Aquí decides si es 1 o 2 jugadores
        if (modo.equals("Dos Jugadores")) {
            // Aquí cambias a la pantalla de dos jugadores
            PanelJuego panelJuegoDosJugadores = new PanelJuego("Jugador 1", "GREEN", "Facil", "Jugador 2", "YELLOW", true);
            panelContenedor.add(panelJuegoDosJugadores, "PanelJuego");
            cardLayout.show(panelContenedor, "PanelJuego");
        } else {
            // Para un jugador
            PanelJuego panelJuegoUnJugador = new PanelJuego("Jugador 1", "GREEN", "Facil", "", "", false);
            panelContenedor.add(panelJuegoUnJugador, "PanelJuego");
            cardLayout.show(panelContenedor, "PanelJuego");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}




