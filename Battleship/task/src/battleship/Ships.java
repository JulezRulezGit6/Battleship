package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ships {
    String name;
    int cells;
    String[] coordinates;

    public Ships(String name, int size) {
        this.name = name;
        this.cells = size;
        coordinates = new String[size];
    }

    public static List<Ships> createNameOfShips() {
        List<Ships> ships = new ArrayList<>();
        ships.add(new Ships("Aircraft Carrier", 5));
        ships.add(new Ships("Battleship", 4));
        ships.add(new Ships("Submarine", 3));
        ships.add(new Ships("Cruiser", 3));
        ships.add(new Ships("Destroyer", 2));
        return ships;
    }

    public static void createShips(List<Ships> ships, String[][] matrix) {
        Scanner input = new Scanner(System.in);
        for (Ships elem : ships) {
            System.out.printf("\nEnter the coordinates of the %s (%d cells):\n\n", elem.getName(), elem.getCells());
            boolean end = true;
            while (end) {
                String[] coordinatesString = input.nextLine().toUpperCase().trim().split(" ");
                int[] coordinates = createCoordinates(coordinatesString);
                try {
                    if (checkLocation(coordinates)) {
                        throw new IllegalArgumentException("\nError! Wrong ship location! Try again:\n");
                    }
                    if (!checkSize(elem, coordinates)) {
                        throw new IllegalArgumentException(String.format("\nError! Wrong length of the %s! Try again:\n", elem.getName()));
                    }
                    if (!checkPlace(matrix, coordinates)) {
                        throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
                    }
                    fillShip(elem, coordinates);
                    Matrix.fillInMatrixFields(matrix, coordinates);
                    Matrix.showMatrix(matrix);
                    end = false;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }

    private static void fillShip(Ships ship, int[] coordinates) {
        int k = 0;
        for (int i = coordinates[0]; i <= coordinates[2]; i++) {
            for (int j = coordinates[1]; j <= coordinates[3]; j++) {
                ship.coordinates[k] = "" + i + j;
                k++;
            }
        }
    }

    private static boolean checkPlace(String[][] matrix, int[] coordinates) {
        int rowsNumber = matrix.length;
        int columnLength = matrix[0].length;

        int row1 = coordinates[0];
        int row2 = coordinates[2];
        int col1 = coordinates[1];
        int col2 = coordinates[3];


        int i = row1 == 0 ? 0 : row1 - 1;
        while (i <= row2 + 1 & i < rowsNumber) {
            int j = col1 == 0 ? 0 : col1 - 1;
            while (j <= col2 + 1 & j < columnLength) {
                if (!matrix[i][j].equals("~")) {
                    return false;
                }
                j++;
            }
            i++;
        }
        return true;

    }

    private static boolean checkSize(Ships ship, int[] coordinates) {
        int size;
        if (coordinates[0] != coordinates[2]) {
            size = coordinates[2] - coordinates[0] + 1;
        } else {
            size = coordinates[3] - coordinates[1] + 1;
        }
        return size == ship.getCells();
    }

    private static boolean checkLocation(int[] coordinates) {
        return coordinates[0] != coordinates[2] && coordinates[1] != coordinates[3];
    }

    private static int[] createCoordinates(String[] coordinatesString) {
        int[] coordinates = new int[4];
        coordinates[0] = coordinatesString[0].charAt(0) - 'A';
        coordinates[1] = Integer.parseInt(coordinatesString[0].substring(1)) - 1;
        coordinates[2] = coordinatesString[1].charAt(0) - 'A';
        coordinates[3] = Integer.parseInt(coordinatesString[1].substring(1)) - 1;

        if (coordinates[0] > coordinates[2]) {
            int temp = coordinates[0];
            coordinates[0] = coordinates[2];
            coordinates[2] = temp;
        }
        if (coordinates[1] > coordinates[3]) {
            int temp = coordinates[1];
            coordinates[1] = coordinates[3];
            coordinates[3] = temp;
        }

        return coordinates;
    }

    public static void shipHit(List<Ships> ships, int[] shotCoordinates) {
        String coString = "" + shotCoordinates[0] + shotCoordinates[1];
        for (Ships ship : ships) {
            for (String str : ship.coordinates) {
                if (coString.equals(str)) {
                    ship.setCells();
                    return;
                }

            }

        }

    }

    public static boolean isSank(List<Ships> ships) {
        for (Ships ship : ships) {
            if (ship.getCells() == 0) {
                ships.remove(ship);
                return true;
            }
        }
        return false;
    }

    private void setCells() {
        cells -= 1;
    }

    private String getName() {
        return name;
    }

    private int getCells() {
        return cells;
    }
}
