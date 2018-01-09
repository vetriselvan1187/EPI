package LinkedList;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 8.8 Program to remove duplicates from sorted list
 * Time Complexity is o(n) and Space Complexity is O(1)
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(11);
        head.next.next.next.next.next = new Node(11);

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        Node dedupedList = removeDuplicatesFromSortedList.removeDuplicates(head);
        removeDuplicatesFromSortedList.printLinkedList(dedupedList);

    }

    private void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data);
            System.out.print(' ');
            head = head.next;
        }
    }

    private Node removeDuplicates(Node head) {
        Node temp = head;
        if(temp == null)
            return null;
        while(temp.next != null) {
            if(temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
