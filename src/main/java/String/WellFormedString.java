package String;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by Vetriselvan on 03-01-2018.
 * 9.3 Test String Over Well Formedness
 *  Time Complexity O(n) and Space Complexity O(1)
 */
public class WellFormedString {
    public static void main(String[] args) {
        String wellFormed = "[()[]{()()}]";
        String notWellFormed = "[()[]{()()";

        WellFormedString wellFormedString = new WellFormedString();
        System.out.println(wellFormedString.isWellFormed(wellFormed));
        System.out.println(wellFormedString.isWellFormed(notWellFormed));
    }

    private boolean isWellFormed(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.addFirst(s.charAt(i));
            } else {
                if(stack.isEmpty())
                    return false;
                if((s.charAt(i)==')' && stack.peek()!='(') ||
                        (s.charAt(i) == ']' && stack.peek() != '[') ||
                        (s.charAt(i) == '}' && stack.peek() != '{')) {
                    return false;
                }
                stack.removeFirst();
            }
        }
        return stack.isEmpty();
    }
}
