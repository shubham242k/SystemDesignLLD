public class Pawn extends Piece {
    Pawn(PieceColor color, int row, int col) {
        super(color, row, col);
    }

    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = destRow - this.currentRow;
        int colDiff = Math.abs(destCol - this.currentCol);

        if (color == PieceColor.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (this.currentRow == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && board.getPiece(destRow, destCol) != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (this.currentRow == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && board.getPiece(destRow, destCol) != null);
        }
    }
}
