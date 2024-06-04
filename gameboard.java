import pieces;
import java.util.ArrayList;


public class gameboard {
    private static ArrayList<base> whitePieces;
    private static ArrayList<base> blackPieces;
    private static boolean isPVP;
    public static String[][] chessboard;

    public gameboard(boolean isPVP) {
        this.isPVP = isPVP;
        chessboard = new String[8][8];
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(i, 1));
            blackPieces.add(new Pawn(i, 6));
        }
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