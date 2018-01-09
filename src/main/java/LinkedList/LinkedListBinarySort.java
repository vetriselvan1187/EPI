package LinkedList;

/**
 * Created by Vetriselvan on 05-01-2018.
 * Extra LinkedList Binary Sort
 * Time Complexity O(n) and Space Complexity O(n)
 */
public class LinkedListBinarySort {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next  = new Node(0);
        head.next.next.next.next.next = new Node(1);

        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node tempZeroHead = zeroHead;
        Node tempOneHead = oneHead;

        LinkedListBinarySort linkedListBinarySort = new LinkedListBinarySort();
        linkedListBinarySort.sortBinaryLinkedList(tempZeroHead, tempOneHead, head);
        Node tempZero = zeroHead.next;
        Node starthead = tempZero;
        Node tempOne = oneHead.next;
        while(tempZero.next != null) {
            tempZero = tempZero.next;
        }
        tempZero.next = tempOne;
        System.out.println();
        linkedListBinarySort.printLinkedList(starthead);
    }

    private void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private void sortBinaryLinkedList(Node zeroHead, Node oneHead, Node node) {
        if(zeroHead == null || oneHead == null)
            return;
        if(node != null) {
            if (node.data == 0) {
                zeroHead.next = new Node(node.data);
                zeroHead = zeroHead.next;
            } else {
                oneHead.next = new Node(node.data);
                oneHead = oneHead.next;
            }
            System.out.print(node.data + "  ");
            node = node.next;
            sortBinaryLinkedList(zeroHead, oneHead, node);
        }
    }
}
