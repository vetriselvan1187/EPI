package String;

/**
 * Created by Vetriselvan on 02-01-2018.
 * 7.5 Test Palindromicity of String
 * Time Complexity O(n) and Space Complexity O(1)
 */
public class TestPalindromicity {
    public static void main(String[] args) {
        TestPalindromicity testPalindromicity = new TestPalindromicity();
        String s = "A man,a plan,a canal,Panama";
        System.out.println(testPalindromicity.isPlaindrome(s));
    }

    private boolean isPlaindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i <= j) {
            if(!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                ++i;
            } else if(!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                --j;
            }
            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
                return false;
        }
        return true;
    }
}
