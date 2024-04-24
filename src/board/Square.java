package board;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Square {
	   private int x, y; // Coordenadas de la casilla
	    private int size; // Tamanio de la casilla
	    private SquareName name; // Nombre de la casilla
	    
	    private Image grassImage;
	    
	    public Square(int x, int y, int size, SquareName name) {
	        this.x = x;
	        this.y = y;
	        this.size = size;
	        this.name = name;
	        grassImage = Toolkit.getDefaultToolkit().getImage("src/images/grass.jpg");
	    }

	    public void draw(Graphics g, int adjustedX, int adjustedY) {
	    	 g.drawImage(grassImage, adjustedX, adjustedY, size, size, null);
	    	    // Dibujar el nombre en el centro del cuadrado
	    	    g.drawString(name.getX() + ", " + name.getY(), adjustedX + size / 4, adjustedY + size / 2);
	        
	    }
	    
	    
	    public SquareName getName() {
	        return name;
	    }
	    
	    public int getX() {
	    	return x;
	    }
	    
	    public int getY() {
	    	return y;
	    }
}
