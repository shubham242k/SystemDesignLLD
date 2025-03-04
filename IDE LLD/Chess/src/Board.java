public class Board {
    private Piece[][] board;

    Board() {
        board = new Piece[8][8];
        initialize();
    }

    private void initialize() {
        // Initialize white pieces
        board[0][0] = new Rook(PieceColor.WHITE, 0, 0);
        board[0][1] = new Knight(PieceColor.WHITE, 0, 1);
        board[0][2] = new Bishop(PieceColor.WHITE, 0, 2);
        board[0][3] = new Queen(PieceColor.WHITE, 0, 3);
        board[0][4] = new King(PieceColor.WHITE, 0, 4);
        board[0][5] = new Bishop(PieceColor.WHITE, 0, 5);
        board[0][6] = new Knight(PieceColor.WHITE, 0, 6);
        board[0][7] = new Rook(PieceColor.WHITE, 0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(PieceColor.WHITE, 1, i);
        }

        // Initialize black pieces
        board[7][0] = new Rook(PieceColor.BLACK, 7, 0);
        board[7][1] = new Knight(PieceColor.BLACK, 7, 1);
        board[7][2] = new Bishop(PieceColor.BLACK, 7, 2);
        board[7][3] = new King(PieceColor.BLACK, 7, 3);
        board[7][4] = new Queen(PieceColor.BLACK, 7, 4);
        board[7][5] = new Bishop(PieceColor.BLACK, 7, 5);
        board[7][6] = new Knight(PieceColor.BLACK, 7, 6);
        board[7][7] = new Rook(PieceColor.BLACK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(PieceColor.BLACK, 6, i);
        }
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isValidMove(Piece piece, int destRow, int destCol) {
        if (destRow >= 0 && destRow <= 7 && destCol >= 0 && destCol <= 8) {
            Piece destPiece = board[destRow][destCol];
            return (destPiece == null || destPiece.getColor() != piece.getColor()) &&
                    piece.canMove(this, destRow, destCol);
        }

        return false;
    }

    public void boardToString() {
        for(int i = 0 ; i < 8 ; i++) {
            for(int j = 0 ; j < 8 ; j++) {
                System.out.print(this.getPiece(i, j) + " ");
            }
            System.out.println();
        }
    }

}
