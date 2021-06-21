package model;

public class BattleShip {

    private int partsLeft; // el tamaño del barco, cuánto queda de el
    private Cell[] cells; // las casillas en las que se encuentra el barco
    private int index = 0; // el índice que apunta al último valor de las celdas, se incrementa cada tiempo

    public BattleShip(int size) {
        partsLeft = size;
        cells = new Cell[size];
    }

    // añadiendo la celda a la matriz de celdas e incrementando el índice
    public void addCell(Cell c) {
        cells[index++] = c;
    }

    // getter
    public Cell[] getCells() {
        return cells;
    }

    // disminuye el tamaño del barco cada vez que es golpeada
    public void destory() {
        partsLeft -= 1;
    }

    // devuelve si el barco fue destruido o no
    public boolean completlyDestroied() {
        return partsLeft <= 0;
    }

}
