public class King extends Piece{
    King(PieceColor color, int row, int col) {
        super(color, row, col);
    }

    public boolean canMove(Board board, int destRow, int destCol) {
        int diffRow = Math.abs(this.currentRow - destRow);
        int diffCol = Math.abs(this.currentCol - destCol);

        return (diffCol <= 1 && diffRow <= 1);
    }
}
