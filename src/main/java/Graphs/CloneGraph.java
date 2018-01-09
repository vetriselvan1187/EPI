package Graphs;


import java.util.*;

/**
 * Created by Vetriselvan on 07-01-2018.
 * 19.5 Clone Graph
 * Time Complexity O(V+E)
 */
public class CloneGraph {
    static class GraphNode {
        public int data;
        public List<GraphNode> edges;
        public boolean visited = false;

        public GraphNode(int data) {
            this.data = data;
            this.edges = new ArrayList<GraphNode>();
        }
    }

    public static void main(String[] args) {
        GraphNode g1 = new GraphNode(10);
        GraphNode g2 = new GraphNode(20);
        GraphNode g3 = new GraphNode(30);
        GraphNode g4 = new GraphNode(40);
        GraphNode g5 = new GraphNode(50);
        GraphNode g6 = new GraphNode(60);
        GraphNode g7 = new GraphNode(70);

        g1.edges.add(g2);
        g1.edges.add(g3);
        g1.edges.add(g4);
        g2.edges.add(g5);
        g2.edges.add(g6);
        g3.edges.add(g7);
        g4.edges.add(g5);
        g4.edges.add(g7);
        g5.edges.add(g6);
        g6.edges.add(g7);

        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.printGraphBFS(g1);
        System.out.println();
        GraphNode clonedNode = cloneGraph.cloneGraph(g1);
        cloneGraph.printGraphBFS(clonedNode);
    }


    private GraphNode cloneGraph(GraphNode g) {
        if(g == null)
            return null;
        Map<GraphNode, GraphNode> graphNodeGraphNodeMap = new HashMap<GraphNode, GraphNode>();
        Queue<GraphNode>  q = new LinkedList<GraphNode>();
        q.add(g);
        graphNodeGraphNodeMap.put(g, new GraphNode(g.data));
        while(!q.isEmpty()) {
            GraphNode v = q.remove();
            for(GraphNode e : v.edges) {
                if(!graphNodeGraphNodeMap.containsKey(e)) {
                    graphNodeGraphNodeMap.put(e, new GraphNode(e.data));
                    q.add(e);
                }
                graphNodeGraphNodeMap.get(v).edges.add(graphNodeGraphNodeMap.get(e));
            }
        }
        return graphNodeGraphNodeMap.get(g);
    }

    private void printGraphBFS(GraphNode g) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(g);
        g.visited = true;
        while(!q.isEmpty()) {
            GraphNode graphNode = q.remove();
            System.out.print(graphNode.data+" ");
            for(GraphNode edgeNode : graphNode.edges) {
                if(!edgeNode.visited) {
                    q.add(edgeNode);
                    edgeNode.visited = true;
                }
            }
        }
    }
}
