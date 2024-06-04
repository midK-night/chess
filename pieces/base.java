public class base {
    private boolean isCaptured;
    private int height;
    private int width;
    private String init;
    private boolean isWhite;

    public base(boolean isCaptured, int height, int width, String init, boolean isWhite) {
        this.isCaptured = isCaptured;
        this.height = height;
        this.width = width;
        this.init = init;
        this.isWhite = isWhite;
    }

    public static boolean getCaptured() {
        return isCaptured;
    }

    public static void wasCaptured() {
        isCaptured = true;
    }

    public static int[] returnPos() {
        return [width, height];
    }

    public static String getInit() {
        return init;
    }

    public static boolean checkLoc(gameboard GM, int[] loc) {
        boolean isEmptyPiece = GM.chessboard[loc[0]][loc[1]].equals("#");
        return (!isEmptyPiece);
    }
}