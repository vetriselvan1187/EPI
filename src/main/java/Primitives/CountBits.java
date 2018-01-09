package Primitives;

/**
 * Created by Vetriselvan on 19-12-2017.
 * Program to Count the number of 1 Bits in Integer
 *
 */
public class CountBits {
    public static void main(String[] args) {
        short numOfBits = 0;
        Integer number = 55;
        while(number != 0) {
            numOfBits += (number & 1);
            number >>>= 1;
        }
        System.out.println("number of set bits = "+numOfBits);
    }
}
