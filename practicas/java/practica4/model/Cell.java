package model;

public class Cell {

    public int row, col; // coordenadas
    private BattleShip battleShip; // el battleship que se almacena en la celda

    // inicializa las cordenasdas en el constructor
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // devuelve si hay un battleship en la celda
    public boolean hasBattleShip() {
        return battleShip != null;
    }

    // remueve el battleship de la celda
    public void removeBattleShip() {
        battleShip = null;
    }

    // getters and setters:

    public void setBattleShip(BattleShip b) {
        battleShip = b;
    }

    public BattleShip getBattleShip() {
        return battleShip;
    }

}
