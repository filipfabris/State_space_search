package ui.data.structure;

import java.util.Comparator;

public class NodeTraversal {

    public static Comparator<NodeTraversal> COMPARE_HEURISTIC = Comparator.comparing( (NodeTraversal n) -> n.heuristicCost );

    public NodeTraversal nodeParent;

    public Node node;

    public int depth = 0;
    public double totalCost = 0.0;
    public double heuristicCost = 0.0;

    public NodeTraversal(Node node) {
        this.node = node;
    }

    public NodeTraversal(Node node, NodeTraversal nodeParent, int depth, double totalCost, double heuristicCost) {
        this.node = node;
        this.nodeParent = nodeParent;
        this.depth = depth;
        this.totalCost = totalCost;
        this.heuristicCost = heuristicCost;
    }

    public NodeTraversal(Node node, NodeTraversal nodeParent, int depth, double totalCost) {
        this.node = node;
        this.nodeParent = nodeParent;
        this.depth = depth;
        this.totalCost = totalCost;
    }

    public void addCost(double cost) {
        this.totalCost += cost;
    }

    public static <X> String nodePath(NodeTraversal node) {
        StringBuilder sb = new StringBuilder();
        nodePathRecursive(sb, node);
        return sb.toString();
    }

    private static <X> void nodePathRecursive(StringBuilder sb, NodeTraversal node) {
        if(node.nodeParent!=null) {
            nodePathRecursive(sb, node.nodeParent);
            sb.append(" => ");
        }
        sb.append(node);
    }

    @Override
    public String toString() {
        return node.name;
    }

}