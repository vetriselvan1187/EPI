package LinkedList;

/**
 * Created by Vetriselvan on 20-12-2017.
 * Program to merge two sorted LinkedList
 */
public class MergeSortedList {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);

        Node head2 = new Node(15);
        head2.next = new Node(25);
        head2.next.next = new Node(35);
        head2.next.next.next = new Node(45);
        head2.next.next.next.next = new Node(55);

        MergeSortedList mergeSortedList = new MergeSortedList();
        Node mergedList = mergeSortedList.mergeList(head1, head2);
        mergeSortedList.printLinkedList(mergedList);
    }

    private void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    private Node mergeList(Node head1, Node head2) {
        Node dummyHead = new Node(0);
        Node mergedList = dummyHead;
        Node p1 = head1;
        Node p2 = head2;

        while(p1 != null && p2 != null) {
            if(p1.data <= p2.data) {
                mergedList.next = p1;
                p1 = p1.next;
            } else {
                mergedList.next = p2;
                p2 = p2.next;
            }
            mergedList = mergedList.next;
        }
        mergedList.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }

}

final class Node<T> {
    public int data;
    public Node<T> next = null;

    public Node(int data) {
        this.data = data;
    }
}