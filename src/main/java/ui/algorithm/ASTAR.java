package ui.algorithm;

import ui.data.structure.InitGraph;
import ui.data.structure.Node;
import ui.data.structure.NodeTraversal;

import java.util.*;

public class ASTAR {
    InitGraph initGraph;
    String heuristicPath;
    Map<Node, Double> heuristicMap;

    public ASTAR(InitGraph initGraph, Map<Node, Double> heuristicMap, String heuristicPath) {
        this.initGraph = initGraph;
        this.heuristicMap = heuristicMap;
        this.heuristicPath = heuristicPath;
    }

    public NodeTraversal search(Boolean print) {

        //Data structures
        Queue<NodeTraversal> open = new PriorityQueue<>( NodeTraversal.COMPARE_HEURISTIC );
        Set<Node> visited = new HashSet<>();
        Map<Node, NodeTraversal> openMap = new HashMap<>();
        Map<Node, NodeTraversal> closedMap = new HashMap<>();

        //Start and end node
        Node startNode = initGraph.getStartNode();
        List<Node> endNode = initGraph.getEndNode();

        //Create traversal node
        NodeTraversal nodeTraversal = new NodeTraversal(
                startNode,
                null,
                1,
                0.0,
                0.0
        );
        //Add start node to queue
        open.add( nodeTraversal );
        openMap.put( startNode, nodeTraversal );

        boolean solutionFound = false;
        NodeTraversal current = null;

        while (open.isEmpty() == false) {
            current = open.remove();
            openMap.remove( current.node );
            visited.add( current.node );

            if (endNode.contains( current.node )) {
                solutionFound = true;
                break;
            }

            closedMap.put( current.node, current );

            for (Map.Entry<Node, Double> next : current.node.neighbors.entrySet()) {

                NodeTraversal nodeTraversalFuture = new NodeTraversal(
                        next.getKey(),
                        current,
                        current.depth + 1,
                        current.totalCost + next.getValue(),
                        current.totalCost + next.getValue() + heuristicMap.get( next.getKey() )
                );

                NodeTraversal nodeInOpen = openMap.get( next.getKey() );
                if (nodeInOpen != null && nodeInOpen.totalCost < nodeTraversalFuture.totalCost) {
                    continue;
                }

                NodeTraversal nodeInClosed = closedMap.get( next.getKey() );
                if (nodeInClosed != null && nodeInClosed.totalCost < nodeTraversalFuture.totalCost) {
                    continue;
                }

                if(nodeInOpen != null){
                    openMap.remove(nodeInOpen.node);
                    open.remove(nodeInOpen);
                }

                if (nodeInClosed != null) {
                    closedMap.remove( nodeInClosed.node );
                }

                open.add( nodeTraversalFuture );
                openMap.put( next.getKey(), nodeTraversalFuture );
            }
        }

        if(print == true) {
            System.out.println( "# A-STAR " + heuristicPath );
            System.out.println( "[FOUND_SOLUTION]: " + (solutionFound ? "yes" : "no") );
            System.out.println( "[STATES_VISITED]: " + visited.size() );
            System.out.println( "[PATH_LENGTH]: " + (current == null ? 0 : current.depth ));
            System.out.println( "[TOTAL_COST]: " + (current == null ? 0 : current.totalCost));
            System.out.print( "[PATH]: " + (current == null ? "" : NodeTraversal.nodePath( current ) ));
        }

        return current;

    }

}

