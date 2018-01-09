package Tree;

import java.util.LinkedList;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 10.14 Form Linked List From the Leaves of Binary Tree
 *
 */
public class LinkedListFromBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        LinkedList<Node> leaves = new LinkedList<Node>();
        LinkedListFromBinaryTree linkedListFromBinaryTree = new LinkedListFromBinaryTree();
        linkedListFromBinaryTree.createLinkedListFromBinaryTree(root, leaves);
        linkedListFromBinaryTree.printLinkedList(leaves);
    }

    private void printLinkedList(LinkedList<Node> leaves) {
        for(Node node : leaves) {
            System.out.print(node.data);
            System.out.print(' ');
        }
    }

    private void createLinkedListFromBinaryTree(Node node, LinkedList<Node> leaves) {
        if(node == null)
            return;
        if(node.left == null && node.right == null) {
            leaves.add(node);
        } else {
            createLinkedListFromBinaryTree(node.left, leaves);
            createLinkedListFromBinaryTree(node.right, leaves);
        }
    }
}
