public class Knight extends base {
    public Knight (int height, int width) {
        super(false, height, width, "N");
    }

    public static void move(int dir) {
        /*
         0 1
        2   3
          N 
        4   5
         6 7
        */

        switch (dir) {
            case 0:
                height += 2;
                width--;
                break;
            case 1:
                height += 2;
                width++;
                break;
            case 2:
                height ++;
                width -= 2;
                break;
            case 3:
                height ++;
                width += 2;
                break;
            case 4:
                height --;
                width -= 2;
                break;
            case 5:
                height --;
                width += 2;
                break;
            case 6:
                height -= 2;
                width --;
                break;
            case 7:
                height -= 2;
                width ++;
                break;
        }
    }
}