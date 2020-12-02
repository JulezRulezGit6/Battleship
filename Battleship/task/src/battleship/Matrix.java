package battleship;

import java.util.Arrays;
import java.util.stream.IntStream;

import static battleship.Constants.FOG_SYMBOL;
import static battleship.Constants.MATRIX_LENGTH;

public class Matrix {

    public static String[][] createMatrix() {

        String[][] matrix = new String[MATRIX_LENGTH][MATRIX_LENGTH];
        IntStream.range(0, MATRIX_LENGTH).forEach(i -> Arrays.fill(matrix[i], FOG_SYMBOL));
        return matrix;

    }

    public static void showMatrix(String[][] matrix) {
        char startRow = 'A';
        int startCol = 1;
        System.out.print("\n  ");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(startCol + " ");
            startCol++;
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print((char) (startRow + i) + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void showBlurry(String[][] matrix) {
        char startRow = 'A';
        int startCol = 1;
        System.out.print("\n  ");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(startCol + " ");
            startCol++;
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print((char) (startRow + i) + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("O")) {
                    System.out.print("~ ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void fillInMatrixFields(String[][] matrix, int[] coordinates) {
        for (int i = coordinates[0]; i <= coordinates[2]; i++) {
            for (int j = coordinates[1]; j <= coordinates[3]; j++) {
                matrix[i][j] = "O";
            }
        }
    }
}

