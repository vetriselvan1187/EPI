package Heaps;

import java.util.*;

/**
 * Created by Vetriselvan on 30-12-2017.
 * Heaps - Time Complexity o(nlogk) - n is the number of input strings
 */
public class KLongestString {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Nikola Tesla");
        stringList.add("Ramanujan");
        stringList.add("Edison");
        stringList.add("Nikolas");
        stringList.add("Linus Torvalds");
        stringList.add("Linus Pauling");
        stringList.add("Tesla");
        KLongestString kLongestString = new KLongestString();
        List<String> topKNames = kLongestString.getTopK(3, stringList.iterator());
        for(String name : topKNames) {
            System.out.println(name);
        }
    }

    private List<String> getTopK(int k, Iterator<String> iter) {
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
                k, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        }
        );

        while(iter.hasNext()) {
            minHeap.add(iter.next());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<String>(minHeap);
    }
}
