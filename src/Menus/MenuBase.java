package Menus;

import javax.swing.*;
import java.awt.*;

public abstract class MenuBase extends JPanel {
    protected void configurarBoton(JButton boton, String texto, Action action) {
        boton.setText(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(action);
        add(boton);
    }
}
