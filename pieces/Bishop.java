public class Bishop extends base {
    public Bishop (int height, int width) {
        super(false, height, width, "B");
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
}