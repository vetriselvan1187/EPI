package HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vetriselvan on 25-12-2017.
 * 13.1 Test for Palindromic Permuations
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "edified";
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        System.out.println(palindromeCheck.canFormPalindrome(str));
    }

    private boolean canFormPalindrome(String s) {
        Map<Character, Integer> charFrquencies = new HashMap<Character, Integer>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!charFrquencies.containsKey(c)) {
                charFrquencies.put(c, 1);
            } else {
                charFrquencies.put(c, charFrquencies.get(c) + 1);
            }
        }

        int oddCount = 0;
        for(Map.Entry<Character, Integer> p : charFrquencies.entrySet()) {
            if((p.getValue() % 2) != 0 && ++oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}
