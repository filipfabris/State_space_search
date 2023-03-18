package ui.data.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Node implements Comparable<Node> {

    public String name;
    public Map<Node, Double> neighbors;

    Node(String name) {
        this.name = name;
        this.neighbors = new TreeMap<>();
    }
    public void addNeighborNode(Node node, Double value) {
        this.neighbors.put( node, value );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals( name, node.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name );
    }

     @Override
    public int compareTo(Node o) {
        return this.name.compareTo( o.name );
    }
}
