package Tree;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 10.6 Program to check root to leaf path sum of Binary Tree
 * Time Complexity is o(n) and Space Complexity is o(h)
 */

public class RootToLeafPathSum {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);

        RootToLeafPathSum rootToLeafPathSum = new RootToLeafPathSum();
        System.out.println(rootToLeafPathSum.hasPathSum(root, 15));
    }

    private boolean hasPathSum(Node root, int targetSum) {
        return hasPathSumHelper(root, 0, targetSum);
    }

    private boolean hasPathSumHelper(Node node, int partialSum, int targetSum) {
        if(node == null)
            return false;
        partialSum += node.data;
        if(node.left ==  null && node.right == null) {
            return partialSum == targetSum;
        }
        return hasPathSumHelper(node.left, partialSum, targetSum) ||
                hasPathSumHelper(node.right, partialSum, targetSum);
    }
}
