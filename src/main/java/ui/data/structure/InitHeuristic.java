package ui.data.structure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class InitHeuristic {
    Map<Node, Double> heuristicMap;
    String path;

    public InitHeuristic(String path, Map<String, Node> nodeList) throws IOException {
        this.path = path;
        this.heuristicMap = new TreeMap<>();
        this.init( nodeList );
    }

    private void init(Map<String, Node> nodeList) throws IOException {
        List<String> input = Files.readAllLines( Path.of( path ) );
        Iterator<String> iterator = input.iterator();

        while (iterator.hasNext()) {
            String line = iterator.next();
            String[] lineSplit = line.split( ":" );

            String nodeName = lineSplit[0].trim();
            Double heuristicValue = Double.parseDouble( lineSplit[1].trim() );

            Node node = nodeList.get( nodeName );
            heuristicMap.put( node, heuristicValue );
        }
    }

    public  Map<Node, Double> getHeuristicMap() {
        return heuristicMap;
    }
}
