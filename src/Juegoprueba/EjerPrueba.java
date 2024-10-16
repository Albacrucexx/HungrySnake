package Juegoprueba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class EjerPrueba extends JFrame {

    public EjerPrueba() {
        setTitle("Juego de la Serpiente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new FlowLayout());

        JLabel texto = new JLabel("Bienvenido a Hungry Snake");  // Crear etiqueta
        add(texto);

        // Añadir el SnakeGame al JFrame
        SnakeGame snakeGame = new SnakeGame();
        add(snakeGame);
    }

    public static class ConfirmDialog {
        public static void main(String[] args) {
            // Mostrar cuadro confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                System.out.println("Seleccionado sí");
            } else {
                System.out.println("Seleccionado no");
            }
        }
    }

    public static class SnakeGame extends JPanel implements KeyListener, ActionListener {
        private final int TILE_SIZE = 25; // Tamaño de cada cuadrado
        private final int WIDTH = 20; // Ancho del tablero (en tiles)
        private final int HEIGHT = 20; // Alto del tablero (en tiles)

        private ArrayList<Point> snake; // Coordenadas de la serpiente
        private Point apple; // Coordenada de la manzana
        private char direction; // Dirección de la serpiente
        private boolean gameOver; // Estado del juego
        private Timer timer; // Controlador del tiempo para el movimiento

        public SnakeGame() {
            setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(this);


        }

        private void startGame() {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            // Evitar movimientos opuestos
            switch (key) {
                case KeyEvent.VK_UP:
                    if (direction != 'D') direction = 'U'; // Arriba
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') direction = 'D'; // Abajo
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') direction = 'L'; // Izquierda
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') direction = 'R'; // Derecha
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjerPrueba frame = new EjerPrueba();
            frame.setVisible(true); // Mostrar la ventana
        });
    }
}
