package Honor;

/**
 * Created by Vetriselvan on 04-01-2018.
 * 25.23 Convert BST to Sorted DLL
 * Time Complexity O(n) and Space Complexity O(n)
 */
public class ConvertBSTtoSortedDLL {
    static class BSTNode {
        int data;
        BSTNode left, right;

        public BSTNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    static Node dllTop = new Node(0);
    static Node dll = dllTop;

    public static void main(String[] args) {
        BSTNode root = new BSTNode(50);
        root.left = new BSTNode(30);
        root.right = new BSTNode(75);
        root.left.left = new BSTNode(10);
        root.left.right = new BSTNode(40);
        root.right.left = new BSTNode(60);
        root.right.right = new BSTNode(85);
        root.left.left.left = new BSTNode(5);
        root.left.left.right = new BSTNode(15);

        ConvertBSTtoSortedDLL convertBSTtoSortedDLL = new ConvertBSTtoSortedDLL();
        Node dummyHead = new Node(0);
        Node tempHead = dummyHead;
        convertBSTtoSortedDLL.convertBSTtoSortedDLL(root);
        System.out.println();
        convertBSTtoSortedDLL.printDLL(dll.next);

    }

    private void printDLL(Node node) {
        Node temp = node;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private void convertBSTtoSortedDLL(BSTNode bstNode) {
        if(bstNode != null) {
            convertBSTtoSortedDLL(bstNode.left);
            Node temp = new Node(bstNode.data);
            dllTop.next = temp;
            temp.prev = dllTop;
            dllTop = temp;
            convertBSTtoSortedDLL(bstNode.right);
        }
    }
}