package battleship;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Battle {
    static Scanner scanner = new Scanner(System.in);

    private void writeHit(String[][] foggyMatrix, int[] shotCoordinates, String symbol) {
        int row = shotCoordinates[0];
        int column = shotCoordinates[1];
        foggyMatrix[row][column] = symbol;

    }

    private String checkHit(String[][] matrix, List<Ship> ships, int[] shotCoordinates) {
        String symbol;
        int row = shotCoordinates[0];
        int column = shotCoordinates[1];
        if (matrix[row][column].equals("X")) {
            symbol = "X";
        } else if (matrix[row][column].equals("O")) {
            Ship.markShip(ships, shotCoordinates);
            matrix[row][column] = "X";
            symbol = "X";
        } else {
            matrix[row][column] = "M";
            symbol = "M";
        }
        return symbol;

    }


    public static void promptEnterKey() {
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void gameStart(Player player1, Player player2) {
        System.out.println();
        while (true) {
            Matrix.showBlurry(player2.matrix);
            System.out.println("---------------------");
            Matrix.showMatrix(player1.matrix);
            System.out.println("\nPlayer 1, it's your turn: ");
            int[] player1Coordinates = getShotCoordinates();
            String symbol1 = checkHit(player2.matrix, player2.ships, player1Coordinates);
            writeHit(player2.matrix, player1Coordinates, symbol1);
            if (printResult(player2, symbol1)) return;
            promptEnterKey();
            Matrix.showBlurry(player1.matrix);
            System.out.println("---------------------");
            Matrix.showMatrix(player2.matrix);
            System.out.println("\nPlayer 2, it's your turn: ");
            int[] player2Coordinates = getShotCoordinates();
            String symbol2 = checkHit(player1.matrix, player1.ships, player2Coordinates);
            writeHit(player1.matrix, player2Coordinates, symbol2);
            if (printResult(player1, symbol2)) return;
            promptEnterKey();
        }
    }

    private boolean printResult(Player player2, String symbol) {
        boolean down = Ship.isSank(player2.ships);
        if (player2.ships.size() != 0) {
            if (!down) {
                if (symbol.equals("X")) {
                    System.out.println("\nYou hit a ship!");
                } else {
                    System.out.println("\nYou missed!");
                }
            } else {
                System.out.println("\nYou sank a ship!");
            }

        } else {
            System.out.println("\nYou sank the last ship. You won. Congratulations!");
            return true;
        }
        return false;
    }

    private int[] getShotCoordinates() throws IllegalArgumentException {
        boolean outOfBounds = true;
        int[] shotCoordinates = new int[2];
        while (outOfBounds) {
            boolean shotIsEmpty = false;
            String shot = scanner.nextLine().toUpperCase().trim();
            if (!shot.isEmpty()) {
                shotCoordinates = createShotCoordinates(shot);
                if (coordinatesOutOfBounds(shotCoordinates)) {
                    System.out.println("\nError! You entered the wrong coordinates! Try again:");
                } else {
                    outOfBounds = false;
                }
            } else {
                System.out.println("\nError! You entered the wrong coordinates! Try again:");
            }
        }
        return shotCoordinates;
    }

    public static boolean coordinatesOutOfBounds(int[] shotCoordinates) {
            return shotCoordinates[0] < 0 || shotCoordinates[0] > 9
                    || shotCoordinates[1] < 0 || shotCoordinates[1] > 9;
    }

    private int[] createShotCoordinates(String shot) {
        int[] array = new int[2];
        try {
            array[0] = shot.charAt(0) - 65;
            array[1] = Integer.parseInt(shot.substring(1)) - 1;
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter VALID INPUT");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter something...");
        }
        return array;
    }
}


