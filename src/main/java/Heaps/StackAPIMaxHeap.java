package Heaps;

import javax.xml.bind.ValidationEvent;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 11.7 Implement Stack using Max Heap
 *
 */
public class StackAPIMaxHeap {

    private static class ValueWithRank {
        public Integer value;
        public Integer rank;

        public ValueWithRank(Integer value, Integer rank) {
            this.value = value;
            this.rank = rank;
        }
    }

    private static class Compare implements Comparator<ValueWithRank> {
        public int compare(ValueWithRank v1, ValueWithRank v2) {
            //return Integer.compare(v1.value, v2.value);
            if(v1.value > v2.value)
                return -1;
            else if(v1.value < v2.value)
                return 1;
            else
                return 0;
        }
        public static final Compare COMPARE_VALUEWITHRANK = new Compare();
    }

    private static int DEFAULT_INITIAL_CAPACITY = 16;

    static class Stack {
        private int timestamp = 0;
        private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<ValueWithRank>(DEFAULT_INITIAL_CAPACITY,
                Compare.COMPARE_VALUEWITHRANK);

        public void push(Integer x) {
            maxHeap.add(new ValueWithRank(x, ++timestamp));
        }

        public Integer pop() throws NoSuchElementException {
            return maxHeap.remove().value;
        }

        public Integer peek() {
            return maxHeap.peek().value;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

