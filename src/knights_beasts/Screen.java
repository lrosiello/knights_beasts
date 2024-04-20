package knights_beasts;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import input.MouseInput;

public class Screen extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private BufferStrategy bs;
	private Graphics g;
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	private MouseInput mouseInput;
	private Image backgroundImage, grassImage;

	public Screen() {
		super("Knights & Beasts");
		this.setSize(1400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		canvas = new Canvas();
		mouseInput = new MouseInput();

		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		backgroundImage = Toolkit.getDefaultToolkit().getImage("src/images/knights.jpg");	
		grassImage = Toolkit.getDefaultToolkit().getImage("src/images/grass.jpg");
		add(canvas);

	}
	
	
	private void update() {
		
	}
	
	private void draw() {
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// LINEAS DE DIBUJADO
		 g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		   g.drawRect(300, 100, 1000, 500);
	        g.drawImage(grassImage, 300, 100, 1000, 500, this);
		
		//
		g.dispose();
		bs.show();
	}
	
	
	

	@Override
	public void run() {
		while(running) {
			update();
			draw();
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

}
