public class Pawn extends base {

    public Pawn (int height, int width, boolean isWhite) {
        super(false, height, width, "P", isWhite);
    }

    public static void moveForward() {
        height++;
    }

    public static void capture(boolean isLeft) {
        if (isLeft & width != 1) {
            width--;
        } else if (width != 8) {
            width++;
        }
        height++;
    }

    
}