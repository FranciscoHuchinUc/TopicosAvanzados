package view;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import model.BattleShip;
import model.Cell;
import model.PlayGrid;
import unit4.gridLib.Grid;

public class Game {
    public static void main(String[] args) {
        // String cmd; // commands that the player enters

        // // Scanner
        // Scanner in = new Scanner(System.in);

        // Random rand = new Random();

        // // Player's grid initializing
        // PlayGrid playerGrid = new PlayGrid(-10 * 32, 0, true);

        // // Enemy's grid initializing
        // PlayGrid enemyGrid = new PlayGrid(10 * 32, 0, false);

        // // stay in game until the player didnt exit
        // while (true) {

        //     System.out.println("\n         BattleShips          \n");

        //     while (true) {
        //         System.out.println("- Para salir escriba 'salir' ");
        //         System.out.println("- Para iniciar escriba 'iniciar' ");

        //         cmd = in.nextLine();

        //         if (cmd.toLowerCase().equals("salir"))
        //             System.exit(0);
        //         if (cmd.toLowerCase().equalsIgnoreCase("iniciar")) {
        //             cleanBoards(playerGrid.getGrid(), enemyGrid.getGrid());
        //             playerGrid.generateGrid();
        //             enemyGrid.generateGrid();
        //             break;
        //         }
        //     }

        //     // List with all avalible enemy guess, each guess the list will be decreased
        //     LinkedList<Cell> avalibleCellsToGuessEnemy = playerGrid.getCellsList();

        //     // List with all avalible player guess, each guess the list will be decreased
        //     LinkedList<Cell> avalibleCellsToGuessPlayer = enemyGrid.getCellsList();

        //     LinkedList<Cell> queue = new LinkedList<>();

        //     System.out.println("Game Starts!! You are on the left, your turn.");
        //     // Keep playing unil one of those boards will be empty from ships
        //     while (!enemyGrid.isBoardEmptyFromShips() && !playerGrid.isBoardEmptyFromShips()) {
        //         try {
        //             // player's turn:

        //             int row, col;

        //             // until player's input is correct;
        //             while (true) {
        //                 // Getting player's input
        //                 System.out.println("cell (Format: number letter e.q: a5):");
        //                 String cell = in.nextLine().toLowerCase();

        //                 // converting the input to cell coordinates
        //                 row = cell.charAt(0) - 'a';
        //                 col = Integer.parseInt(cell.charAt(1) + "");

        //                 // checking if the cell already checked
        //                 if (avalibleCellsToGuessPlayer.contains(enemyGrid.getArrGrid()[row][col])) {

        //                     // removing the cell to avoid checking it again
        //                     avalibleCellsToGuessPlayer.remove(enemyGrid.getArrGrid()[row][col]);
        //                     break;
        //                 }

        //                 System.out.println("You already checked this cell!!");
        //             }

        //             // checking if the guess was right
        //             enemyGrid.guess(row, col);

        //             // if the player wins in his turn stop the loop
        //             if (enemyGrid.isBoardEmptyFromShips())
        //                 break;

        //             // making a delay between player's and enemy's turns
        //             Thread.sleep(300);

        //             // enemy's turn (AI):

        //             // if there are any clues about ships, search for them, else find random cell
        //             Cell cell = queue.isEmpty()
        //                     ? avalibleCellsToGuessEnemy.get(rand.nextInt(avalibleCellsToGuessEnemy.size()))
        //                     : queue.pop();

        //             System.out.println("Enemy: " + ((char) (cell.row + 'a')) + "".toUpperCase() + cell.col);

        //             // removing from avalible cells
        //             avalibleCellsToGuessEnemy.remove(cell);

        //             BattleShip b = cell.getBattleShip();
        //             boolean hit = playerGrid.guess(cell.row, cell.col);

        //             // if bot hit the ship
        //             if (hit) {

        //                 // look for nearby cells
        //                 for (int r = cell.row - 1; r <= cell.row + 1; r++) {
        //                     for (int c = cell.col - 1; c <= cell.col + 1; c++) {

        //                         // avoiding index out of bounds
        //                         if (r < 0 || r >= PlayGrid.GRID_SIZE)
        //                             continue;
        //                         if (c < 0 || c >= PlayGrid.GRID_SIZE)
        //                             continue;

        //                         if (c == cell.col && r == cell.row)
        //                             continue;

        //                         // ignore diagoal cells and remove them from avalible list
        //                         if (r != cell.row && c != cell.col) {
        //                             queue.remove(playerGrid.getArrGrid()[r][c]);
        //                             avalibleCellsToGuessEnemy.remove(playerGrid.getArrGrid()[r][c]);
        //                             continue;
        //                         }

        //                         if (!avalibleCellsToGuessEnemy.contains(playerGrid.getArrGrid()[r][c]))
        //                             continue;

        //                         // add remaing cells to queue
        //                         queue.add(playerGrid.getArrGrid()[r][c]);
        //                     }
        //                 }
        //             }
        //             if (hit && b != null && b.completlyDestroied()) {
        //                 // if the ship destroyed, remove queue from avalible list and clear it
        //                 avalibleCellsToGuessEnemy.removeAll(queue);
        //                 queue.clear();
        //             }

        //         } catch (Exception e) {
        //             // Handling wrong input
        //             System.out.println("Worng input, please try again");
        //         }
        //     }

        //     // End game.
        //     System.out.println("Game over!");
        //     if (playerGrid.isBoardEmptyFromShips()) {
        //         endGame(enemyGrid.getGrid(), playerGrid.getGrid());
        //         System.out.println("You lost!!");
        //     } else {
        //         endGame(playerGrid.getGrid(), enemyGrid.getGrid());
        //         System.out.println("You won!!");
        //     }

        // }

    }

