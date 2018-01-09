package Heaps;

import java.util.*;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 11.6 Compute the K Largest Element in Max Heap
 *
 */
public class KLargestElemetMaxHeap {
    private static class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        public int compare(HeapEntry o1, HeapEntry o2) {
            return o2.value-o1.value;
        }
        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 10, 100, 20, 30, 59, 65, 22);
        KLargestElemetMaxHeap kLargestElemetMaxHeap = new KLargestElemetMaxHeap();
        List<Integer> kLargest = kLargestElemetMaxHeap.kLargestInBinaryHeap(list, 5);
        for(Integer a : kLargest) {
            System.out.print(a+" ");
        }
    }

    private List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
        if(k <= 0) {
            return Collections.EMPTY_LIST;
        }
        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<HeapEntry>(DEFAULT_INITIAL_CAPACITY,
                new Comparator<HeapEntry>() {
                    public int compare(HeapEntry o1, HeapEntry o2) {
                        return o1.value-o2.value;
                    }
                });
        candidateMaxHeap.add(new HeapEntry(0, A.get(0)));
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < k; i++) {
            Integer candidateIdx = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);

            Integer leftChildIndex = 2 * candidateIdx + 1;
            if(leftChildIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(leftChildIndex, A.get(leftChildIndex)));
            }
            Integer rightChildIndex = 2 * candidateIdx + 2;
            if(rightChildIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(rightChildIndex, A.get(rightChildIndex)));
            }
        }
        return result;
    }

}
