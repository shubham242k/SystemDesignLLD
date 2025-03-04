public class Rook extends Piece {
    Rook(PieceColor color, int row, int col) {
        super(color, row, col);
    }

    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(this.currentRow - destRow);
        int diffCol = Math.abs(this.currentCol - destCol);

        int rowIncrement = 0, colIncrement = 0;
        if(diffCol == 0) {
            if(destRow > this.currentRow) rowIncrement = 1;
            else rowIncrement = -1;
        } else if(diffRow == 0) {
            if(destCol > this.currentCol) colIncrement = 1;
            else colIncrement = -1;
        } else {
            return false;
        }

        return anyPieceBetweenDestination(board, destRow, destCol, rowIncrement, colIncrement);
    }
}