    // 
    public static void startGame() {
        String cmd; // momandandos que el usuario ingresara

        Scanner in = new Scanner(System.in);

        Random rand = new Random();

        // Inicialización del grid del jugador
        PlayGrid playerGrid = new PlayGrid(-10 * 32, 0, true);

        // Inicialización del grid del enemigo
        PlayGrid enemyGrid = new PlayGrid(10 * 32, 0, false);

        // Permanecer en el juego hasta que el jugador no salga
        while (true) {

            System.out.println("\n         BattleShips          \n");

            while (true) {
                System.out.println("- Para salir escriba 'salir' ");
                System.out.println("- Para iniciar escriba 'iniciar' ");

                cmd = in.nextLine();

                if (cmd.toLowerCase().equals("salir"))
                    System.exit(0);
                if (cmd.toLowerCase().equalsIgnoreCase("iniciar")) {
                    cleanBoards(playerGrid.getGrid(), enemyGrid.getGrid());
                    playerGrid.generateGrid();
                    enemyGrid.generateGrid();
                    break;
                }
            }

            // Lista con todos los enemigos posibles, cada vez que se adivina la lista se reduce.
            LinkedList<Cell> avalibleCellsToGuessEnemy = playerGrid.getCellsList();

            // Lista con todas las suposiciones de los jugadores disponibles, cada suposición la lista se reducirá
            LinkedList<Cell> avalibleCellsToGuessPlayer = enemyGrid.getCellsList();

            LinkedList<Cell> queue = new LinkedList<>();

            System.out.println("Game Starts!! You are on the left, your turn.");
            // Sigue jugando hasta que uno de los tableros esté vacío de barcos
            while (!enemyGrid.isBoardEmptyFromShips() && !playerGrid.isBoardEmptyFromShips()) {
                try {
                    // turno del jugador:
                    int row, col;

                    // hasta que la entrada del jugador sea correcta;
                    while (true) {
                        // Obtener la opinión de los jugadores
                        System.out.println("cell (Format: number letter e.q: a5):");
                        String cell = in.nextLine().toLowerCase();

                        // convertir la entrada en coordenadas de la celda
                        row = cell.charAt(0) - 'a';
                        col = Integer.parseInt(cell.charAt(1) + "");

                        // comprueba si la celda ya está marcada
                        if (avalibleCellsToGuessPlayer.contains(enemyGrid.getArrGrid()[row][col])) {

                            // eliminar la celda para no volver a comprobarla
                            avalibleCellsToGuessPlayer.remove(enemyGrid.getArrGrid()[row][col]);
                            break;
                        }

                        System.out.println("You already checked this cell!!");
                    }

                    // comprobar si la suposición era correcta
                    enemyGrid.guess(row, col);

                    // si el jugador gana en su turno se detiene el bucle
                    if (enemyGrid.isBoardEmptyFromShips())
                        break;

                    // hacer un retraso entre los turnos del jugador y del enemigo
                    Thread.sleep(300);

                    // turno del enemigo (IA):

                    // si hay pistas sobre los barcos, las busca, si no, encuentra una celda al azar
                    Cell cell = queue.isEmpty()
                            ? avalibleCellsToGuessEnemy.get(rand.nextInt(avalibleCellsToGuessEnemy.size()))
                            : queue.pop();

                    System.out.println("Enemy: " + ((char) (cell.row + 'a')) + "".toUpperCase() + cell.col);

                    // eliminar de las celdas disponibles
                    avalibleCellsToGuessEnemy.remove(cell);

                    BattleShip b = cell.getBattleShip();
                    boolean hit = playerGrid.guess(cell.row, cell.col);

                    // si el bot golpea el barco
                    if (hit) {

                        // buscar celdas cercanas
                        for (int r = cell.row - 1; r <= cell.row + 1; r++) {
                            for (int c = cell.col - 1; c <= cell.col + 1; c++) {

                                // evitar el índice fuera de los límites
                                if (r < 0 || r >= PlayGrid.GRID_SIZE)
                                    continue;
                                if (c < 0 || c >= PlayGrid.GRID_SIZE)
                                    continue;

                                if (c == cell.col && r == cell.row)
                                    continue;

                                // ignorar las celdas diarias y eliminarlas de la lista de disponibles
                                if (r != cell.row && c != cell.col) {
                                    queue.remove(playerGrid.getArrGrid()[r][c]);
                                    avalibleCellsToGuessEnemy.remove(playerGrid.getArrGrid()[r][c]);
                                    continue;
                                }

                                if (!avalibleCellsToGuessEnemy.contains(playerGrid.getArrGrid()[r][c]))
                                    continue;

                                // añadir las celdas restantes a la cola
                                queue.add(playerGrid.getArrGrid()[r][c]);
                            }
                        }
                    }
                    if (hit && b != null && b.completlyDestroied()) {
                        // si el barco se destruye, eliminar la cola de la lista de disponibles y borrarla
                        avalibleCellsToGuessEnemy.removeAll(queue);
                        queue.clear();
                    }

                } catch (Exception e) {
                    // Manejo de entradas erróneas
                    System.out.println("Worng input, please try again");
                }
            }

            // Fin del Juego
            System.out.println("¡Se acabó el juego!");
            if (playerGrid.isBoardEmptyFromShips()) {
                endGame(enemyGrid.getGrid(), playerGrid.getGrid());
                System.out.println("Has perdido!!");
            } else {
                endGame(playerGrid.getGrid(), enemyGrid.getGrid());
                System.out.println("Has Ganado!!");
            }

        }
    }

    // pinta las tablas
    public static void endGame(Grid winner, Grid looser) {

        Random rnd = new Random();

        int delay = 5;

        winner.setDelay(delay);
        looser.setDelay(delay);

        for (int row = 0; row < winner.getRowsCount(); row++) {
            for (int col = 0; col < winner.getColumnsCount(); col++) {
                looser.setCellText(row, col, "");
                looser.setCellColor(row, col, Color.black);
                winner.setCellText(row, col, "");
                winner.setCellColor(row, col, new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        }

        winner.setDelay(0);
        looser.setDelay(0);
    }

    public static void cleanBoards(Grid winner, Grid looser) {
        Color c = new Color(0, 167, 190);

        for (int row = winner.getRowsCount() - 2; row >= 0; row--) {
            for (int col = 1; col < winner.getColumnsCount(); col++) {
                looser.setCellText(row, col, "");
                looser.setCellColor(row, col, c);
                winner.setCellText(row, col, "");
                winner.setCellColor(row, col, c);
            }
        }
    }
}
