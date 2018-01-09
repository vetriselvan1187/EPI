package Primitives;

/**
 * Created by Vetriselvan on 19-12-2017.
 * Program to check the given number is palindrome or not
 */
public class PalindromicNumber {
    public static void main(String[] args) {
       long x = 141;
       final int numDigits = (int) (Math.floor(Math.log10(x))+1);
       System.out.println("numDigits "+numDigits);
       int msdMask = (int)Math.pow(10, numDigits - 1);
       System.out.println(msdMask);
       for (int i=0; i < numDigits / 2; ++i) {
           if(x/msdMask != x % 10) {
               System.out.println("false");
           }
           x %= msdMask;
           x /= 10;
           msdMask /= 100;
       }
       System.out.println("true");
    }
}
