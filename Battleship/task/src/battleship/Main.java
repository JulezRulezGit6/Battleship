package battleship;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player();
        System.out.println("Player 1, place your ships on the game field");
        Matrix.showBlurry(player1.matrix);
        Ship.createShips(player1.ships, player1.matrix);
//        player1.fillListOfShips();
//        player1.placeShipsOnMatrix();
        Battle.promptEnterKey();

        Player player2 = new Player();
        System.out.println("Player 2, place your ships on the game field");
        Matrix.showBlurry(player2.matrix);
        Ship.createShips(player2.ships, player2.matrix);
//        player2.fillListOfShips();
//        player2.placeShipsOnMatrix();
        Battle.promptEnterKey();
        Battle battle = new Battle();
        battle.gameStart(player1, player2);

    }
}
