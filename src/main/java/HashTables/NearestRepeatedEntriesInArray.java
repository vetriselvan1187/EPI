package HashTables;


import java.util.Map;
import java.util.HashMap;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 13.6 Find the nearest repeated entries in array
 *  Time Complexity o(n) Space Complexity o(d) where d is the number of distinct entries
 */

public class NearestRepeatedEntriesInArray {
    public static void main(String[] args) {
        String[] repeatedEntries = { "All", "work", "and", "no", "play", "makes", "for", "no", "work", "no"
                                , "fun", "and", "no", "results" };

        NearestRepeatedEntriesInArray nearestRepeatedEntriesInArray = new NearestRepeatedEntriesInArray();
        System.out.println(nearestRepeatedEntriesInArray.nearestRepeatedDistance(repeatedEntries));
    }

    private int nearestRepeatedDistance(String[] repeatedEntries) {
        Map<String, Integer> wordToLatestIndex = new HashMap<String, Integer>();
        int nearestRepeatedDistance = Integer.MAX_VALUE;
        for(int i=0; i < repeatedEntries.length; i++) {
            if(wordToLatestIndex.containsKey(repeatedEntries[i])) {
                nearestRepeatedDistance = Math.min(nearestRepeatedDistance, i-wordToLatestIndex.get(repeatedEntries[i]));
            }
            wordToLatestIndex.put(repeatedEntries[i], i);
        }
        return nearestRepeatedDistance;
    }
}
