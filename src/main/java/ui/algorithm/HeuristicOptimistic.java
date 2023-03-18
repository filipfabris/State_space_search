package ui.algorithm;

import ui.data.structure.InitGraph;
import ui.data.structure.Node;
import ui.data.structure.NodeTraversal;

import java.util.*;

public class HeuristicOptimistic {

    InitGraph initGraph;
    Map<Node, Double> heuristicMap;
    String heuristicPath;


    public HeuristicOptimistic(InitGraph initGraph,  Map<Node, Double> heuristicMap, String heuristicPath) {
        this.initGraph = initGraph;
        this.heuristicMap = heuristicMap;
        this.heuristicPath = heuristicPath;
    }


    public void run() {

        Map<String,Node> nodeList = initGraph.getNodeList();
        boolean optimal = true;
        String output = "";

        System.out.println( "# HEURISTIC-OPTIMISTIC " + heuristicPath );
        for(Node node : nodeList.values()){
            InitGraph initGraphNode = new InitGraph(node, initGraph.getEndNode());
            NodeTraversal realResult = new BFS( initGraphNode ).search(false, true);
            Double heuristicCost = heuristicMap.get( node );

            if(heuristicCost > realResult.totalCost){
                optimal = false;
            }

            output = String.format( "[CONDITION]: [%s] h(%s) <= h*: %.1f <= %.1f"
                    , heuristicCost <= realResult.totalCost ? "OK" : "ERR", node.name, heuristicCost, realResult.totalCost );

            System.out.println( output);
        }

        output = String.format( "[CONCLUSION]: Heuristic %s optimistic.", optimal==true ? "is" : "is not" );
        System.out.print( output);


    }



}

