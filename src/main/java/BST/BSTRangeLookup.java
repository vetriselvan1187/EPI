package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vetriselvan on 07-01-2018.
 * 15.12  BST Range Lookup
 * Time Complexity O(m+h)
 */
public class BSTRangeLookup {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Interval {
        Integer left;
        Integer right;

        public Interval(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(7);
        root.right = new Node(55);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.right = new Node(12);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(10);
        root.right.left = new Node(45);
        root.right.right = new Node(75);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(85);

        Interval interval = new Interval(12, 75);
        List<Integer> intervalList = new ArrayList<Integer>();
        BSTRangeLookup bstRangeLookup = new BSTRangeLookup();
        bstRangeLookup.getRangeNodes(root, interval, intervalList);

        System.out.println(intervalList+" "+intervalList.size());
        for(Integer node : intervalList) {
            System.out.print(node+" ");
        }
    }

    private void getRangeNodes(Node root, Interval interval, List<Integer> integerList) {
        if(root == null)
            return;

        if(interval.left <= root.data && root.data <= interval.right) {
            getRangeNodes(root.left, interval, integerList);
            integerList.add(root.data);
            getRangeNodes(root.right, interval, integerList);
        } else if(interval.left  > root.data) {
            getRangeNodes(root.right, interval, integerList);
        } else {
            getRangeNodes(root.left, interval, integerList);
        }
    }
}
