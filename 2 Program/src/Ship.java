/**
 * This class simulates a ship
 * @author Arash
 * @version 1.0.0
 */
public class Ship {
    private int angleStatus; //1: horizontal | 0: vertical
    private int rows;
    private int cols;
    private int startPointX;
    private int startPointY;
    private int length;

    /**
     * Sets angle status and length to zero by default. This is going to change later
     */
    public Ship() {
        angleStatus = 0;
        length = 0;
    }

    /*************************** GETTER AND SETTER METHODS ************************/
    public int getAngleStatus() {
        return angleStatus;
    }

    public void setAngleStatus(int angleStatus) {
        this.angleStatus = angleStatus;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getStartPointX() {
        return startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }
    /*************************** GETTER AND SETTER METHODS ************************/


    /**
     * Gets the length of the ship and sets number of columns and rows of the ship according to angle status
     * @param num Is the length for the ship given by the user, can be from {2,3,4,5}
     */
    public void setColsOrRows(int num) {
        if (angleStatus == 0) { //If the ship is vertical
            rows = 1;
            cols = num;
            length = num;
        } else if (angleStatus == 1) {//If the ship is horizontal
            rows = num;
            cols = 1;
            length = num;
        }
    }

    /**
     * Sets the start place of the ship (Far left coordinates for horizontal ship | Far above for the vertical ship)
     * @param x x coordinate of the start place
     * @param y y coordinate of the start place
     */
    public void shipStartPlace(int x, int y) {
        this.startPointX = x;
        this.startPointY = y;
    }

    /**
     *
     * @return Length of the ship
     */
    public int getLength() {
        return length;
    }
}
