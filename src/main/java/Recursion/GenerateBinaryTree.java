package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Vetriselvan on 30-12-2017.
 * 16.8 Generate Binary Tree
 */
public class GenerateBinaryTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        GenerateBinaryTree generateBinaryTree = new GenerateBinaryTree();
        List<Node> generatedTrees  = generateBinaryTree.generateAllBinaryTrees(5);
        System.out.println(generatedTrees.size());
    }

    private List<Node>  generateAllBinaryTrees(int numOfNodes) {
        List<Node> result = new ArrayList<Node>();
        if(numOfNodes == 0)
            result.add(null);

        for(int numOfLeftTreeNodes = 0; numOfLeftTreeNodes < numOfNodes; numOfLeftTreeNodes++) {
            int numOfRightTreeNodes = numOfNodes-1-numOfLeftTreeNodes;
            List<Node> leftSubTrees = generateAllBinaryTrees(numOfLeftTreeNodes);
            List<Node> rightSubTrees = generateAllBinaryTrees(numOfRightTreeNodes);

            for(Node left : leftSubTrees) {
                for(Node right : rightSubTrees) {
                    result.add(new Node(0, left, right));
                }
            }
        }
        return result;
    }
}
