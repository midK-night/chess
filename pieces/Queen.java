public class Queen extends base {
    public Queen (int height, int width, boolean isWhite) {
        super(false, height, width, "Q", isWhite);
    }

    public static void move(int dir, int increment) {
        /* 
        0 1 2
        3 K 4        
        5 6 7
        */
        switch (dir) {
            case 0:
                width += increment;
                height += increment;
                break;
            case 1:
                height += increment;
                break;
            case 2:
                width += increment;
                height += increment;
                break;
            case 3:
                width -= increment;
                break;
            case 4:
                width += increment;
                break;
            case 5:
                width -= increment;
                height -= increment;
                break;
            case 6:
                height -= increment;
                break;
            case 7:
                width += increment;
                height -= increment;
                break;
        }
    }
}