package ui.algorithm;

import ui.data.structure.InitGraph;
import ui.data.structure.Node;

import java.util.Comparator;
import java.util.Map;

public class HeuristicConsistent {

    InitGraph initGraph;
    Map<Node, Double> heuristicMap;
    String heuristicPath;


    public HeuristicConsistent(InitGraph initGraph, Map<Node, Double> heuristicMap, String heuristicPath) {
        this.initGraph = initGraph;
        this.heuristicMap = heuristicMap;
        this.heuristicPath = heuristicPath;
    }


    public void run() {

        Map<String,Node> nodeList = initGraph.getNodeList();
        boolean optimal = true;
        String output = "";

        System.out.println( "# HEURISTIC-CONSISTENT " + heuristicPath );
        for(Node node : nodeList.values()){

            Map<Node, Double> nodesToCheck = node.neighbors;
            Double parentHeuristic = heuristicMap.get( node );

            for (Map.Entry checkNode : nodesToCheck.entrySet()) {
                Double childHeuristic = heuristicMap.get( checkNode.getKey() );
                Double childCost = (Double) checkNode.getValue();

                if(parentHeuristic > childHeuristic + childCost){
                    optimal = false;
                }

                output = String.format( "[CONDITION]: [%s] h(%s) <= h(%s) + c: %.1f <= %.1f + %.1f"
                        , parentHeuristic <= childHeuristic + childCost ? "OK" : "ERR", node.name
                        , ((Node)checkNode.getKey()).name, parentHeuristic, childHeuristic, childCost);

                System.out.println( output);

            }

        }

        output = String.format( "[CONCLUSION]: Heuristic %s consistent.", optimal==true ? "is" : "is not" );
        System.out.print( output);


    }



}

