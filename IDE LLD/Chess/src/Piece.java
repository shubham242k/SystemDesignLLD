public abstract class Piece {
    PieceColor color;
    int currentRow;
    int currentCol;

    Piece(PieceColor color, int row, int col) {
        this.color = color;
        this.currentRow = row;
        this.currentCol = col;
    }

    public void setCurrentRow(final int currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentCol(final int currentCol) {
        this.currentCol = currentCol;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }

    public int getCurrentCol() {
        return this.currentCol;
    }

    public PieceColor getColor(){
        return this.color;
    }

    public abstract boolean canMove(Board board, int destRow, int destCol);

    public boolean anyPieceBetweenDestination(Board board, int destRow, int destCol, int rowInc, int colInc) {
        for(int i = this.currentRow, j = this.currentCol; i <= destRow && j <= destCol; i += rowInc, j += colInc) {
            Piece peiceAtLocation = board.getPiece(i, j);
            if(peiceAtLocation != null) return false;
        }
        return true;
    }
}
