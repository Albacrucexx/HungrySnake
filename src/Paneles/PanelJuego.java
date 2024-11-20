package Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class PanelJuego extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private final int DELAY = 150;
    private int contadorInicial = 3;

    private ArrayList<Point> serpiente1;
    private ArrayList<Point> serpiente2;
    private Point manzana;
    private ArrayList<Point> obstaculos;
    private String direccion1 = "D";
    private String direccion2 = "K";
    private boolean jugando = false;
    private boolean dosJugadores = false;

    private int puntuacion1 = 0;
    private int puntuacion2 = 0;

    // Configuración adicional
    private String nombreJugador1;
    private String nombreJugador2;
    private Color colorJugador1 = Color.GREEN;
    private Color colorJugador2 = Color.YELLOW;
    private int vidas = 3; // Número inicial de vidas

    public PanelJuego(String nombreJugador1, String colorJugador1, String dificultad, String nombreJugador2, String colorJugador2, boolean modoDosJugadores) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.dosJugadores = modoDosJugadores;

        // Usar el método obtenerColor para convertir los nombres de colores a objetos Color
        this.colorJugador1 = obtenerColor(colorJugador1);
        this.colorJugador2 = obtenerColor(colorJugador2);

        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));
        addKeyListener(this);

        iniciarJuego();
    }

    private Color obtenerColor(String color) {
        switch (color.toUpperCase()) {
            case "GREEN":
                return Color.GREEN;
            case "YELLOW":
                return Color.YELLOW;
            case "RED":
                return Color.RED;
            case "BLUE":
                return Color.BLUE;
            case "BLACK":
                return Color.BLACK;
            case "WHITE":
                return Color.WHITE;
            default:
                return Color.GRAY; // Color por defecto si el color no es reconocido
        }
    }

    public void iniciarJuego() {
        serpiente1 = new ArrayList<>();
        serpiente2 = new ArrayList<>();
        obstaculos = new ArrayList<>();
        generarManzana();

        serpiente1.add(new Point(5, 5));
        if (dosJugadores) {
            serpiente2.add(new Point(10, 10));
        }

        timer = new Timer(DELAY, this);
        timer.start();

        jugando = false;
        contadorInicial = 3;

        new Thread(() -> {
            try {
                while (contadorInicial > 0) {
                    repaint();
                    Thread.sleep(1000);
                    contadorInicial--;
                }
                jugando = true;
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void generarManzana() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(30); // Suponiendo un ancho de 30 celdas
            y = random.nextInt(20); // Suponiendo un alto de 20 celdas
            manzana = new Point(x, y);
        } while (colisionConSerpienteOObstaculo(manzana));
    }

    private boolean colisionConSerpienteOObstaculo(Point punto) {
        for (Point segmento : serpiente1) {
            if (punto.equals(segmento)) {
                return true;
            }
        }

        if (dosJugadores) {
            for (Point segmento : serpiente2) {
                if (punto.equals(segmento)) {
                    return true;
                }
            }
        }

        for (Point obstaculo : obstaculos) {
            if (punto.equals(obstaculo)) {
                return true;
            }
        }

        return false;
    }

    private void moverSerpientes() {
        moverSerpiente(serpiente1, direccion1);

        if (dosJugadores) {
            moverSerpiente(serpiente2, direccion2);
        }
    }

    private void moverSerpiente(ArrayList<Point> serpiente, String direccion) {
        Point cabeza = new Point(serpiente.get(0));
        switch (direccion) {
            case "W" -> cabeza.y--;
            case "A" -> cabeza.x--;
            case "S" -> cabeza.y++;
            case "D" -> cabeza.x++;
            case "I" -> cabeza.y--;
            case "J" -> cabeza.x--;
            case "K" -> cabeza.y++;
            case "L" -> cabeza.x++;
        }

        serpiente.add(0, cabeza);
        serpiente.remove(serpiente.size() - 1);
    }

    private void verificarComida(ArrayList<Point> serpiente, int jugador) {
        if (serpiente.get(0).equals(manzana)) {
            serpiente.add(new Point(manzana));
            generarManzana();
            if (jugador == 1) {
                puntuacion1++;
            } else if (jugador == 2) {
                puntuacion2++;
            }
        }
    }

    private void verificarColisiones() {
        // Aquí puedes agregar la lógica de colisiones (como si una serpiente choca contra sí misma o un obstáculo)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jugando) {
            moverSerpientes();
            verificarComida(serpiente1, 1);

            if (dosJugadores) {
                verificarComida(serpiente2, 2);
            }

            verificarColisiones();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar vidas
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Vidas: " + vidas, getWidth() - 100, 30);

        if (contadorInicial > 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString(String.valueOf(contadorInicial), getWidth() / 2 - 20, getHeight() / 2);
            return;
        }

        // Dibujar otros elementos (manzana, serpientes, etc.)
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W && !direccion1.equals("S")) {
            direccion1 = "W";
        } else if (keyCode == KeyEvent.VK_A && !direccion1.equals("D")) {
            direccion1 = "A";
        } else if (keyCode == KeyEvent.VK_S && !direccion1.equals("W")) {
            direccion1 = "S";
        } else if (keyCode == KeyEvent.VK_D && !direccion1.equals("A")) {
            direccion1 = "D";
        }

        if (keyCode == KeyEvent.VK_I && !direccion2.equals("S")) {
            direccion2 = "I";
        } else if (keyCode == KeyEvent.VK_J && !direccion2.equals("D")) {
            direccion2 = "J";
        } else if (keyCode == KeyEvent.VK_K && !direccion2.equals("W")) {
            direccion2 = "K";
        } else if (keyCode == KeyEvent.VK_L && !direccion2.equals("A")) {
            direccion2 = "L";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

