package LinkedList;

/**
 * Created by Vetriselvan on 21-12-2017.
 * Reverse Sublist of LinkedList
 */
public class ReverseSubList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        ReverseSubList reverseSubList = new ReverseSubList();
        Node reversedList = reverseSubList.reverseSubList(head, 2, 4);
        reverseSubList.printLinkedList(reversedList);
    }

    private void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    private Node reverseSubList(Node head, int start, int end) {
        if (start == end)
            return head;
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node sublistHead = dummyHead;
        int k = 1;
        while(k++ < start) {
            sublistHead = sublistHead.next;
        }

        Node subListIter = sublistHead.next;
        while(start++ < end) {
            Node temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }
}

