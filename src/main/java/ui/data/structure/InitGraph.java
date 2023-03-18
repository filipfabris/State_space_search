package ui.data.structure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class InitGraph {

    String path;
    Node startNode;
    List<Node> endNode;
    Map<String, Node> nodeList;

    public InitGraph(String path) throws IOException {
        this.path = path;
        this.nodeList = new TreeMap<>();
        this.endNode = new LinkedList<>();
        this.init();
    }

    public InitGraph(Node startNode, List<Node> endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    private void init() throws IOException {

        List<String> input = Files.readAllLines( Path.of( path ) );
        Iterator<String> iterator = input.iterator();

        //Start node
        String line = readRemoveComments( iterator );
        Node node = new Node(  line );
        nodeList.put( line, node );
        startNode = node;

        //End node, check if it is the same as start node
        line = readRemoveComments( iterator );
        String[] split = line.split( " " );

        for(String s: split){
            if(nodeList.containsKey( line ) == false){
                node = new Node( s );
                nodeList.put( s, node );
            }else {
                node = nodeList.get( s );
            }
            this.endNode.add( node );
        }

        //Read all nodes
        while (iterator.hasNext()) {
            line = readRemoveComments( iterator );

            if(line == null){
                break;
            }

            split = line.split( " " );

            Iterator<String> lineIterator = Arrays.stream( split ).iterator();

            String nodeName = lineIterator.next();
            nodeName = nodeName.substring( 0, nodeName.length() - 1 );
            if(nodeList.containsKey( nodeName ) == false){
                node = new Node( nodeName );
                nodeList.put( nodeName, node );
            }else{
                node = nodeList.get( nodeName );
            }

            while ( lineIterator.hasNext() ) {
                String[] next = lineIterator.next().split( "," );
                Node tmp;
                if(nodeList.containsKey( next[0] ) == false){
                    tmp = new Node( next[0] );
                    nodeList.put( next[0] , tmp );
                }else {
                    tmp = nodeList.get( next[0] );
                }
                node.addNeighborNode( tmp, Double.parseDouble( next[1] ) );
            }
        }
    }

    String readRemoveComments(Iterator<String> iterator) {

        while (iterator.hasNext()) {
            String checkString = iterator.next();

            if(checkString.contains( "#" )  == false){
                return checkString;
            }

            String[] split = checkString.split( "#" );
            if (split.length > 1 && split[0].equals( "" ) == false){
                checkString = split[0];
                return checkString;
            }
        }

        return null;
    }

    public Node getStartNode() {
        return startNode;
    }

    public List<Node> getEndNode() {
        return endNode;
    }

    public Map<String, Node> getNodeList() {
        return nodeList;
    }
}
