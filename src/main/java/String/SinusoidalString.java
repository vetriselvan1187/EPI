package String;

/**
 * Created by Vetriselvan on 02-01-2018.
 * 7.11 String in Sinusoidal fashion
 *
 */
public class SinusoidalString {
    public static void main(String[] args) {
        String str = "Hello_World";
        SinusoidalString sinusoidalString = new SinusoidalString();
        String sinuString  = sinusoidalString.printStringInSinusoidal(str);
        System.out.println(sinuString);
    }

    private String printStringInSinusoidal(String s) {
        StringBuilder result = new StringBuilder();
        result.append(" ");
        for(int i=1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
            result.append("     ");
        }
        result.append("\n");
        for(int j=0; j < s.length(); j += 2) {
            result.append(s.charAt(j));
            result.append("  ");
        }
        result.append("\n");
        result.append("    ");
        for(int k=3; k < s.length(); k += 4) {
            result.append(s.charAt(k));
            result.append("     ");
        }
        return result.toString();
    }
}
