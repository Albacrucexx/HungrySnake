package CuentaAtras;

import javax.swing.*;
import java.awt.*;

public class GameStartCountdown {
    public void startCountdown(JFrame frame, Runnable startGame) {
        // Crear la etiqueta para la cuenta atrás
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        frame.add(label);  // Añadir la etiqueta a la ventana
        frame.revalidate();  // Asegurar que se vuelva a pintar la ventana

        // Iniciar un hilo para la cuenta atrás
        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                label.setText(String.valueOf(i));  // Establecer el número de la cuenta atrás
                try {
                    Thread.sleep(1000);  // Pausar el hilo por 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Cuando la cuenta atrás termine, eliminar la etiqueta
            frame.remove(label);
            frame.revalidate();
            frame.repaint();
            startGame.run();  // Llamar al inicio del juego
        }).start();
    }
}
