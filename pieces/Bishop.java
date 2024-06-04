public class Bishop extends base {
    public boolean isWhite;

    public Bishop (int height, int width, boolean isWhite) {
        super(false, height, width, "B", isWhite);
    }

    public static void moveUp(int increment) {
        /*
        -4           4
          -3        3
            -2     2
              -1  1
                B
        */
       height += Math.abs(increment);
       width += increment;
    }

    public static void moveDown(int increment) {
        /*
                B
              -1  1
            -2     2
          -3        3
        -4           4
        */
        height -= Math.abs(increment);
        width += increment;
    }

    public static boolean checkMovement(int[] goal) {

    }
}