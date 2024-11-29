package Principales;

import Menus.MenuPrincipal;
import Menus.MenuPuntuaciones;
import Menus.MenuMisiones;
import Menus.MenuConfiguracionDosJugadores;
import Menus.MenuConfiguracionUnJugador;
import Paneles.PanelJuego;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public VentanaPrincipal() {
        setTitle("Juego de la Serpiente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        add(panelPrincipal);

        // Agregar los paneles al CardLayout
        MenuPrincipal menuPrincipal = new MenuPrincipal(this);
        panelPrincipal.add(menuPrincipal, "MenuPrincipal");

        // Pasa esta instancia al constructor de MenuConfiguracionUnJugador
        panelPrincipal.add(new MenuConfiguracionUnJugador(this), "MenuConfiguracionUnJugador");
        panelPrincipal.add(new MenuConfiguracionDosJugadores(this), "MenuConfiguracionDosJugadores");
        panelPrincipal.add(new MenuMisiones(), "MenuMisiones");
        panelPrincipal.add(new MenuPuntuaciones(), "MenuPuntuaciones");

        setVisible(true);
    }

    public void iniciarJuegoUnJugador(String colorJugador1) {
        Color color1 = obtenerColor(colorJugador1);
        PanelJuego panelJuegoUnJugador = new PanelJuego(false, color1, Color.YELLOW);
        panelPrincipal.add(panelJuegoUnJugador, "PanelJuegoUnJugador");

        // Actualizar la vista al nuevo panel
        cardLayout.show(panelPrincipal, "PanelJuegoUnJugador");
        panelJuegoUnJugador.requestFocusInWindow(); // Dar enfoque al panel
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public void iniciarJuegoDosJugadores(String colorJugador1, String colorJugador2) {
        Color color1 = obtenerColor(colorJugador1);
        Color color2 = obtenerColor(colorJugador2);
        PanelJuego panelJuegoDosJugadores = new PanelJuego(true, color1, color2);
        panelPrincipal.add(panelJuegoDosJugadores, "PanelJuegoDosJugadores");

        // Actualizar la vista al nuevo panel
        cardLayout.show(panelPrincipal, "PanelJuegoDosJugadores");
        panelJuegoDosJugadores.requestFocusInWindow(); // Dar enfoque al panel
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    private Color obtenerColor(String colorStr) {
        switch (colorStr.toLowerCase()) {
            case "rojo": return Color.RED;
            case "verde": return Color.GREEN;
            case "azul": return Color.BLUE;
            case "amarillo": return Color.YELLOW;
            case "cian": return Color.CYAN;
            case "magenta": return Color.MAGENTA;
            default: return Color.BLACK;
        }
    }

    public void mostrarJuego(String panelName) {
        cardLayout.show(panelPrincipal, panelName);
    }

    public void mostrarMenuMisiones() {
        mostrarJuego("MenuMisiones");
    }

    public void mostrarMenuPrincipal() {
        mostrarJuego("MenuPrincipal");
    }

    // Método main: Punto de entrada del programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
