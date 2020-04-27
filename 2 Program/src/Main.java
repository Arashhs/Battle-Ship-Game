import java.util.Scanner;

/**
 * Main class uses BattleShip class to start a match
 * @author Arash
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        BattleShip battleShip = new BattleShip();
        System.out.print("Welcome to battle Ship game!\n[1] Player vs Player\n[2] Player vs Computer\n> ");
        Scanner scanner = new Scanner(System.in);
        String gameMode = scanner.nextLine();
        while (!gameMode.equals("1") && !gameMode.equals("2")) {
            System.out.print("Wrong input - Please select a correct game mode\n> ");
            gameMode = scanner.nextLine();
        }

        if (gameMode.equals("1")) {
            System.out.println("PvP battle is going to start!");
            System.out.println("Player 1: Please select your boats:");
            //Sets the ships of player 1 on his board
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nSelect Ship " + (i + 1) + "'s direction:\n[0] Vertical\n[1] Horizontal\n> ");
                    String direction = scanner.nextLine();
                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print("Ship direction is not accepted! Choose direction status again\n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nSelect Ship " + (i + 1) + "'s length:\n[2-5]\n> ");
                    String len = scanner.nextLine();
                    while (!len.equals("2") && !len.equals("3") && !len.equals("4") && !len.equals("5")) {
                        System.out.print("Ship's length is not accepted! Select ship's length again\n> ");
                        len = scanner.nextLine();
                    }

                    System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Wrong coordinates! Enter ship's start coordinates again:");
                        System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    battleShip.getP1().chooseShips(Integer.parseInt(direction), Integer.parseInt(len), i);
                    battleShip.getP1().getPlayerShips()[i].shipStartPlace(Integer.parseInt(y), Integer.parseInt(x));
                    if (battleShip.getP1().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        battleShip.getP1().placeShips(i);
                        battleShip.getP1().showPlayerBoard();
                    } else {
                        System.out.println("Cannot place the selected ship! You must describe ship's place again. Make sure to choose an available place");
                        i--;
                        battleShip.getP1().showPlayerBoard();
                        continue;
                    }
                }

                System.out.print("Are you OK with this set-up?\n[y] Yep, let me play already!\n[n] nope, let me set my ships again!\n> ");
                String whoops = scanner.nextLine();
                while (!whoops.equals("y") && !whoops.equals("n")) {
                    System.out.print("Wrong answer! Select [y] or [n] to continue\n> ");
                    whoops = scanner.nextLine();
                }
                if (whoops.equals("y")) {
                    battleShip.clearConsole();
                    break;
                } else {
                    battleShip.getP1().getPlayerBoards().initBoard();
                    battleShip.clearConsole();
                    continue;
                }
            }

            // Sets player 2's ships on his board
            System.out.println("Player 2: Please select your boats:");
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nSelect Ship " + (i + 1) + "'s direction:\n[0] Vertical\n[1] Horizontal\n> ");
                    String direction = scanner.nextLine();
                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print("Ship direction is not accepted! Choose direction status again\n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nSelect Ship " + (i + 1) + "'s length:\n[2-5]\n> ");
                    String len = scanner.nextLine();
                    while (!len.equals("2") && !len.equals("3") && !len.equals("4") && !len.equals("5")) {
                        System.out.print("Ship's length is not accepted! Select ship's length again\n> ");
                        len = scanner.nextLine();
                    }

                    System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Wrong coordinates! Enter ship's start coordinates again:");
                        System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    battleShip.getP2().chooseShips(Integer.parseInt(direction), Integer.parseInt(len), i);
                    battleShip.getP2().getPlayerShips()[i].shipStartPlace(Integer.parseInt(y), Integer.parseInt(x));
                    if (battleShip.getP2().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        battleShip.getP2().placeShips(i);
                        battleShip.getP2().showPlayerBoard();
                    } else {
                        System.out.println("Cannot place the selected ship! You must describe ship's place again. Make sure to choose an available place");
                        i--;
                        battleShip.getP2().showPlayerBoard();
                        continue;
                    }
                }
                System.out.print("Are you OK with this set-up?\n[y] Yep, let me play already!\n[n] nope, let me set my ships again!\n> ");
                String whoops = scanner.nextLine();
                while (!whoops.equals("y") && !whoops.equals("n")) {
                    System.out.print("Wrong answer! Select [y] or [n] to continue\n> ");
                    whoops = scanner.nextLine();
                }
                if (whoops.equals("y")) {
                    battleShip.clearConsole();
                    break;
                } else {
                    battleShip.getP2().getPlayerBoards().initBoard();
                    battleShip.clearConsole();
                    continue;
                }
            }
            battleShip.clearConsole();
            System.out.println("Ship setup completed. ");
            System.out.println("\nP1: Please choose your shot type:\n[1] Accurate Shot\n[2] Lossy Shot\n> ");
            String shotStyleP1 = scanner.nextLine();
            while (!shotStyleP1.equals("1") && !shotStyleP1.equals("2")) {
                System.out.print("Wrong input - Please select a correct shot type\n> ");
                shotStyleP1 = scanner.nextLine();
            }
            battleShip.clearConsole();
            System.out.println("\nP2: Please choose your shot type:\n[1] Accurate Shot\n[2] Lossy Shot\n> ");
            String shotStyleP2 = scanner.nextLine();
            while (!shotStyleP2.equals("1") && !shotStyleP2.equals("2")) {
                System.out.print("Wrong input - Please select a correct shot type\n> ");
                shotStyleP2 = scanner.nextLine();
            }
            battleShip.clearConsole();
            int dontStop = 1; //If player's shot hit opponet's ships, he can shot one more time
            int p1SuccessfulShots = 0;
            int p2SuccessfulShots = 0;
            while (!battleShip.checkWin(1, p1SuccessfulShots) && !battleShip.checkWin(2, p2SuccessfulShots)) {
                //Shoting process for player 1
                System.out.println("It is Player 1's turn");
                System.out.println("Player 1, Enter r to continue\n> ");
                String resume = scanner.nextLine();
                while (!resume.equals("r"))
                    resume = scanner.nextLine();
                System.out.println("Player board:");
                battleShip.getP1().getPlayerBoards().showPlayerBoard();
                System.out.println("Opponet board:");
                battleShip.getP1().getPlayerBoards().showOpponetBoard();
                dontStop = 1;
                while (dontStop == 1) {
                    dontStop = 0;
                    System.out.print("\n\nPlayer 1: Please enter shot coordinates:\nX: ");
                    String p1ShotX, p1ShotY;
                    p1ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p1ShotY = scanner.nextLine();
                    while ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9"))) {
                        System.out.print("\nUnacceptable coordinates - Select shot Coordinates again:\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                    }
                    boolean p1ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    while ((!p1ShotAvailablity) || ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9")))) {
                        System.out.print("\nSelected coordinates are not available for shot - Select another coordinates\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                        p1ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    }
                    int tmp = battleShip.shot(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1, Integer.parseInt(shotStyleP1));
                    if (tmp == 1) {
                        p1SuccessfulShots++;
                        dontStop = 1;
                    } else
                        dontStop = 0;
                    if (battleShip.checkWin(1, p1SuccessfulShots)) {
                        System.out.println("****Player 1 won the game!****\n\n");
                        System.out.println("Player 1 board:");
                        battleShip.getP1().getPlayerBoards().showPlayerBoard();
                        System.out.println("\nPlayer 2 board:");
                        battleShip.getP2().getPlayerBoards().showPlayerBoard();
                        System.out.println("\n##End of the Game##");
                        System.exit(0);
                    }
                    battleShip.getP1().getPlayerBoards().showOpponetBoard();
                    try { //Stops porcessing for 1 second. Player can observe his boards
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                //The exact shoting process as P1 for P2
                battleShip.clearConsole();
                System.out.println("It is Player 2's turn");
                System.out.println("Player 2, Enter r to continue\n> ");
                resume = scanner.nextLine();
                while (!resume.equals("r"))
                    resume = scanner.nextLine();
                System.out.println("Player board:");
                battleShip.getP2().getPlayerBoards().showPlayerBoard();
                System.out.println("Opponet board:");
                battleShip.getP2().getPlayerBoards().showOpponetBoard();
                dontStop = 1;
                while (dontStop == 1) {
                    dontStop = 0;
                    System.out.print("\n\nPlayer 2: Please enter shot coordinates:\nX: ");
                    String p2ShotX, p2ShotY;
                    p2ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p2ShotY = scanner.nextLine();
                    while ((!p2ShotX.equals("0") && !p2ShotX.equals("1") && !p2ShotX.equals("2") && !p2ShotX.equals("3") && !p2ShotX.equals("4") && !p2ShotX.equals("5") && !p2ShotX.equals("6") && !p2ShotX.equals("7") && !p2ShotX.equals("8") && !p2ShotX.equals("9")) ||
                            (!p2ShotY.equals("0") && !p2ShotY.equals("1") && !p2ShotY.equals("2") && !p2ShotY.equals("3") && !p2ShotY.equals("4") && !p2ShotY.equals("5") && !p2ShotY.equals("6") && !p2ShotY.equals("7") && !p2ShotY.equals("8") && !p2ShotY.equals("9"))) {
                        System.out.print("\nUnacceptable coordinates - Select shot Coordinates again:\nX: ");
                        p2ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p2ShotY = scanner.nextLine();
                    }
                    boolean p2ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2);
                    while ((!p2ShotAvailablity) || ((!p2ShotX.equals("0") && !p2ShotX.equals("1") && !p2ShotX.equals("2") && !p2ShotX.equals("3") && !p2ShotX.equals("4") && !p2ShotX.equals("5") && !p2ShotX.equals("6") && !p2ShotX.equals("7") && !p2ShotX.equals("8") && !p2ShotX.equals("9")) ||
                            (!p2ShotY.equals("0") && !p2ShotY.equals("1") && !p2ShotY.equals("2") && !p2ShotY.equals("3") && !p2ShotY.equals("4") && !p2ShotY.equals("5") && !p2ShotY.equals("6") && !p2ShotY.equals("7") && !p2ShotY.equals("8") && !p2ShotY.equals("9")))) {
                        System.out.print("\nSelected coordinates are not available for shot - Select another coordinates\nX: ");
                        p2ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p2ShotY = scanner.nextLine();
                        p2ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2);
                    }
                    int tmp2 = battleShip.shot(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2, Integer.parseInt(shotStyleP2));
                    if (tmp2 == 1) {
                        dontStop = 1;
                        p2SuccessfulShots++;
                    } else
                        dontStop = 0;
                    if (battleShip.checkWin(2, p2SuccessfulShots)) {
                        System.out.println("****Player 2 won the game!****\n\n");
                        System.out.println("Player 1 board:");
                        battleShip.getP1().getPlayerBoards().showPlayerBoard();
                        System.out.println("\nPlayer 2 board:");
                        battleShip.getP2().getPlayerBoards().showPlayerBoard();
                        System.out.println("\n##End of the Game##");
                        System.exit(0);
                    }
                    battleShip.getP2().getPlayerBoards().showOpponetBoard();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }


        } else if (gameMode.equals("2")) {
            //The exact same process as PvP for Player 1, Player 2's process is replaced with random methods
            System.out.println("PvE battle is going to start!");
            System.out.println("Please select your boats:");
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nSelect Ship " + (i + 1) + "'s direction:\n[0] Vertical\n[1] Horizontal\n> ");
                    String direction = scanner.nextLine();
                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print("Ship direction is not accepted! Choose direction status again\n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nSelect Ship " + (i + 1) + "'s length:\n[2-5]\n> ");
                    String len = scanner.nextLine();
                    while (!len.equals("2") && !len.equals("3") && !len.equals("4") && !len.equals("5")) {
                        System.out.print("Ship's length is not accepted! Select ship's length again\n> ");
                        len = scanner.nextLine();
                    }

                    System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Wrong coordinates! Enter ship's start coordinates again:");
                        System.out.print("\nSelect Ship " + (i + 1) + "'s start coordinates:\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    battleShip.getP1().chooseShips(Integer.parseInt(direction), Integer.parseInt(len), i);
                    battleShip.getP1().getPlayerShips()[i].shipStartPlace(Integer.parseInt(y), Integer.parseInt(x));
                    if (battleShip.getP1().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        battleShip.getP1().placeShips(i);
                        battleShip.getP1().showPlayerBoard();
                    } else {
                        System.out.println("Cannot place the selected ship! You must describe ship's place again. Make sure to choose an available place");
                        i--;
                        battleShip.getP1().showPlayerBoard();
                        continue;
                    }
                }
                System.out.print("Are you OK with this set-up?\n[y] Yep, let me play already!\n[n] nope, let me set my ships again!\n> ");
                String whoops = scanner.nextLine();
                while (!whoops.equals("y") && !whoops.equals("n")) {
                    System.out.print("Wrong answer! Select [y] or [n] to continue\n> ");
                    whoops = scanner.nextLine();
                }
                if (whoops.equals("y")) {
                    battleShip.clearConsole();
                    break;
                } else {
                    battleShip.getP1().getPlayerBoards().initBoard();
                    battleShip.clearConsole();
                    continue;
                }
            }

            while (true) {
                for (int i = 0; i < 5; i++) {
                    int direction = battleShip.randomDirection();
                    int len = battleShip.randomShipLength();
                    int x = battleShip.randomCoordinates();
                    int y = battleShip.randomCoordinates();
                    battleShip.getP2().chooseShips(direction, len, i);
                    battleShip.getP2().getPlayerShips()[i].shipStartPlace(y, x);
                    if (battleShip.getP2().checkAvailable(y, x, i)) {
                        battleShip.getP2().placeShips(i);
                    } else {
                        i--;
                        continue;
                    }
                }
                break;
            }
            battleShip.clearConsole();
            System.out.println("Ship setup completed. ");
            System.out.println("\nP1: Please choose your shot type:\n[1] Accurate Shot\n[2] Lossy Shot\n> ");
            String shotStyleP1 = scanner.nextLine();
            while (!shotStyleP1.equals("1") && !shotStyleP1.equals("2")) {
                System.out.print("Wrong input - Please select a correct shot type\n> ");
                shotStyleP1 = scanner.nextLine();
            }
            battleShip.clearConsole();
            int dontStop = 1;
            int p1SuccessfulShots = 0;
            int p2SuccessfulShots = 0;
            while (!battleShip.checkWin(1, p1SuccessfulShots) && !battleShip.checkWin(2, p2SuccessfulShots)) {
                System.out.println("It is your turn");
                System.out.println("Player board:");
                battleShip.getP1().getPlayerBoards().showPlayerBoard();
                System.out.println("Opponet board:");
                battleShip.getP1().getPlayerBoards().showOpponetBoard();
                dontStop = 1;
                while (dontStop == 1) {
                    dontStop = 0;
                    System.out.print("\n\nPlease enter shot coordinates:\nX: ");
                    String p1ShotX, p1ShotY;
                    p1ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p1ShotY = scanner.nextLine();
                    while ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9"))) {
                        System.out.print("\nUnacceptable coordinates - Select shot Coordinates again:\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                    }
                    boolean p1ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    while ((!p1ShotAvailablity) || ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9")))) {
                        System.out.print("\nSelected coordinates are not available for shot - Select another coordinates\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                        p1ShotAvailablity = battleShip.shotAvailablity(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    }
                    int tmp = battleShip.shot(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1, Integer.parseInt(shotStyleP1));
                    if (tmp == 1) {
                        p1SuccessfulShots++;
                        dontStop = 1;
                    } else
                        dontStop = 0;
                    if (battleShip.checkWin(1, p1SuccessfulShots)) {
                        System.out.println("****You won the game!****\n\n");
                        System.out.println("Your board:");
                        battleShip.getP1().getPlayerBoards().showPlayerBoard();
                        System.out.println("\nOpponet's board:");
                        battleShip.getP2().getPlayerBoards().showPlayerBoard();
                        System.out.println("\n##End of the Game##");
                        System.exit(0);
                    }
                    battleShip.getP1().getPlayerBoards().showOpponetBoard();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                battleShip.clearConsole();
                dontStop = 1;
                while (dontStop == 1) {
                    dontStop = 0;
                    int p2ShotX, p2ShotY;
                    p2ShotX = battleShip.randomCoordinates();
                    p2ShotY = battleShip.randomCoordinates();
                    boolean p2ShotAvailablity = battleShip.shotAvailablity(p2ShotY, p2ShotX, 2);
                    while (!p2ShotAvailablity) {
                        p2ShotX = battleShip.randomCoordinates();
                        p2ShotY = battleShip.randomCoordinates();
                        p2ShotAvailablity = battleShip.shotAvailablity(p2ShotY, p2ShotX, 2);
                    }
                    int tmp2 = battleShip.shot(p2ShotY, p2ShotX, 2, 1);
                    if (tmp2 == 1) {
                        dontStop = 1;
                        p2SuccessfulShots++;
                    } else
                        dontStop = 0;
                    if (battleShip.checkWin(2, p2SuccessfulShots)) {
                        System.out.println("****Opponet won the game!****\n\n");
                        System.out.println("Your board:");
                        battleShip.getP1().getPlayerBoards().showPlayerBoard();
                        System.out.println("\nOpponet's board:");
                        battleShip.getP2().getPlayerBoards().showPlayerBoard();
                        System.out.println("\n##End of the Game##");
                        System.exit(0);
                    }
                    battleShip.getP1().showPlayerBoard();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }


        }

    }
}
