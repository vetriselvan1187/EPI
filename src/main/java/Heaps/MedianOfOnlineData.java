package Heaps;

import java.util.*;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 11.5 Compute the median of online data
 * Tome Complexity is o(logn)
 */
public class MedianOfOnlineData {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(1);
        listOfNumbers.add(0);
        listOfNumbers.add(3);
        listOfNumbers.add(5);
        listOfNumbers.add(2);
        listOfNumbers.add(0);
        listOfNumbers.add(1);
        listOfNumbers.add(2);
        MedianOfOnlineData medianOfOnlineData = new MedianOfOnlineData();
        medianOfOnlineData.onlineMedian(listOfNumbers.iterator());
    }

    private void onlineMedian(Iterator<Integer> iters) {
        PriorityQueue<Integer>  minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());

        while(iters.hasNext()) {
            Integer x = iters.next();
            if(minHeap.isEmpty()) {
                minHeap.add(x);
            } else {
                if(x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            } else {
                minHeap.add(maxHeap.remove());
            }
        }
        System.out.println(minHeap.size() == maxHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : minHeap.peek());
    }
}
