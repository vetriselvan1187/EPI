package LinkedList;

/**
 * Created by Vetriselvan on 21-12-2017.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = head.next.next;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        Node cycleStartNode = linkedListCycle.hasCycle(head);
        System.out.println(cycleStartNode.data);
    }

    private Node hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while(slow != fast);

                Node advanceIter = head;
                while(cycleLen-- > 0) {
                    advanceIter = advanceIter.next;
                }
                Node iter = head;
                while(iter != advanceIter) {
                    iter = iter.next;
                    advanceIter = advanceIter.next;
                }
                return iter;
            }
        }
        return null;
    }
}
