import java.util.*;

public class Chessboard {
    private Piece[][] chessboard;
    private ArrayList<Piece> black;
    private ArrayList<Piece> white;

    public Chessboard () {
        chessboard = new Piece[8][8];
        black = new ArrayList<Piece>();
        white = new ArrayList<Piece>();
        init();
    }

    public void update() {
        Piece[][] tempBoard = new Piece[8][8];
        for (Piece temp : black) {
            int x = convert(temp.getCoords().getX());
            int y = convert(temp.getCoords().getY());
            tempBoard[x][y] = temp;
        }
        for (Piece temp : white) {
            int x = convert(temp.getCoords().getX());
            int y = convert(temp.getCoords().getY());
            tempBoard[x][y] = temp;
        }
        chessboard = tempBoard;
    }

    private void init() {
        white.add(new Rook(1, 1, true));
        white.add(new Rook(8, 1, true));
        white.add(new Knight(2, 1, true));
        white.add(new Knight(7, 1, true));
        white.add(new Bishop(3, 1, true));
        white.add(new Bishop(6, 1, true));
        white.add(new Queen(4, 1, true));
        white.add(new King(5, 1, true));
        for (int i = 1; i < 9; i++) {
            white.add(new Pawn(i, 2, true));
        }
        black.add(new Rook(1, 8, false));
        black.add(new Rook(8, 8, false));
        black.add(new Knight(2, 8, false));
        black.add(new Knight(7, 8, false));
        black.add(new Bishop(3, 8, false));
        black.add(new Bishop(6, 8, false));
        black.add(new Queen(4, 8, false));
        black.add(new King(5, 8, false));
        for (int i = 1; i < 9; i++) {
            black.add(new Pawn(i, 7, false));
        }
        update();
    }
    
    public static int convert(int val) {
        return 9 - val - 1;
    }
    
    public Piece[][] getBoard() {
        return chessboard;
    }
}