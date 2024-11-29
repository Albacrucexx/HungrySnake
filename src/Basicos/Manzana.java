package Basicos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Manzana {
    private int x, y;

    public Manzana() {
        recrear(); // Genera coordenadas iniciales al crear la manzana
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x * 10, y * 10, 10, 10);
    }

    public void recrear() {
        Random rand = new Random();
        this.x = rand.nextInt(40); // Ajusta según el tamaño del tablero
        this.y = rand.nextInt(30);
    }

    public boolean comerManzana(int cabezaX, int cabezaY) {
        // Verifica si la serpiente come la manzana
        return this.x == cabezaX && this.y == cabezaY;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
