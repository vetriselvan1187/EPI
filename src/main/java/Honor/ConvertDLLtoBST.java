package Honor;

import LinkedList.ListPivoting;

/**
 * Created by Vetriselvan on 03-01-2018.
 * 25.23 Convert BST to Doubly Linked List
 *
 */
public class ConvertDLLtoBST {
    static class ListNode {
        int data;
        ListNode prev, next;
        public ListNode(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    static class BSTNode {
        int data;
        BSTNode left, right;
        public BSTNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static ListNode head = null;
    public static void main(String[] args) {
        head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.prev = head;
        head.next.next = new ListNode(30);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.prev = head.next.next.next;
        ConvertDLLtoBST convertDLLtoBST = new ConvertDLLtoBST();
        BSTNode bstNode = convertDLLtoBST.convertDLLtoBST(1, 6);
        convertDLLtoBST.printBSTInorder(bstNode);
        System.out.println();
        convertDLLtoBST.printBSTPreorder(bstNode);
    }

    private void printBSTInorder(BSTNode bstNode) {
        if(bstNode == null)
            return;
        printBSTInorder(bstNode.left);
        System.out.print(bstNode.data+" ");
        printBSTInorder(bstNode.right);
    }

    private void printBSTPreorder(BSTNode bstNode) {
        if(bstNode == null)
            return;
        System.out.print(bstNode.data+" ");
        printBSTPreorder(bstNode.left);
        printBSTInorder(bstNode.right);
    }

    private void printDoublyLinkedList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private BSTNode convertDLLtoBST(int start, int end) {
        if(start >= end) {
            return null;
        }
        int mid = start + (end-start)/2;
        BSTNode left = convertDLLtoBST(start, mid);
        BSTNode bstNode = new BSTNode(head.data);
        bstNode.left = left;
        head = head.next;
        BSTNode right  = convertDLLtoBST(mid+1, end);
        bstNode.right = right;
        return bstNode;
    }
}
