package board;

public class SquareName {
    private int x;
    private int y;

    public SquareName(int x, int y) {
        this.x = x + 1;    //modifica los valores de array a valores de juego
        this.y = y + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}