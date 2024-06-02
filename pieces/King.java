public class King extends base {
    public King (int height, int width) {
        super(false, height, width, "K");
    }

    public static move(int dir) {
        /* 
        0 1 2
        3 K 4        
        5 6 7
        */
        switch (dir) {
            case 0:
                width--;
                height++;
                break;
            case 1:
                height++;
                break;
            case 2:
                width++;
                height++;
                break;
            case 3:
                width--;
                break;
            case 4:
                width++;
                break;
            case 5:
                width--;
                height--;
                break;
            case 6:
                height--;
                break;
            case 7:
                width++;
                height--;
                break;
        }
    }
}