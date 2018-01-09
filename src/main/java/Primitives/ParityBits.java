package Primitives;

/**
 * Created by Vetriselvan on 19-12-2017.
 * Program to Check whether the number is parity or not
 */
public class ParityBits {
    public static void main(String[] args) {
        long number = 17;
        short result = 0;
        while(number != 0) {
            result ^= (number & 1);
            number >>>= 1;
        }
        System.out.println("parity ? "+result);
    }
}
