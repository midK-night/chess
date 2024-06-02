public class base {
    private boolean isCaptured;
    private int height;
    private int width;
    private String init;

    public base(isCaptured, height, width, init) {
        this.isCaptured = isCaptured;
        this.height = height;
        this.width = width;
        this.init = init;
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
}