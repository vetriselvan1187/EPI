package LinkedList;

/**
 * Created by Vetriselvan on 03-01-2018.
 * 8.12 Implement List Pivoting
 * Time Complexity O(n) Space Complexity O(1)
 *
 */
public class ListPivoting {
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(11);

        ListPivoting listPivoting = new ListPivoting();
        listPivoting.printList(head);
        System.out.println();
        Node pivotedList = listPivoting.pivotList(head, 7);
        listPivoting.printList(pivotedList);
    }

    private void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private Node pivotList(Node head, int k) {
        Node lessThanHead = new Node(0);
        Node equalHead = new Node(0);
        Node greaterThanHead = new Node(0);
        Node lessThanIter = lessThanHead;
        Node equalIter = equalHead;
        Node greaterThanIter = greaterThanHead;

        Node iter = head;
        while(iter != null) {
            if(iter.data < k) {
                lessThanIter.next = iter;
                lessThanIter = iter;
            } else if(iter.data == k) {
                equalIter.next = iter;
                equalIter = iter;
            } else {
                greaterThanIter.next = iter;
                greaterThanIter = iter;
            }
            iter = iter.next;
        }
        greaterThanIter.next = null;
        equalIter.next = greaterThanHead.next;
        lessThanIter.next = equalHead.next;
        return lessThanHead.next;
    }
}
