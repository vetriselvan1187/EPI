package String;

/**
 * Created by Vetriselvan on 26-12-2017.
 * 7.1 InterConvert String and Integer
 */
public class InterConvertStringInt {
    public static void main(String[] args) {
        String num = "-1243434";
        InterConvertStringInt interConvertStringInt = new InterConvertStringInt();
        int convertedToNum = interConvertStringInt.stringToInt(num);
        String convertedToStr = interConvertStringInt.intToString(convertedToNum);
        System.out.println(convertedToNum);
        System.out.println(convertedToStr);
    }

    private String intToString(int x) {
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }
        StringBuilder s = new StringBuilder();
        do {
            s.append((char)('0' + Math.abs(x % 10)));
            x /= 10;
        } while(x != 0);
        if(isNegative) {
            s.append('-');
        }
        s.reverse();
        return s.toString();
    }

    private int stringToInt(String s) {
        int result = 0;
        for(int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
}
