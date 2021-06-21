package model;

public class Cell {

    public int row, col; // coordinates
    private BattleShip battleShip; // the battleship that stored in the cell

    // initizalizing the coordinates
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // returns if there a battleship in the cell
    public boolean hasBattleShip() {
        return battleShip != null;
    }

    // removes the battleship from thec ell
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
