/**
 * This class simulates a player in the game
 * @author Arash
 * @version 1.0.0
 */
public class Player {
    private Board playerBoards; //Each player has a player board and his opponet's board
    private Ship[] playerShips; //Each player has 5 ships

    /**
     * Makes a new board object for player ( Each board has 2 pieces: Player's board and opponet's board)
     * Makes 5 ships for the player
     * initializes players board with empty spaces in his board (No ship is located for now)
     */
    public Player() {
        playerBoards = new Board();
        playerShips = new Ship[5];
        for (int i = 0; i < 5; i++) {
            playerShips[i] = new Ship();
        }
        playerBoards.initBoard();
    }

    /**
     *
     * @param angleStatus Angle status for selected ship (0: vertical | 1: horizontal)
     * @param length Length of the chosen ship
     * @param shipNum Ship number Can be from {0,1,2,3,4}
     */
    public void chooseShips(int angleStatus, int length, int shipNum) {
        playerShips[shipNum].setAngleStatus(angleStatus); //Sets angle status for the chosen ship
        playerShips[shipNum].setColsOrRows(length); //Sets either columns or rows for the ship according to the angle status
    }

    /**
     * Places chosen ship on the player's board
     * @param shipNum is the ship number chosen. Can be from {0,1,2,3,4}
     */
    public void placeShips(int shipNum) {
        for (int i = playerShips[shipNum].getStartPointX(); i < playerShips[shipNum].getCols() + playerShips[shipNum].getStartPointX(); i++) {
            for (int j = playerShips[shipNum].getStartPointY(); j < playerShips[shipNum].getRows() + playerShips[shipNum].getStartPointY(); j++) {
                playerBoards.placeShips(i, j); //Sets 0 in the given coordinate which means theres a ship on the board
            }
        }
    }

    /**
     * Check if it is available for a ship to be placed in the given coordinates or not
     * @param x x coordinate
     * @param y y coordinate
     * @param shipNum Ship number we want to check if its available to place it on the given coordinates
     * @return true: Its avaiable to place the ship in the given coordinates | false: Its not available to place the ship in the given coordinates
     */
    public boolean checkAvailable(int x, int y, int shipNum) {
        for (int i = playerShips[shipNum].getStartPointX(); i < playerShips[shipNum].getCols() + playerShips[shipNum].getStartPointX(); i++) {
            for (int j = playerShips[shipNum].getStartPointY(); j < playerShips[shipNum].getRows() + playerShips[shipNum].getStartPointY(); j++) {
                if (i > 9 || i < 0 || j > 9 || j < 0 || playerBoards.getPlayerBoard()[i][j] != -1 ) //If the coordinates were not located in the board or there was a ship already located in a place of the given coordinates, then its not available to place the ship there
                    return false;
            }
        }
        return true;
    }

    /******************** GETTER METHODS ***************************/
    public void showPlayerBoard() {
        playerBoards.showPlayerBoard();
    }

    public void showOpponetBoard() {
        playerBoards.showOpponetBoard();
    }

    public Board getPlayerBoards() {
        return playerBoards;
    }

    public Ship[] getPlayerShips() {
        return playerShips;
    }
}
