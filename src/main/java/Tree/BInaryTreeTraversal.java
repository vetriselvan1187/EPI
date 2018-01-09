package Tree;
/**
 * Created by Vetriselvan on 23-12-2017.
 */
public class BInaryTreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.right = new Node(70);
        root.left.right.left = new Node(80);
        root.left.right.right = new Node(90);

        BInaryTreeTraversal bInaryTreeTraversal = new BInaryTreeTraversal();
        bInaryTreeTraversal.printInorder(root);
        System.out.println();
        bInaryTreeTraversal.printPreorder(root);
        System.out.println();
        bInaryTreeTraversal.printPostorder(root);
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }
    }

    private void printPreorder(Node root) {
        if (root != null) {
            System.out.print(root.data+" ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    private void printPostorder(Node root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data+" ");
        }
    }
}

final class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
