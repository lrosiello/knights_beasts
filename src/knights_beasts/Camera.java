package knights_beasts;

public class Camera {
    private int x; // Posición x de la cámara
    private int y; // Posición y de la cámara
    private int width; // Ancho de la cámara
    private int height; // Alto de la cámara
    private int worldWidth; // Ancho total del mundo
    private int worldHeight; // Alto total del mundo

    public Camera() {
        this.x = 300;
        this.y = 100;
        this.width = 900;
        this.height = 450;
        this.worldWidth = 3000;
        this.worldHeight = 1500;
    }

    public void centerOn(int targetX, int targetY) {
        // Centra la cámara en el objetivo, asegurándose de que no se salga del mundo
        x = Math.max(0, Math.min(targetX - width / 2, worldWidth - width));
        y = Math.max(0, Math.min(targetY - height / 2, worldHeight - height));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

