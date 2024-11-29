package Menus;

import Misiones.Mission;
import Misiones.MissionManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuMisiones extends JPanel {
    public MenuMisiones() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        List<Mission> misiones = MissionManager.getMisiones();

        for (Mission mision : misiones) {
            add(new JLabel("Misión: " + mision.getDescripcion()));
            add(new JLabel("Recompensa: " + mision.getRecompensa()));
            add(new JLabel("Estado: " + (mision.isCompletada() ? "Completada" : "Pendiente")));
            add(new JSeparator());
        }
    }
}
