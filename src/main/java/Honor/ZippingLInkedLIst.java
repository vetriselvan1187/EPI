package Honor;

import LinkedList.ReverseSinglyLinkedList;

import java.util.List;

/**
 * Created by Vetriselvan on 02-01-2018.
 * 25.9 Zipping Linked List
 *
 */
public class ZippingLInkedLIst {
    static class Node {
        public int data;
        public Node next;
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
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(80);
        ZippingLInkedLIst zippingLInkedLIst = new ZippingLInkedLIst();
        Node zippedList = zippingLInkedLIst.zippingList(head);
        zippingLInkedLIst.printList(zippedList);
    }

    private void printList(Node node) {
        while(node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    private Node zippingList(Node L) {
        if(L == null || L.next == null)
            return L;

        Node slow = L, fast = L;
        while(slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node firstHalfHead = L;
        Node secondHalfHead = slow.next;
        slow.next = null;
        Node reverseHead = new Node(0);
        reverseLinkedList(secondHalfHead, reverseHead);
        secondHalfHead = reverseHead.next;
        //secondHalfHead = reverseList(secondHalfHead);
        printList(secondHalfHead);
        Node firstHalfIter = firstHalfHead;
        Node secondHalfIter = secondHalfHead;

        while(secondHalfIter != null) {
            Node temp  = secondHalfIter.next;
            secondHalfIter.next = firstHalfIter.next;
            firstHalfIter.next = secondHalfIter;
            firstHalfIter = firstHalfIter.next.next;
            secondHalfIter = temp;
        }
        return L;
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

    private Node reverseList(Node node) {
        Node tempList = null;
        while(node != null) {
            if(tempList == null) {
                tempList = new Node(node.data);
            } else {
                Node temp = new Node(node.data);
                temp.next = tempList;
                tempList = temp;
            }
            node = node.next;
        }
        return tempList;
    }
}
