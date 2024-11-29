package Menus;

import Principales.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JPanel {

    private VentanaPrincipal ventanaPrincipal; // Referencia a la ventana principal

    public MenuPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal; // Guardar la referencia

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Apila los botones verticalmente
        setBackground(Color.BLACK); // Fondo negro

        // Crear botones
        JButton btnUnJugador = crearBoton("Un Jugador");
        JButton btnDosJugadores = crearBoton("Dos Jugadores");
        JButton btnMisiones = crearBoton("Misiones");
        JButton btnPuntuaciones = crearBoton("Puntuaciones");
        JButton btnSalir = crearBoton("Salir");

        // Configurar acciones de los botones
        btnUnJugador.addActionListener(e -> mostrarVentanaUnJugador());
        btnDosJugadores.addActionListener(e -> mostrarVentanaDosJugadores());
        btnMisiones.addActionListener(e -> mostrarVentanaMisiones());
        btnPuntuaciones.addActionListener(e -> mostrarVentanaPuntuaciones());
        btnSalir.addActionListener(e -> System.exit(0)); // Cierra el programa

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

    private void mostrarVentanaUnJugador() {
        // Crear y mostrar la configuración para un jugador
        JFrame ventana = new JFrame("Configuración - Un Jugador");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(new MenuConfiguracionUnJugador(ventanaPrincipal)); // Pasar referencia
        ventana.setVisible(true);
    }

    private void mostrarVentanaDosJugadores() {
        // Crear y mostrar la configuración para dos jugadores
        JFrame ventana = new JFrame("Configuración - Dos Jugadores");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(new MenuConfiguracionDosJugadores(ventanaPrincipal)); // Pasar referencia
        ventana.setVisible(true);
    }

    private void mostrarVentanaMisiones() {
        JFrame ventana = new JFrame("Misiones");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(new MenuMisiones());
        ventana.setVisible(true);
    }

    private void mostrarVentanaPuntuaciones() {
        JFrame ventana = new JFrame("Puntuaciones");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(new MenuPuntuaciones());
        ventana.setVisible(true);
    }
}
