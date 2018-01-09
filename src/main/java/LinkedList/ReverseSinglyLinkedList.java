package LinkedList;

/**
 * Created by Vetriselvan on 27-12-2017.
 *  Extra - Reverse Singly Linked List
 */
public class ReverseSinglyLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();
        reverseSinglyLinkedList.printLinkedList(head);
        Node head2 = new Node(0);
        reverseSinglyLinkedList.reverseLinkedList(head, head2);
        System.out.println();
        reverseSinglyLinkedList.printLinkedList(head2.next);
    }

    private void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            System.out.print(" ");
            temp = temp.next;
        }
    }

    private Node reverseLinkedList(Node node, Node head2) {
        if(node == null)
            return head2;
        Node rnode = reverseLinkedList(node.next, head2);
        rnode.next = node;
        node.next = null;
        rnode = rnode.next;
        return rnode;
    }
}

