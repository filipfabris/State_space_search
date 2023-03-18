package ui.algorithm;

import ui.data.structure.InitGraph;
import ui.data.structure.Node;
import ui.data.structure.NodeTraversal;

import java.util.*;

public class UCS {

    public static Comparator<NodeTraversal> COMPARE_COST = Comparator.comparing( (NodeTraversal n) -> n.totalCost );

    InitGraph initGraph;

    public UCS(InitGraph initGraph) {
        this.initGraph = initGraph;
    }

    public void search() {

        //Data structures
        PriorityQueue<NodeTraversal> open = new PriorityQueue<>( UCS.COMPARE_COST);
        Set<Node> visited = new HashSet<>();

        //Start and end node
        Node startNode = initGraph.getStartNode();
        List<Node> endNode = initGraph.getEndNode();

        //Add start node to queue
        NodeTraversal nodeTraversal = new NodeTraversal(
                startNode,
                null,
                1,
                0.0
        );
        open.add( nodeTraversal );


        //Solution variables
        boolean solutionFound = false;
        NodeTraversal current = null;

        while (open.isEmpty() == false) {
            current = open.remove();
            visited.add( current.node );

            if (endNode.contains( current.node )) {
                solutionFound = true;
                break;
            }

            for (Map.Entry<Node, Double> next : current.node.neighbors.entrySet()) {

                NodeTraversal nodeTraversalFuture = new NodeTraversal(
                        next.getKey(),
                        current,
                        current.depth + 1,
                        current.totalCost + next.getValue()
                );

                if(visited.contains( nodeTraversalFuture.node ))
                    continue;

                open.add( nodeTraversalFuture );
            }

        }

        System.out.println("# UCS");
        System.out.println("[FOUND_SOLUTION]: " + (solutionFound ? "yes" : "no"));
        System.out.println("[STATES_VISITED]: " + visited.size());
        System.out.println( "[PATH_LENGTH]: " + (current == null ? 0 : current.depth ));
        System.out.println( "[TOTAL_COST]: " + (current == null ? 0 : current.totalCost));
        System.out.print( "[PATH]: " + (current == null ? "" : NodeTraversal.nodePath( current ) ));
    }

}
