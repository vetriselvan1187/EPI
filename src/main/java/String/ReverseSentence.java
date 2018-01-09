package String;

/**
 * Created by Vetriselvan on 26-12-2017.
 * 7.6 Reverse all words in Sentence
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String sentence = "Nikola Tesla is a genius";
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.reverseSentence(sentence.toCharArray()));
    }

    private String reverseSentence(char[] sentence) {
        char[] reversed = reverseString(sentence, 0, sentence.length-1);
        System.out.println(new String(reversed));
        int j = 0;
        for(int i=0; i < reversed.length; i++) {
            if(reversed[i] == ' ') {
                reverseString(reversed, j, i-1);
                j = i + 1;
            }
        }
        reverseString(reversed, j, reversed.length-1);
        return new String(reversed);
    }

    private char[] reverseString(char[] charSeq, int from, int to) {

        while(from < to) {
            char temp = charSeq[from];
            charSeq[from++] = charSeq[to];
            charSeq[to--] = temp;
        }
        return charSeq;
    }
}
