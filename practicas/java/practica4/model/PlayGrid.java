package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import unit4.gridLib.Grid;

public class PlayGrid {

    private Grid grid; // unit4 grid

    private boolean show; // indicates if the ships will be visible or not

    private Cell[][] arrGrid; // 2d array which stores the cells of ships

    private LinkedList<Cell> visited; // used for recursion, lookForPlacement() line 114, stores all visited cells

    private LinkedList<Cell> checked; // used to avoid double guessing guess() line 52

    private int battleShipsLeft; // number of battleships left on the board

    public static final int GRID_SIZE = 10; // constant, grid size.

    public PlayGrid(int x, int y, boolean show) {

        // Initializing the grid
        grid = new Grid(GRID_SIZE + 1, GRID_SIZE + 1, 40, 40);

        // setting grid postion
        grid.setLocation(x, y);

        this.show = show;

    }

    public Cell[][] getArrGrid() {
        return arrGrid;
    }

    public void clearGrid() {
        battleShipsLeft = 10;

        arrGrid = new Cell[GRID_SIZE][GRID_SIZE];

        checked = new LinkedList<>();

        // filling the grid with empty cells.
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                arrGrid[row][col] = new Cell(row, col);
            }
        }

        // setting the top left corner to black
        grid.setCellColor(GRID_SIZE, 0, Color.black);

        // generating letters from a - j and putting them in the first col in each row
        for (int row = 0; row < GRID_SIZE + 1; row++) {
            grid.setCellText(GRID_SIZE - row - 1, 0, ((char) (('A') + row)) + "");
        }

        // generating numbers from 0 - 9 and putting them in the first row in each col
        for (int col = 1; col < GRID_SIZE + 1; col++) {
            grid.setCellText(GRID_SIZE, col, col - 1 + "");
        }

    }

    /*
     * this method gets the coordinates of a certain cell and checks if there a
     * ship, if true, it destorys it, changes the grid status and return true value,
     * else if the cell alredy checked or there is no ship' returns false
     */
    public boolean guess(int row, int col) {

        // checking if the cell already checked
        if (checked.contains(arrGrid[row][col]))
            return false;

        // adding the cell to checked cells list
        checked.add(arrGrid[row][col]);

        // checking if the coordinates points on a ship
        if (arrGrid[row][col].hasBattleShip()) {

            BattleShip tmp = arrGrid[row][col].getBattleShip();

            // removing one part of the ship
            tmp.destory();

            // changing the cell color in the grid
            grid.setCellColor(GRID_SIZE - (row + 1), col + 1, Color.ORANGE);

            // if the current ship comletly destroyed
            if (tmp.completlyDestroied()) {

                // color the ship in differect color
                for (Cell c : tmp.getCells()) {
                    grid.setCellColor(GRID_SIZE - (c.row + 1), c.col + 1, Color.red);
                }

                // decrease total ships by one
                battleShipsLeft -= 1;
            }

            // remove current battle ship from cell
            arrGrid[row][col].removeBattleShip();

            return true;
        }

        // else just paint the cell in gray
        grid.setCellColor(GRID_SIZE - (row + 1), col + 1, Color.gray);

        return false;
    }

    // return boolean value which indicates if the board is empty or not
    public boolean isBoardEmptyFromShips() {
        return battleShipsLeft <= 0;
    }

    /* a method which generates the grid */
    public void generateGrid() {
        clearGrid();

        Random rnd = new Random();

        int[] sizes = { 1, 2, 3, 4 }; // 1 - 4 tiles, 2 - 3 tiles, 3 - 2 tiles, 4 - 1 tile each

        // iterating throw the sizes
        for (int size : sizes) {

            // looping the i times of the ship count
            for (int i = size; i > 0; i--) {

                // resetting the visited list for recursion search
                visited = new LinkedList<>();

                // generating random coordinates to start the search from
                int rndRow = rnd.nextInt(GRID_SIZE);
                int rndCol = rnd.nextInt(GRID_SIZE);

                // generating random boolean value which indicates if the ship will be vertical
                // or not
                boolean vertical = rnd.nextInt(2) == 1;

                // starting the recursion method, which search for a free space and places there
                // the ship
                lookForPlacement(rndRow, rndCol, 5 - size, vertical);

            }
        }

        // showing the grid
        grid.show();

    }

    /*
     * a recursive method which takes a starting point (row, col), the ship size and
     * a flag that indicates if its vertical or not. its starts to check if there
     * any place to put the ship, if it finds a place, it generating new ship with
     * the given size and puts it. else it will go to it's neighbors, and so and so
     * until it finds a place.
     */
    private boolean lookForPlacement(int row, int col, int size, boolean vertical) {

        // adding the current cell to visited list to avoid visiting it again.
        visited.add(arrGrid[row][col]);

        // checking if the cell free, if true put the ship in it.
        if (isCellFree(row, col, size, vertical)) {
            putShip(row, col, size, vertical);
            return true;
        }

        // else, get the neighbors and check there for a free place.
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {

                // avoiding index out of range
                if (r < 0 || r >= GRID_SIZE)
                    continue;
                if (c < 0 || c >= GRID_SIZE)
                    continue;

                // if the cell is not visited, visit it.
                if (!visited.contains(arrGrid[r][c])) {
                    if (lookForPlacement(r, c, size, vertical))
                        return true;

                }
            }
        }

        return false;

    }

    /*
     * a simple method which takes coordinates (row,col), the ship size and vertical
     * indicator, and places the ship in the needed cells
     */
    private void putShip(int row, int col, int size, boolean vertical) {

        // making a new battle ship
        BattleShip s = new BattleShip(size);

        // if the ship vertical it will put it vertically, same col, different row
        if (vertical) {
            for (int r = row; r < row + size; r++) {

                // adding the ship to the cell
                arrGrid[r][col].setBattleShip(s);

                // adding the cell to the ship, which stores all the cell which the ships
                // located
                s.addCell(arrGrid[r][col]);

                // if the ship is allowed to be show, paint it on the grid
                if (show) {
                    grid.setCellColor(GRID_SIZE - (r + 1), col + 1, Color.GREEN);

                }
            }

        }
        // else the ship is horozontal and it will put it horozontally, same row,
        // different col
        else {
            for (int c = col; c < col + size; c++) {

                // adding the ship to the cell
                arrGrid[row][c].setBattleShip(s);

                // adding the cell to the ship, which stores all the cell which the ships
                // located
                s.addCell(arrGrid[row][c]);

                // if the ship is allowed to be show, paint it on the grid
                if (show) {
                    grid.setCellColor(GRID_SIZE - (row + 1), c + 1, Color.GREEN);
                }
            }
        }

    }

    /*
     * checking if a ship with certain size can be be put at current row and column
     * the method actually checks if the ship and its wrapping padding doesnt
     * collides with others. therefore the loops starts one index before and ends
     * one index after
     */
    private boolean isCellFree(int row, int col, int size, boolean vertical) {

        // Checking if the vertical ship dont collides with others
        if (vertical) {
            for (int r = row - 1; r <= row + size; r++) {

                // avoiding index out of bounds
                if (r < 0 || r >= GRID_SIZE)
                    return false;

                for (int c = col - 1; c <= col + 1; c++) {

                    // avoiding index out of bounds
                    if (c < 0 || c >= GRID_SIZE)
                        continue;

                    if (arrGrid[r][c].hasBattleShip()) {
                        return false;
                    }

                }

            }
            return true;
        }

        // Checking if the horozontal ship dont collides with others
        for (int c = col - 1; c <= col + size; c++) {

            // avoiding index out of bounds
            if (c < 0 || c >= GRID_SIZE)
                return false;

            for (int r = row - 1; r <= row + 1; r++) {

                // avoiding index out of bounds
                if (r < 0 || r >= GRID_SIZE)
                    continue;

                if (arrGrid[r][c].hasBattleShip())
                    return false;
            }

        }

        return true;
    }

    // returns the 2d array in a linkedlist format
    public LinkedList<Cell> getCellsList() {
        LinkedList<Cell> cells = new LinkedList<>();

        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                cells.add(arrGrid[r][c]);
            }
        }

        return cells;
    }

    public Grid getGrid() {
        return grid;
    }

}
