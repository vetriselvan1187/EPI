package Tree;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by Vetriselvan on 03-01-2018.
 * 10.8 Preorder  Traversal without Recursion
 *
 */
public class PreorderTraversalWithoutRecursion {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60);
        root.left.left.right = new Node(80);
        root.right.left = new Node(90);
        root.right.right = new Node(100);
        PreorderTraversalWithoutRecursion preorderTraversalWithoutRecursion = new PreorderTraversalWithoutRecursion();
        List<Integer> result = preorderTraversalWithoutRecursion.preOrderTraversal(root);
        for(Integer a : result) {
            System.out.print(a+" ");
        }
    }

    private List<Integer> preOrderTraversal(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        LinkedList<Integer> result = new LinkedList<Integer>();
        while(!stack.isEmpty()) {
            Node curr = stack.removeFirst();
            if(curr != null) {
                result.add(curr.data);
                stack.addFirst(curr.right);
                stack.addFirst(curr.left);
            }
        }
        return result;
    }
}
