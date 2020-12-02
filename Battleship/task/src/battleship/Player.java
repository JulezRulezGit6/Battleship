package battleship;

import java.util.List;

public class Player {

    static int count = 1;
    String name;
    String[][] matrix;
    List<Ship> ships;

    public Player() {
        name = "Player" + count;
        matrix = Matrix.createMatrix();
        ships = Ship.createNameOfShips();
        count++;
    }

    public static void setCount(int count) {
        Player.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void placeShipsOnMatrix() {
        this.matrix = new String[][]{
                {"O", "O", "O", "O", "O", "~", "~", "~", "~", "~"},
                {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"O", "O", "O", "O", "~", "~", "~", "~", "~", "~"},
                {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"O", "O", "O", "~", "~", "~", "~", "~", "~", "~"},
                {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"O", "O", "O", "~", "~", "~", "~", "~", "~", "~"},
                {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"O", "O", "~", "~", "~", "~", "~", "~", "~", "~"},
                {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
        };
    }

    public void fillListOfShips() {
        this.ships.get(0).setCoordinates(new String[]{"00", "01", "02", "03", "04"});
        this.ships.get(1).setCoordinates(new String[]{"20", "21", "22", "23"});
        this.ships.get(2).setCoordinates(new String[]{"40", "41", "42"});
        this.ships.get(3).setCoordinates(new String[]{"60", "61", "62"});
        this.ships.get(4).setCoordinates(new String[]{"80", "81"});
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
