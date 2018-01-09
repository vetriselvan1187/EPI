package BST;

/**
 * Created by Vetriselvan on 25-12-2017.
 * 15.1 - check given binary tree satisfies the bst property or not
 */
public class CheckBST {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(80);
        root.left.left = new Node(30);
        root.left.right = new Node(45);
        root.right.left = new Node(75);
        root.right.right = new Node(95);
        root.left.left.left = new Node(20);
        root.left.left.right = new Node(35);
        root.right.right.left = new Node(85);
        root.right.right.right = new Node(105);
        CheckBST checkBST = new CheckBST();
        System.out.println(checkBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private boolean isBST(Node root, Integer lower, Integer upper) {
        if(root == null)
            return true;
        if(root.data <= lower || root.data > upper) {
            System.out.println(root.data);
            return false;
        }
        return isBST(root.left, lower, root.data) &&
                isBST(root.right, root.data, upper);
    }
}

