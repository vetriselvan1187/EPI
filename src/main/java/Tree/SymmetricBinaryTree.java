package Tree;
/**
 * Created by Vetriselvan on 23-12-2017.
 * Program to check whether Binary Tree is Symmetric or not
 *
 */
public class SymmetricBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(314);
        root.left = new Node(6);
        root.right = new Node(6);
        root.left.right = new Node(3);
        root.right.left = new Node(3);
        root.left.right.right = new Node(2);
        root.right.left.left = new Node(2);

        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        System.out.println(symmetricBinaryTree.isSymmetric(root));

    }

    private boolean isSymmetric(Node root) {
        return root == null || checkSymmetric(root.left, root.right);
    }
    private boolean checkSymmetric(Node subTree1, Node subTree2) {
        if(subTree1 == null && subTree2 == null)
            return true;

        if(subTree1 != null || subTree2 != null) {
            return subTree1.data == subTree2.data &&
                    checkSymmetric(subTree1.left, subTree2.right) &&
                    checkSymmetric(subTree1.right, subTree2.left);
        }
        return false;
    }
}
