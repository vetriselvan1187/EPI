package BST;

/**
 * Created by Vetriselvan on 05-01-2018.
 * 15.4 Find LCA In BST
 *
 */
public class FindLCAInBST {
    static class Node {
        int data;
        Node left, right = null;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(19);
        root.left = new Node(15);
        root.left.left = new Node(14);
        root.left.right = new Node(18);
        root.right = new Node(55);
        root.right.left = new Node(35);
        root.right.right = new Node(75);
        root.right.right.left = new Node(85);
        root.right.right.right = new Node(95);

        FindLCAInBST findLCAInBST = new FindLCAInBST();
        Node lcaNode = findLCAInBST.findLCAInBST(root, root.right.left, root.right.right.right);
        System.out.println(lcaNode.data);

    }

    private Node findLCAInBST(Node root, Node n1, Node n2) {
        if(root == null)
            return null;
        if(root.data > n1.data && root.data < n2.data)
            return root;
        else if (root.data < n1.data && root.data < n2.data)
            return findLCAInBST(root.right, n1, n2);
        else
            return findLCAInBST(root.left, n1, n2);
    }
}
