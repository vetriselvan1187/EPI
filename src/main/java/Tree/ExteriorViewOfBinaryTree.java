package Tree;

import java.util.LinkedList;

/**
 * Created by Vetriselvan on 30-12-2017.
 */
public class ExteriorViewOfBinaryTree {
    public static void main(String[] args) {
        Node rootView = new Node(1);
        rootView.left = new Node(2);
        rootView.right = new Node(3);
        rootView.left.left = new Node(4);
        rootView.left.right = new Node(5);
        rootView.right.left = new Node(6);
        rootView.right.right = new Node(7);
        rootView.right.right.left = new Node(8);
        rootView.right.left.left = new Node(9);
        rootView.right.left.left.right = new Node(10);
        rootView.right.left.left.right.right = new Node(11);
        ExteriorViewOfBinaryTree exteriorViewOfBinaryTree = new ExteriorViewOfBinaryTree();
        exteriorViewOfBinaryTree.printExterior(rootView);
    }

    private void printExterior(Node root) {
        System.out.println("Printing Exterior");
        System.out.print(root.data+" ");
        printInorderExterior(root.left);
        printPostorderExterior(root.right);
        printRightSideView(root.right);
    }

    private void printInorderExterior(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            printInorderExterior(root.left);
            if(root.right != null) {
                printInorderExteriorRight(root.right);
            }
        }
    }

    private void printInorderExteriorRight(Node root) {
        if(root != null) {
            if(root.left == null && root.right == null)
                System.out.print(root.data+" ");
            printInorderExteriorRight(root.left);
            printInorderExteriorRight(root.right);
        }
    }

    private void printPostorderExterior(Node root) {
        if(root != null) {
            printPostorderExterior(root.left);
            printPostorderExterior(root.right);
            if(root.left == null && root.right == null)
                System.out.print(root.data+" ");
        }
    }

    private void printRightSideView(Node root) {
        if(root != null) {
            printRightSideView(root.right);
            if (root.right != null) {
                System.out.print(root.data + " ");
            }
        }
    }
}
