package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Button {

	private BufferedImage mouseOutImg;
	private BufferedImage mouseInImg;
	private boolean mouseIn;
	private Rectangle boundingBox;
	private String text;
	
	public Button(BufferedImage mouseOutImg, BufferedImage mouseInImg, int x, int y,
			String text) {
		super();
		this.mouseOutImg = mouseOutImg;
		this.mouseInImg = mouseInImg;
		this.text = text;
		boundingBox = new Rectangle (x , y, mouseInImg.getWidth(), mouseInImg.getWidth());
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
}
