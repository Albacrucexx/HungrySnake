package Principales;

import javax.swing.*;
import java.awt.*;

public class MainApp {

    public static void main(String[] args) {
        // Crear el panel principal y el cardLayout
        JPanel panelPrincipal = new JPanel();
        CardLayout cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        // Crear y añadir el MainMenu al panelPrincipal
        Menus.MainMenu mainMenu = new Menus.MainMenu(cardLayout, panelPrincipal);
        panelPrincipal.add(mainMenu, "MainMenu");

        // Crear el JFrame y añadir el panel principal
        JFrame frame = new JFrame("Juego de la Serpiente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelPrincipal);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}

