package String;

/**
 * Created by Vetriselvan on 02-01-2018.
 * 7.4 Replace and Remove
 * Replace each 'a' by two 'd'
 * Delete each entry containing a 'b'
 * Time Complexity O(n) + O(n) = O(n)
 */
public class ReplaceAndRemove {
    public static void main(String[] args) {
        String str = "acdbbca";
        char[] s = str.toCharArray();
        ReplaceAndRemove replaceAndRemove = new ReplaceAndRemove();
        replaceAndRemove.replaceRemove(s.length, s);
        for(char c : s) {
            System.out.print(c);
        }
    }

    private int replaceRemove(int size, char[] s) {
        int writeIndex = 0, aCount = 0;
        for(int i=0; i < size; i++) {
            if(s[i] != 'b') {
                s[writeIndex++] = s[i];
            }
            if(s[i] == 'a') {
                ++aCount;
            }
        }

        int currIndex = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        final int finalSize = writeIndex + 1;

        while(currIndex >= 0) {
            if(s[currIndex] == 'a') {
                s[writeIndex--] = 'd';
                s[writeIndex--] = 'd';
            } else {
                s[writeIndex--] = s[currIndex];
            }
            currIndex--;
        }

        System.out.println(new String(s));
        return finalSize;
    }
}
