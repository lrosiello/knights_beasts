package board;

import java.awt.Graphics;

public class Board {
    private Square[][] squares; // Matriz de casillas
    private int startX, startY; // Coordenadas de inicio del tablero
    private int squareSize; // Tamaño de cada casilla
    

    public Board() {
        startX = 400;
        startY = 100;
        squareSize = 150;
        
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

    public void draw(Graphics g, int cameraX, int cameraY, int cameraWidth, int cameraHeight) {
        for (Square[] row : squares) {
            for (Square square : row) {
                // Verifica si la casilla está dentro del área visible de la cámara
                if (square.getX() >= cameraX && square.getX() < cameraX + cameraWidth &&
                    square.getY() >= cameraY && square.getY() < cameraY + cameraHeight) {
                    // Ajusta las coordenadas de la casilla para que se dibuje en la posición correcta en la pantalla
                    int adjustedX = square.getX() - cameraX;
                    int adjustedY = square.getY() - cameraY;
                    square.draw(g, adjustedX, adjustedY);
                }
            }
        }
    }

}
