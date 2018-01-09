package Honor;

/**
 * Created by Vetriselvan on 25-12-2017.
 *
 */
public class GCD {
    public static void main(String[] args) {
        long x = 24;
        long y = 300;
        GCD gcd = new GCD();
        System.out.println(gcd.getGCD(24, 300));
    }

    private long getGCD(long x, long y) {
        if(x == y) {
            return x;
        } else if((x & 1) == 0 && (y & 1) == 0) {
            return getGCD(x >>> 1, y >>> 1) << 1;
        } else if((x & 1) == 0 && (y & 1) != 0) {
            return getGCD(x >>> 1, y);
        } else if((x & 1) != 0 && (y & 1) == 0) {
            return getGCD(x, y >>> 1);
        } else if(x > y) {
            return getGCD(x-y, y);
        }
        return getGCD(x, y-x);
    }
}
