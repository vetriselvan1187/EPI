package String;

/**
 * Created by Vetriselvan on 02-01-2018.
 * 7.8 Look And Say
 *
 */
public class LookAndSay {
    public static void main(String[] args) {
        LookAndSay lookAndSay = new LookAndSay();
        System.out.println(lookAndSay.lookAndSay(10));
    }

    private String lookAndSay(int n) {
        String s = "1";
        for(int i=0; i < n; i++) {
            s = nextNumber(s);
        }
        return s;
    }

    private String nextNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length(); i++) {
            int count = 1;
            while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                ++i;
                ++count;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
