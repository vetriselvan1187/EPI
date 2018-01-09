package Tree;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by Vetriselvan on 03-01-2018.
 * 10.7 InOrder traversal without recursion
 * Time Complexity O(n) Space Complexity O(h)
 */
public class InorderTraversalWithoutRecursion {
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
        InorderTraversalWithoutRecursion inorderTraversalWithoutRecursion = new InorderTraversalWithoutRecursion();
        List<Integer> result = inorderTraversalWithoutRecursion.inOrderTraversalWithoutRecursion(root);
        for(Integer a :  result) {
            System.out.print(a + " ");
        }
    }

    private List<Integer> inOrderTraversalWithoutRecursion(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        Node curr = root;
        LinkedList<Integer> result = new LinkedList<Integer>();

        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.addFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                result.add(curr.data);
                curr = curr.right;
            }
        }
        return result;
    }
}
