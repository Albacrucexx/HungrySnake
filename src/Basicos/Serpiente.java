package Basicos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Serpiente {
    private LinkedList<Segmento> segmentos;
    private Color color;

    public Serpiente(Color color) {
        this.color = color;
        segmentos = new LinkedList<>();
        segmentos.add(new Segmento(10, 10));  // Inicializa en una posición
    }

    public void mover() {
        // Lógica para mover la serpiente
    }

    public void dibujar(Graphics g) {
        for (Segmento segmento : segmentos) {
            g.setColor(color);
            g.fillRect(segmento.getX() * 10, segmento.getY() * 10, 10, 10);
        }
    }

    public boolean colisionConObstaculo(Obstaculo obstaculo) {
        // Lógica para colisión con obstáculos
        return false;
    }

    public boolean comerManzana(Manzana manzana) {
        // Lógica para detectar si la serpiente comió la manzana
        return false;
    }

    public boolean colisionConSerpiente(Serpiente otraSerpiente) {
        // Lógica para detectar si la serpiente choca con la otra
        return false;
    }

    public void moverArriba() {
        // Movimiento hacia arriba
    }

    public void moverIzquierda() {
        // Movimiento hacia la izquierda
    }

    public void moverAbajo() {
        // Movimiento hacia abajo
    }

    public void moverDerecha() {
        // Movimiento hacia la derecha
    }
}

class Segmento {
    private int x, y;

    public Segmento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
