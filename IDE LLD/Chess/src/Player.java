public class Player {
    PieceColor color;
    Player(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return this.color;
    }

    public boolean makeMove(Board board, Move move) {
        int destRow = move.getRow();
        int destCol = move.getCol();
        Piece piece = move.getPiece();

        boolean isWithinBoard = board.isValidMove(piece, destRow, destCol);
        if(!isWithinBoard) return false;

        int sourceRow = piece.getCurrentRow();
        int sourceCol = piece.getCurrentCol();

        board.setPiece(sourceRow, sourceCol, null);
        board.setPiece(destRow, destCol, piece);
        piece.setCurrentRow(destRow);
        piece.setCurrentCol(destCol);

        return true;
    }
}
