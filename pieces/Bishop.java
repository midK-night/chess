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

    public static boolean move(int[] goal, gameboard GM) {
        if (goal[0] == width || goal[1] == height) {
            return false;
        } // if same dimensions

        if ((goal[0] < 0 || goal[0] > 7) || (goal[1] < 0 || goal[1] > 7)) {
            return false;
        } // if goal not in bounds

        if (!isWhite != GM.isBlackSquares[goal[0]][goal[1]]) {
            return false;
        } // if not same color, make it no work

        if (Math.abs(goal[0] - width) != Math.abs(goal[1] - height)) {
            return false;
        } // if not in diagonal

        int dir = 0; // 1 - top right, 2 - top left, 3 - bottom right, 4 - bottom left
        if ((goal[0] - width > 0) && (goal[1] - height > 0)) {
            dir = 1;
        } else if ((goal[0] - width < 0) && (goal[1] - height > 0)) {
            dir = 2;
        } else if ((goal[0] - width > 0) && (goal[1] - height < 0)) {
            dir = 3;
        } else if ((goal[0] - width < 0) && (goal[1] - height < 0)) {
            dir = 4;
        } else {
            return false;
        } // error occured

        for (int i = 0; i < Math.abs(goal[0] - width); i++) {
            switch (dir) {
                case 1:
                    checkLoc(GM, {})
            }
        }
    }

    public static boolean checkMovement(int[] goal) {

    }
}