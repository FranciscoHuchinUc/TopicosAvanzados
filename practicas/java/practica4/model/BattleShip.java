package model;

public class BattleShip {

    private int partsLeft; // the ship size, how much of it left
    private Cell[] cells; // the cells that the ship located on
    private int index = 0; // the index that points on the last value int the cells, it increased every
                           // time.

    // initializing
    public BattleShip(int size) {
        partsLeft = size;
        cells = new Cell[size];
    }

    // adding the cell to the cells array and increasing the index
    public void addCell(Cell c) {
        cells[index++] = c;
    }

    // getter
    public Cell[] getCells() {
        return cells;
    }

    // decreases the ship size every time it gets hit
    public void destory() {
        partsLeft -= 1;
    }

    // returns if the ship destroyed or not.
    public boolean completlyDestroied() {
        return partsLeft <= 0;
    }

}
