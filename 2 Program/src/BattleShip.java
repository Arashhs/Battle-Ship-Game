import java.util.Random;

/**
 * This class simulates battleShip game with 2 players
 * Player 1 is a human
 * Player 2 can be either human or AI
 * @author Arash
 * @since 3/26/2018
 * @version 1.0.0
 */

public class BattleShip {
    private Player p1; //Human player
    private Player p2; //Either human or AI

    /**
     * Constructor simply makes 2 new player classes
     */
    public BattleShip() {
        p1 = new Player();
        p2 = new Player();
    }

    /**
     * This is the accurate shot, it hits the exact coordinates given
     * It updates both player's boards and opponet's board according to shot status
     * @param x x coordinate for shot
     * @param y y coordinate for shot
     * @param playerNum player number (1 or 2)
     * @return Shot hit status | 1: hit   0: no hit   -1: Unknown shot(This never happens anyway...)
     */
    public int accurateShot(int x, int y, int playerNum) { //1: hit | 0: no hit
        if (playerNum == 1) {
            boolean isShip = p2.getPlayerBoards().isShip(x, y);
            p1.getPlayerBoards().shot(x, y, isShip);
            if (isShip) {
                p1.getPlayerBoards().setOpponetBoard(x, y, 1);
                p2.getPlayerBoards().setPlayerBoard(x, y, 1);
                return 1;
            } else {
                p1.getPlayerBoards().setOpponetBoard(x, y, 0);
                p2.getPlayerBoards().setPlayerBoard(x, y, 2);
                return 0;
            }
        } else if (playerNum == 2) {
            boolean isShip = p1.getPlayerBoards().isShip(x, y);
            p2.getPlayerBoards().shot(x, y, isShip);
            if (isShip) {
                p2.getPlayerBoards().setOpponetBoard(x, y, 1);
                p1.getPlayerBoards().setPlayerBoard(x, y, 1);
                return 1;
            } else {
                p2.getPlayerBoards().setOpponetBoard(x, y, 0);
                p1.getPlayerBoards().setPlayerBoard(x, y, 2);
                return 0;
            }
        }
        return -1;
    }

    /**
     * This is the lossy shot, it can hit either the exact coordinate or other 8 neighborhoods
     * @param x x coordinate given
     * @param y y coordinate given
     * @param playerNum player number (1 or 2)
     * @return hit status | 1: hit - 0: no hit
     */
    public int lossyShot(int x, int y, int playerNum) { //1: hit | 0: no hit
        Random random = new Random();
        int a = random.nextInt(3) - 1; //{-1,0,1}
        int b = random.nextInt(3) - 1; //{-1,0,1}
        while (!shotAvailablity(x + a, y + b, playerNum)) { //While shot is not available, generate another random coordinates from 8 neighborhoods or the exact coordinate given
            a = random.nextInt(3) - 1;
            b = random.nextInt(3) - 1;
        }
        return accurateShot(x + a, y + b, playerNum); //Shot accurately at the choosing exact coordinate or other 8 neighborhoods
    }

    /**
     * Calls either accurate shot or lossy shot
     * @param x x coordinate of the shot
     * @param y y coordinate of the shot
     * @param playerNum player number(1 or 2)
     * @param shotStyle (1: accurate shot | 2: lossy shot)
     * @return hit status| 1: hit | 0: no hit | -1: Unknown(It'll never happen anyway...)
     */
    public int shot(int x, int y, int playerNum, int shotStyle) {//1: hit | 0: no hit
        if (shotStyle == 1) {
            return accurateShot(x, y, playerNum);
        } else if (shotStyle == 2) {
            return lossyShot(x, y, playerNum);
        }
        return -1;
    }

    /**
     * Shot availablity status
     * @param x x coordinate of the chosen coordinates
     * @param y y coordinate of the chosen coordinates
     * @param playerNum player number (1 or 2)
     * @return shot availablity status: true: available | false: not available
     */
    public boolean shotAvailablity(int x, int y, int playerNum) {
        if (x > 9 || x < 0 || y > 9 || y < 0) {
            return false;
        } else {
            if (playerNum == 1) {
                if (p1.getPlayerBoards().getOpponetBoard()[x][y] != -1)
                    return false;
                else
                    return true;
            } else if (playerNum == 2) {
                if (p2.getPlayerBoards().getOpponetBoard()[x][y] != -1)
                    return false;
                else
                    return true;

            }
        }
        return false;
    }

    /**
     * total hits needed to win = total length of opponet's ships
     * @param playerNum player number(1 or 2)
     * @return total successful shots needed for win = total length of opponet's ships
     */
    public int hitsNeededForWin(int playerNum) {
        int count = 0;
        if (playerNum == 1) {
            for (int i = 0; i < 5; i++) {
                count += p2.getPlayerShips()[i].getLength();
            }
        } else if (playerNum == 2) {
            for (int i = 0; i < 5; i++){
                count += p1.getPlayerShips()[i].getLength();
            }
        }
        return count;
    }

    /**
     * if total successful hits = total hits needed for win : Player won the game!
     * @param playerNum player 1 or player 2
     * @param playerHits Successful shots of the player
     * @return true: Player won the game | false: player hasn't won the game yet
     */
    public boolean checkWin(int playerNum, int playerHits){//true: win | false: no win yet
        if(playerNum == 1 && playerHits == hitsNeededForWin(playerNum)){
            return true;
        }
        else if(playerNum == 2 && playerHits == hitsNeededForWin(playerNum)){
            return true;
        }
        else
            return false;
    }

    /**
     * Generate a random length for AI ships
     * @return random length for a ship of AI
     */
    public int randomShipLength(){
        Random rand = new Random();
        return rand.nextInt(4)+2; //{2,3,4,5}
    }

    /**
     * Generate a random coordinate for AI's shot (used both for x and y)
     * @return a random coordinate for AI's shot
     */
    public int randomCoordinates(){
        Random rand = new Random();
        return rand.nextInt(10); //{0,1,...,9}
    }

    /**
     * Generate a random direction for AI's ship (1:Horizontal | 0:Vertical}
     * @return random direction for AI's ship (1:Horizontal | 0:Vertical}
     */
    public int randomDirection(){
        Random rand = new Random();
        return rand.nextInt(2); //{0,1}
    }

    /**
     * Prints a number of empty lines to clear screen
     */
    public void clearConsole() {
        System.out.flush();
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }
        System.out.flush();
    }

    /* ***************************** THESE ARE GETTER AND SETTER METHODS **************************** */
    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

}
