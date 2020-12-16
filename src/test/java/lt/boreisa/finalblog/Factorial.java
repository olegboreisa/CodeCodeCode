package lt.boreisa.finalblog;

/**
 * If you do not know what to do, use [IF] - EASIEST WAY
 */
public class Factorial {
    public static int factorial(int param) {
//        if (param == 5) {
//            return 120;
//        }
//        if (param == 3) {
//            return 6;
//        }
//        return param;
//    }
        if (param < 0) {
            throw new IllegalArgumentException();
        }
        if (param == 0) {
            return 1;
        }
        int x = param;

        for (int i = 1; i < param; i++) {
            x *= i;
        }
        return x;
    }
}
