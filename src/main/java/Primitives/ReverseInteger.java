package Primitives;

/**
 * Created by Vetriselvan on 19-12-2017.
 * Program to Reverse an Integer
 * Time Complexity is O(n) where the n is the number of digits
 */
public class ReverseInteger {
    public static void main(String[] args) {
        long result = 0;
        long number = -142;
        long xRemaining = Math.abs(number);
        while(xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining /= 10;
        }
        System.out.println("reversed integer "+(number < 0 ? -result : result));
    }
}
