package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vetriselvan on 08-01-2018.
 * 10.9 Compute the Kth node in Inorder Traversal
 * Time Complexity O(n) and Space Complexity O(1)
 *
 */
public class KthNodeInInorderTraversal {
    static class Node {
        Integer data;
        Node left, right;

        public Node(Integer data) {
            this.data  = data;
            this.left = this.right = null;
        }
    }

    static class KthNode {
        private int k;
        private Node node;
        public KthNode(int k) {
            this.k = k;
        }
        boolean isKthNode(Node node) {
            this.k--;
            if(this.k == 0) {
                this.node = node;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        KthNodeInInorderTraversal kthNodeInInorderTraversal = new KthNodeInInorderTraversal();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

        KthNode kthNode = new KthNode(6);
        kthNodeInInorderTraversal.findKthNode(root, kthNode);
        System.out.println(kthNode.node != null ? kthNode.node.data : "not exists");
    }

    private void findKthNode(Node root, KthNode kthNode) {
        if(root == null)
            return;
        findKthNode(root.left, kthNode);
        if(kthNode.isKthNode(root))
            return;
        findKthNode(root.right, kthNode);
    }
}
