import pieces;
import java.util.ArrayList;


public class gameboard {
    private static ArrayList<base> whitePieces;
    private static ArrayList<base> blackPieces;
    private static boolean isPVP;

    public static String[][] chessboard;
    public static int[][] isBlackSquares;

    public gameboard(boolean isPVP) {
        this.isPVP = isPVP;
        isBlackSquares = new int[8][8];
        for (int i = 0; i < 8; i += 2) {
            for (int i = 0; i < 8; i += 2) {
                isBlackSquares[i][i] = true;
            } // even squares - 0 2 4 6
            for (int i = 1; i < 8; i += 2) {
                isBlackSquares[i + 1][i] = true;
            } // odd squares - 1 3 5 7
        }

        // add all pawns
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(i, 1));
            blackPieces.add(new Pawn(i, 6));
        } 
        //add all knights
        whitePieces.add(new Knight(0, 1));
        whitePieces.add(new Knight(0, 6));
        blackPieces.add(new Knight(7, 1));
        blackPieces.add(new Knight(7, 6));
        //add all rooks
        whitePieces.add(new Rook(0, 0));
        whitePieces.add(new Rook(0, 7));
        blackPieces.add(new Rook(7, 0));
        blackPieces.add(new Rook(7, 7));
        //add all bishops
        whitePieces.add(new Bishop(0, 2, false));
        whitePieces.add(new Bishop(0, 5, true));
        blackPieces.add(new Bishop(7, 2, true));
        blackPieces.add(new Bishop(7, 5, false));
        // add kings and queens
        whitePieces.add(new King(0, 4));
        whitePieces.add(new Queen(0, 3));
        blackPieces.add(new King(7, 3));
        blackPieces.add(new Queen(7, 4));

        chessboardUpdate();
    }

    public static void chessboardUpdate() {
        String[][] tempChessboard = new String[8][8];
        for (String[] row : tempChessboard) {
            for (String box : row) {
                box = "#";
            }
        } // reset to #
        for (base i : whitePieces) {
            int[] pos = i.returnPos();
            if (!i.getCaptured()) {
                tempChessboard[pos[0]][pos[1]] = i.getInit();
            }
        } // set white pieces
        for (base i : blackPieces) {
            int[] pos = i.returnPos();
            if (!i.getCaptured()) {
                tempChessboard[pos[0]][pos[1]] = i.getInit();
            }
        } // set black pieces
        chessboard = tempChessboard;
    }
}