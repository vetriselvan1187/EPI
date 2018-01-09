package LinkedList;

import Searching.SearchCyclicallySortedArray;

/**
 * Created by Vetriselvan on 03-01-2018.
 * 9.5 Search Posting List
 * Time Complexity O(n) and Space Complexity O(1)
 */
public class SearchPostingList {
    static class Node {
        int data;
        int order = -1;
        Node jump, next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head.jump = head.next.next;
        head.next.next.jump = head.next;
        head.next.jump = head.next.next.next;
        head.next.next.next.jump = head.next.next.next;
        SearchPostingList  searchPostingList = new SearchPostingList();
        searchPostingList.searchPostingList(head);

    }

    private void searchPostingList(Node head) {
        setJumpOrder(head, 0);
    }

    private int setJumpOrder(Node node, int order) {
        if(node != null && node.order == -1) {
            node.order = ++order;
            System.out.print(node.data+" ");
            order = setJumpOrder(node.jump, order);
            order = setJumpOrder(node.next, order);
        }
        return order;
    }
}
