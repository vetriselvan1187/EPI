package HashTables;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 13.2 Anonymous Letter
 */

public class AnonymousLetter {
    public static void main(String[] args) {
        String letterText = "nikolatesla";
        String magazineText = "nikola tesla is a genius";
        AnonymousLetter anonymousLetter = new AnonymousLetter();
        System.out.println(anonymousLetter.isLetterConstructible(letterText, magazineText));
    }

    private boolean isLetterConstructible(String letterText, String magazineText) {
        Map<Character, Integer> letterFrequencyMap = new HashMap<Character, Integer>();
        for(int i=0; i < letterText.length(); i++) {
            char c = letterText.charAt(i);
            if(!letterFrequencyMap.containsKey(c)) {
                letterFrequencyMap.put(c, 1);
            } else {
                letterFrequencyMap.put(c, letterFrequencyMap.get(c) + 1);
            }
        }

        for(char ch : magazineText.toCharArray()) {
            if(letterFrequencyMap.containsKey(ch)) {
                letterFrequencyMap.put(ch, letterFrequencyMap.get(ch)-1);
                if(letterFrequencyMap.get(ch) == 0) {
                    letterFrequencyMap.remove(ch);
                }
                if(letterFrequencyMap.isEmpty())
                    break;
            }
        }
        return letterFrequencyMap.isEmpty();
    }
 }
