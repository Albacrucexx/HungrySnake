package Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class PanelJuego extends JPanel implements KeyListener, ActionListener {
    private ArrayList<Point> serpiente1;
    private ArrayList<Point> serpiente2;
    private ArrayList<Point> obstaculos;
    private Point manzana;

    private int puntuacion1, puntuacion2;
    private boolean jugando = false;
    private boolean dosJugadores;

    private Color colorJugador1, colorJugador2;

    private Timer timer;
    private int delay = 150;
    private int direccion1X = 1, direccion1Y = 0;
    private int direccion2X = 0, direccion2Y = 0;

    private final int tableroAncho = 30;
    private final int tableroAlto = 20;

    public PanelJuego(boolean dosJugadores, Color colorJugador1, Color colorJugador2) {
        this.dosJugadores = dosJugadores;
        this.colorJugador1 = colorJugador1;
        this.colorJugador2 = colorJugador2;

        this.serpiente1 = new ArrayList<>();
        this.serpiente2 = new ArrayList<>();
        this.obstaculos = new ArrayList<>();

        inicializarJuego();

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(delay, this);
        timer.start();
    }

    public void reiniciarJuego() {
        inicializarJuego(); // Reiniciar el estado del juego
        timer.restart();    // Reiniciar el temporizador
        repaint();          // Redibujar el panel
    }

    private void inicializarJuego() {
        serpiente1.clear();
        serpiente1.add(new Point(5, 5));

        if (dosJugadores) {
            serpiente2.clear();
            serpiente2.add(new Point(15, 5));
        }

        obstaculos.clear();
        generarObstaculos(3); // Generar 3 obstáculos al azar

        generarManzana();
        puntuacion1 = 0;
        puntuacion2 = 0;
        jugando = true;
    }

    private void generarObstaculos(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            Point nuevoObstaculo;
            do {
                nuevoObstaculo = new Point(random.nextInt(tableroAncho), random.nextInt(tableroAlto));
            } while (colisionConSerpienteOObstaculo(nuevoObstaculo));
            obstaculos.add(nuevoObstaculo);
        }
    }

    private void generarManzana() {
        Random random = new Random();
        do {
            manzana = new Point(random.nextInt(tableroAncho), random.nextInt(tableroAlto));
        } while (colisionConSerpienteOObstaculo(manzana));
    }

    private boolean colisionConSerpienteOObstaculo(Point punto) {
        for (Point obstaculo : obstaculos) {
            if (punto.equals(obstaculo)) return true;
        }
        for (Point parte : serpiente1) {
            if (punto.equals(parte)) return true;
        }
        if (dosJugadores) {
            for (Point parte : serpiente2) {
                if (punto.equals(parte)) return true;
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(colorJugador1);
        for (Point p : serpiente1) {
            g.fillRect(p.x * 20, p.y * 20, 20, 20);
        }

        if (dosJugadores) {
            g.setColor(colorJugador2);
            for (Point p : serpiente2) {
                g.fillRect(p.x * 20, p.y * 20, 20, 20);
            }
        }

        g.setColor(Color.RED);
        for (Point obstaculo : obstaculos) {
            g.fillRect(obstaculo.x * 20, obstaculo.y * 20, 20, 20);
        }

        g.setColor(Color.GREEN);
        g.fillRect(manzana.x * 20, manzana.y * 20, 20, 20);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("P1: " + puntuacion1, 20, 30);
        if (dosJugadores) {
            g.drawString("P2: " + puntuacion2, 20, 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moverSerpiente(serpiente1, direccion1X, direccion1Y);
        if (dosJugadores) moverSerpiente(serpiente2, direccion2X, direccion2Y);

        verificarComida(serpiente1, 1);
        if (dosJugadores) verificarComida(serpiente2, 2);

        verificarColisiones();
        repaint();
    }

    private void moverSerpiente(ArrayList<Point> serpiente, int dx, int dy) {
        Point nuevaCabeza = new Point(serpiente.get(0).x + dx, serpiente.get(0).y + dy);

        // Verificar colisión con los bordes del tablero
        if (nuevaCabeza.x < 0 || nuevaCabeza.y < 0 || nuevaCabeza.x >= tableroAncho || nuevaCabeza.y >= tableroAlto) {
            terminarJuego(1); // Terminar el juego si se sale del tablero
            return;
        }

        serpiente.add(0, nuevaCabeza);
        serpiente.remove(serpiente.size() - 1);
    }

    private void verificarComida(ArrayList<Point> serpiente, int jugador) {
        if (serpiente.get(0).equals(manzana)) {
            serpiente.add(new Point(manzana));
            generarManzana();
            generarManzana(); // Aparecen dos nuevas manzanas

            if (jugador == 1) puntuacion1++;
            if (jugador == 2) puntuacion2++;
        }
    }

    private void verificarColisiones() {
        if (colisionConObstaculo(serpiente1.get(0)) || colisionConSerpiente(serpiente1)) terminarJuego(1);
        if (dosJugadores && (colisionConObstaculo(serpiente2.get(0)) || colisionConSerpiente(serpiente2)))
            terminarJuego(2);
    }

    private boolean colisionConObstaculo(Point punto) {
        return obstaculos.contains(punto);
    }

    private boolean colisionConSerpiente(ArrayList<Point> serpiente) {
        for (int i = 1; i < serpiente.size(); i++) {
            if (serpiente.get(0).equals(serpiente.get(i))) return true;
        }
        return false;
    }

    private void terminarJuego(int jugador) {
        jugando = false;
        timer.stop();
        String mensaje = jugador == 1 ? "¡Jugador 1 ha perdido!" : "¡Jugador 2 ha perdido!";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W && direccion1Y == 0) { direccion1X = 0; direccion1Y = -1; }
        if (keyCode == KeyEvent.VK_S && direccion1Y == 0) { direccion1X = 0; direccion1Y = 1; }
        if (keyCode == KeyEvent.VK_A && direccion1X == 0) { direccion1X = -1; direccion1Y = 0; }
        if (keyCode == KeyEvent.VK_D && direccion1X == 0) { direccion1X = 1; direccion1Y = 0; }

        if (dosJugadores) {
            if (keyCode == KeyEvent.VK_UP && direccion2Y == 0) { direccion2X = 0; direccion2Y = -1; }
            if (keyCode == KeyEvent.VK_DOWN && direccion2Y == 0) { direccion2X = 0; direccion2Y = 1; }
            if (keyCode == KeyEvent.VK_LEFT && direccion2X == 0) { direccion2X = -1; direccion2Y = 0; }
            if (keyCode == KeyEvent.VK_RIGHT && direccion2X == 0) { direccion2X = 1; direccion2Y = 0; }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
