package Menus;

import Puntuaciones.ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPuntuaciones extends JPanel {
    public MenuPuntuaciones() {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Puntuaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JTextArea areaPuntuaciones = new JTextArea();
        areaPuntuaciones.setEditable(false);

        ArrayList<String> puntuaciones = new ScoreManager().getTopScores();
        for (String linea : puntuaciones) {
            areaPuntuaciones.append(linea + "\n");
        }

        add(new JScrollPane(areaPuntuaciones), BorderLayout.CENTER);
    }
}
