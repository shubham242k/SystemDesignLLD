public class Knight extends Piece{
    Knight(PieceColor color, int row, int col) {
        super(color, row, col);
    }

    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(this.currentRow - destRow);
        int diffCol = Math.abs(this.currentCol - destCol);

        return (diffCol == 1 && diffRow == 2) || (diffCol == 2 && diffRow == 1);
    }
}