package Basicos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Obstaculo {
    private int x, y;

    public Obstaculo() {
        recrear();
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x * 10, y * 10, 10, 10);
    }

    public void recrear() {
        Random random = new Random();
        this.x = random.nextInt(40); // Ajusta según el tamaño del tablero
        this.y = random.nextInt(30);
    }

    public boolean colisionCon(int posX, int posY) {
        return this.x == posX && this.y == posY;
    }
}
