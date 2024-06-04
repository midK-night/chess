public class Rook extends base {
    public Rook (int height, int width, boolean isWhite) {
        super(false, height, width, "R", isWhite);
    }

    public static void moveVertical(int loc) {
        height = loc;
    }

    public static void moveHorizontal(int loc) [
        width = loc;
    ]
}