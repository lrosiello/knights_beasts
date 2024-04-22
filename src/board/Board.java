package board;

import java.awt.Graphics;

public class Board {
    private Square[][] squares; // Matriz de casillas
    private int startX, startY; // Coordenadas de inicio del tablero
    private int squareSize; // Tamaño de cada casilla

    public Board() {
        startX = 300;
        startY = 100;
        squareSize = 50;
        
        int rows = 10; // Número de filas
        int columns = 20; // Número de columnas

        squares = new Square[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Calcular las coordenadas de la casilla actual
                int currentX = startX + j * squareSize;
                int currentY = startY + i * squareSize;
                
                SquareName name = new SquareName(i, j);
                
                squares[i][j] = new Square(currentX, currentY, squareSize, name);
            }
        }
    }

    public void draw(Graphics g) {
        for (Square[] row : squares) {
            for (Square square : row) {
                square.draw(g);
            }
        }
    }
}
