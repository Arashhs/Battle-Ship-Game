/**
 * This class simulates each player's boards
 * @author Arash
 * @version 1.0.0
 *
 */
public class Board {
    private static final int rows = 10;
    private static final int columns = 10;
    private int[][] opponetBoard;
    private int[][] playerBoard;

    /**
     * Makes 2 new 2D arrays for player and opponet boards
     */
    public Board() {
        opponetBoard = new int[rows][columns];
        playerBoard = new int[rows][columns];
    }
/********** GETTER METHODS **********/
    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    /**
     * Initializes player and opponet boards with -1 for each place
     */
    public void initBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                opponetBoard[i][j] = -1;
                playerBoard[i][j] = -1;
            }
        }
    }

    /**
     * Shows opponet's board
     */
    public void showOpponetBoard() {
        System.out.println("  |\t0 |\t1 |\t2 |\t3 |\t4 |\t5 |\t6 |\t7 |\t8 |\t9 |");
        System.out.println("--|---+---+---+---+---+---+---+---+---+---|");

        for (int row = 0; row < rows; row++) {
            System.out.print(row + " |");
            for (int column = 0; column < columns; column++) {
                if (opponetBoard[row][column] == -1) {
                    System.out.print("\t" + " ");
                } else if (opponetBoard[row][column] == 0) {
                    System.out.print("\t" + ConsoleColors.RED_BACKGROUND_BRIGHT + "X" + ConsoleColors.RESET);
                } else if (opponetBoard[row][column] == 1) {
                    System.out.print("\t" + ConsoleColors.BLUE_BACKGROUND_BRIGHT + "&" + ConsoleColors.RESET);
                }
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("--|---+---+---+---+---+---+---+---+---+---|");
        }
    }

    /**
     * Shows player's board
     */
    public void showPlayerBoard() {
        System.out.println("  |\t0 |\t1 |\t2 |\t3 |\t4 |\t5 |\t6 |\t7 |\t8 |\t9 |");
        System.out.println("--|---+---+---+---+---+---+---+---+---+---|");

        for (int row = 0; row < rows; row++) {
            System.out.print(row + " |");
            for (int column = 0; column < columns; column++) {
                if (playerBoard[row][column] == -1) {
                    System.out.print("\t" + " ");
                } else if (playerBoard[row][column] == 0) {
                    System.out.print("\t" + ConsoleColors.GREEN_BACKGROUND + "@" + ConsoleColors.RESET);
                } else if (playerBoard[row][column] == 1) {
                    System.out.print("\t" + ConsoleColors.RED_BACKGROUND_BRIGHT + "#" + ConsoleColors.RESET);
                } else if (playerBoard[row][column] == 2) {
                    System.out.print("\t" + ConsoleColors.YELLOW_BACKGROUND + "." + ConsoleColors.RESET);
                }
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("--|---+---+---+---+---+---+---+---+---+---|");
        }
    }

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return true: There is a ship in the given coordinates | false: there is no ship in the given coordinates
     */
    public boolean isShip(int x, int y) {
        if (playerBoard[x][y] == 0)
            return true;
        else
            return false;
    }

    /**
     * We check shot availablity with BattleShips class's method. If it is available then we shot using this method
     * @param x x coordinate for shot
     * @param y y coordinate for shot
     * @param bool true: shot hit | false: no hit
     */
    public void shot(int x, int y, boolean bool) { //true: shot hit | false: no hit
        if (bool) {
            opponetBoard[x][y] = 1;
        } else {
            opponetBoard[x][y] = 0;
        }
    }


    /**
     * Places a piece of ship on the player's board
     * @param x x coordinate of a piece of ship
     * @param y y coordinate of a piece of ship
     */
    public void placeShips(int x, int y) {
        playerBoard[x][y] = 0;
    }

    /* ********** THESE ARE GETTER AND SETTER METHODS ************* */
    public int[][] getOpponetBoard() {
        return opponetBoard;
    }

    public void setOpponetBoard(int x, int y, int status) {
        this.opponetBoard[x][y] = status;
    }

    public int[][] getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(int x, int y, int status) {
        this.playerBoard[x][y] = status;
    }
}


