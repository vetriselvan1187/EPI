package BST;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Vetriselvan on 05-01-2018.
 * 15.3 Find K Largest Elements in BST
 * Time Complexity O(h+k)
 */
public class FindKLaregetInBST {
    static class Node {
        int data;
        Node left, right;
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

        FindKLaregetInBST findKLaregetInBST = new FindKLaregetInBST();
        List<Integer> topKLargest = new ArrayList<Integer>();
        findKLaregetInBST.findKLargestInBST(root, 3, topKLargest);
        for(Integer a : topKLargest) {
            System.out.println(a);
        }
    }

    private void findKLargestInBST(Node root, int k, List<Integer> integerList){
        if(root != null && integerList.size() < k) {
            findKLargestInBST(root.right, k, integerList);
            if(integerList.size() < k) {
                integerList.add(root.data);
                findKLargestInBST(root.left, k, integerList);
            }
        }
    }
}
