package Honor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by Vetriselvan on 09-01-2018.
 * 25.20 Find Shortest Unique Prefix
 * Time Complexity O(D|L)
 */
public class ShortestUniquePrefix {
    public static class Trie {
        private static class TrieNode {
            private boolean isString = false;
            private Map<Character, TrieNode> leaves = new HashMap<Character, TrieNode>();
            public void setIsString(boolean isendOfString) {
                isString = isendOfString;
            }
            public boolean getIsString() {
                return isString;
            }

            public Map<Character, TrieNode> getLeaves() {
                return this.leaves;
            }
        }

        TrieNode root = new TrieNode();

        public boolean insert(String s) {
            TrieNode p  = root;
            for(int i=0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!p.getLeaves().containsKey(c)) {
                    p.getLeaves().put(c, new TrieNode());
                }
                p = p.getLeaves().get(c);
            }

            if(p.getIsString()) {
                return false;
            } else {
                p.setIsString(true);
                return true;
            }
        }

        public String getShortestUniquePrefix(String s) {
            TrieNode p = root;
            StringBuilder prefix = new StringBuilder();
            for(int i=0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!p.getLeaves().containsKey(c)) {
                    return prefix.toString();
                }
                prefix.append(c);
                p = p.getLeaves().get(c);
            }
            return "";
        }
    }

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet();
        stringSet.add("Vetriselvan");
        stringSet.add("Vetri");
        stringSet.add("Vernon");
        stringSet.add("Veskar");
        stringSet.add("Vedinger");
        stringSet.add("Vegitaov");

        Trie trie = new Trie();
        for(String s : stringSet) {
            trie.insert(s);
        }
        System.out.println(trie.getShortestUniquePrefix("Veki"));
    }
}
