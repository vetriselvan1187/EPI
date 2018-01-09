package Tree;

/**
 * Created by Vetriselvan on 08-01-2018.
 * 10.10 Compute the Successor
 * Time Complexity O(n) and Space Complexity O(1)
 */
public class ComputeSuccessor {
    static class Node {
        Integer data;
        Node left, right;
        public Node(Integer data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Successor {
        boolean successor;
        Node node;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

        ComputeSuccessor computeSuccessor = new ComputeSuccessor();
        Successor successor = new Successor();
        computeSuccessor.computeSuccessor(root, 50, successor);
        System.out.println(successor.node != null ? successor.node.data : "successor does not exists");
    }

    private void computeSuccessor(Node root, Integer data, Successor successor) {
        if(root == null)
            return;
        computeSuccessor(root.left, data, successor);
        System.out.println(data+" "+successor);
        if(successor.successor) {
            successor.node = root;
            return;
        }
        if(!successor.successor && root.data == data) {
            successor.successor = true;
        }
        computeSuccessor(root.right, data, successor);
    }
}
