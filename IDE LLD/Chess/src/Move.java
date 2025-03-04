public class Move {
    private Piece piece;
    private int row;
    private int col;
    Move(Piece piece, int row, int col) {
        this.piece = piece;
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public Piece getPiece() {
        return this.piece;
    }
}
