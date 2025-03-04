public class Board {
    char[][] board;
    Board() {
        board = new char[3][3];
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(Player player, int row, int col) {
        if(row >=3 || col >= 3 || row < 0 || col < 0 || board[row][col] != ' ') {
            System.out.print("ILLEGAL MOVE - ");
            System.out.println("Player:  "+ player.getName() + " cant place symbol: " + player.getSymbol().val + " at " + row  + ", " + col);
            return false;
        } else {
            System.out.println("Player:  "+ player.getName() + " placed symbol: " + player.getSymbol().val + " at " + row  + ", " + col);
            board[row][col] = player.getSymbol().getSymbol();
            return true;
        }
    }

    public boolean continueTheGame(Player player, int row , int col) {
        if(checkRow(row, player.getSymbol().getSymbol()) ||
                checkCol(col, player.getSymbol().getSymbol()) ||
                checkLeftDiagnol(player.getSymbol().getSymbol()) ||
                checkRightDiagnol(player.getSymbol().getSymbol())) {
            wonBy(player);
            return false;
        }

        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                if(board[i][j] == ' ') return true;
            }
        }

        System.out.println("Match draw");
        return false;
    }

    public void displayBoard() {
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
    public void wonBy(Player player) {
        System.out.println("Game won by player: " + player.getName());
    }

    private boolean checkRow(int row, char symbol) {
        boolean flag = true;
        for(int j = 0 ; j < 3 ; j++) {
            if(board[row][j] != symbol) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkCol(int col, char symbol) {
        boolean flag = true;
        for(int j = 0 ; j < 3 ; j++) {
            if(board[j][col] != symbol) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkLeftDiagnol(char symbol) {
        boolean flag = true;
        for(int i = 0, j = 0 ; i < 3 ; i++, j++) {
            if(board[j][i] != symbol) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkRightDiagnol(char symbol) {
        boolean flag = true;
        for(int i = 0, j = 2 ; i < 3 ; i++, j--) {
            if(board[j][i] != symbol) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
