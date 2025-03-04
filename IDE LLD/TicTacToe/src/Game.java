import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Player1 name");
        String name1 = myObj.nextLine();
        System.out.println("Enter Player2 name");
        String name2 = myObj.nextLine();
        Player player1 = new Player(name1, Symbol.O);
        Player player2 = new Player(name2, Symbol.X);

        System.out.println("Players ------");
        System.out.println("Player1 " + player1.getName() + " with symbol " + player1.getSymbol().getSymbol());
        System.out.println("Player2 " + player2.getName() + " with symbol " + player2.getSymbol().getSymbol());
        System.out.println("------------------------------");

        Queue<Player> players = new ArrayDeque<>();
        players.add(player1);
        players.add(player2);
        boolean gameContinue = true;
        while(gameContinue) {
            Player currentPlayer = players.remove();
            board.displayBoard();
            System.out.println(currentPlayer.getName() + ", Make move. Type row and col. eg: 0 2");
            String[] input = myObj.nextLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            boolean legal = board.makeMove(currentPlayer, row, col);
            if(legal == false) {
                players.add(currentPlayer);
                players.add(players.remove());
            } else {
                players.add(currentPlayer);
                gameContinue = board.continueTheGame(currentPlayer, row, col);
            }
            System.out.println("-------------------------");
        }
    }
}
