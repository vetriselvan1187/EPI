package BST;

/**
 * Created by Vetriselvan on 05-01-2018.
 * 15.2 Find First Key Greater Than K
 * Time Complexity O(h) and Space Complexity O(1)
 */
public class FindFirstKeyGraterThanK {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(19);
        root.left = new Node(15);
        root.right = new Node(43);
        root.right.left = new Node(23);
        root.right.left.right = new Node(35);
        root.right.right = new Node(50);
        root.right.right.left = new Node(45);

        FindFirstKeyGraterThanK findFirstKeyGraterThanK = new FindFirstKeyGraterThanK();
        Node first = findFirstKeyGraterThanK.findFirstGreaterThanK(root, 23);
        System.out.println(first.data);
    }

    private Node findFirstGreaterThanK(Node root, int k) {
        Node subtree = root, first = null;
        while(subtree != null) {
            if(subtree.data > k) {
                first = subtree;
                subtree = subtree.left;
            } else {
                subtree = subtree.right;
            }
        }
        return first;
    }
}
