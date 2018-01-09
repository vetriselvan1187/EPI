package LinkedList;

/**
 * Created by Vetriselvan on 21-12-2017.
 * 8.6 Delete Node from LinkedList
 */
public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        DeleteNodeLinkedList deleteNodeLinkedList = new DeleteNodeLinkedList();
        deleteNodeLinkedList.deleteNodeFromList(head, new Node(30));
        deleteNodeLinkedList.printLinkedList(head);
        System.out.println("====================================");
    }

    private void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            System.out.print(' ');
            temp = temp.next;
        }
    }

    /**
     * Time Complexity is o(1)
     * @param nodeToDelete
     */
    private void deleteNodeFromList(Node nodeToDelete) {
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }

    /**
     *  Time Complexity is o(n)
     */
    private void deleteNodeFromList(Node head, Node node) {
        if(head == null | node == null)
            return;
        if(head.data == node.data) {
            head = head.next;
            return;
        }
        while(head != null) {
            if(head.next.data == node.data) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }
}
