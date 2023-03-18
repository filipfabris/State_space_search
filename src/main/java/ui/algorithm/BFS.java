package ui.algorithm;

import ui.data.structure.InitGraph;
import ui.data.structure.Node;
import ui.data.structure.NodeTraversal;

import java.util.*;

public class BFS {

    InitGraph initGraph;

    public BFS(InitGraph initGraph) {
        this.initGraph = initGraph;
    }

    public NodeTraversal search(Boolean print, Boolean findBest) {

        //Data structures
        LinkedList<NodeTraversal> open = new LinkedList<>();
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

        NodeTraversal foundBest = null;

        while (open.isEmpty() == false) {
            current = open.removeFirst();
            visited.add( current.node );

            if (endNode.contains( current.node )) {
                solutionFound = true;

                if(foundBest == null || foundBest.totalCost > current.totalCost){
                    foundBest = current;
                }

                if (findBest == true){
                    continue;
                }else {
                    break;
                }
            }

            for (Map.Entry<Node, Double> next : current.node.neighbors.entrySet()) {

                if (findBest == true) {
                    if (pastNodes( current ).contains( next.getKey() ))
                        continue;
                }else{
                    if (visited.contains( next.getKey()))
                        continue;
                }

                NodeTraversal nodeTraversalFuture = new NodeTraversal(
                        next.getKey(),
                        current,
                        current.depth + 1,
                        current.totalCost + next.getValue()
                );

                open.add( nodeTraversalFuture );
            }

        }

        if (print == true) {
            System.out.println( "# BFS" );
            System.out.println( "[FOUND_SOLUTION]: " + (solutionFound ? "yes" : "no") );
            System.out.println( "[STATES_VISITED]: " + visited.size() );
            System.out.println( "[PATH_LENGTH]: " + (foundBest == null ? 0 : foundBest.depth));
            System.out.println( "[TOTAL_COST]: " + (foundBest == null ? 0 : foundBest.totalCost));
            System.out.print( "[PATH]: " + (foundBest == null ? "" : NodeTraversal.nodePath( foundBest ) ));
        }

        return foundBest;
    }

    List<Node> pastNodes(NodeTraversal nodeTraversal){
        List<Node> pastNodes = new ArrayList<>();
        NodeTraversal current = nodeTraversal;
        while(current != null){
            pastNodes.add( current.node );
            current = current.nodeParent;
        }
        return pastNodes;
    }
}