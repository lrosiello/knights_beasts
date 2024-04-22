package knights_beasts;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import board.Board;
import input.MouseInput;

public class Screen extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private BufferStrategy bs;
    private Graphics g;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;
    private MouseInput mouseInput;
    private Image backgroundImage;

    public Screen() {
        super("Knights & Beasts");
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        canvas = new Canvas();
        mouseInput = new MouseInput();

        canvas.setPreferredSize(new Dimension(1400, 800));
        canvas.setMaximumSize(new Dimension(1400, 800));
        canvas.setMinimumSize(new Dimension(1400, 800));
        canvas.setFocusable(true);
        add(canvas);

        backgroundImage = Toolkit.getDefaultToolkit().getImage("src/images/knights.jpg");
        

        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
    }

    private void update() {
        // Actualiza la lógica del juego
    }

    private void draw() {
        // Dibuja la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        //instancio el tablero
        Board board = new Board();
		// Dibujar el tablero
        board.draw(g);
    }

    @Override
    public void run() {
        canvas.createBufferStrategy(3); //automaticamente esta funcion verifica si es null
        bs = canvas.getBufferStrategy();

        while (running) {
            update();
            
            // Obtiene el gráfico de la estrategia de búfer
            g = bs.getDrawGraphics();

            draw();

            // Muestra el buffer
            bs.show();

            // Libera recursos del gráfico
            g.dispose();
        }
        stop();
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.start();
    }
}
