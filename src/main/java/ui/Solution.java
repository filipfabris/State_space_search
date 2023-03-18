package ui;

import ui.algorithm.*;
import ui.data.structure.InitGraph;
import ui.data.structure.InitHeuristic;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Solution {

    //--alg astar --ss istra.txt --h istra_pessimistic_heuristic.txt --check-consistent

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);

        try {
            System.setOut(new PrintStream(new FileOutputStream( FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }

        String algorithm = "";
        String space = "";
        String heuristic = "";
        boolean optimistic = false;
        boolean consistent = false;


        List<String> arguments = Arrays.asList(args);

        if (arguments.contains("--alg")) {
            algorithm = arguments.get(arguments.indexOf("--alg") + 1);
        }

        if (arguments.contains("--ss")) {
            space = arguments.get(arguments.indexOf("--ss") + 1);
        }

        if (arguments.contains("--h")) {
            heuristic = arguments.get(arguments.indexOf("--h") + 1);
        }
        if (arguments.contains("--check-consistent")) {
            consistent = true;
        }
        if (arguments.contains("--check-optimistic")) {
            optimistic = true;
        }


    // With Apache Commons CLI
//        Options options = InitComonsCli.init();
//
//        CommandLine cmd;
//        CommandLineParser parser = new DefaultParser();
//        HelpFormatter helper = new HelpFormatter();

//        try {
//            cmd = parser.parse( options, args );
//            if (cmd.hasOption( "alg" )) {
//                String opt_config = cmd.getOptionValue( "alg" );
////                System.out.println( "Alg: " + opt_config );
//
//                algorithm = opt_config;
//            }
//
//            if (cmd.hasOption( "ss" )) {
//                String opt_config = cmd.getOptionValue( "ss" );
////                System.out.println( "Space: " + opt_config );
//
//                space = opt_config;
//            }
//
//            if (cmd.hasOption( "h" )) {
//                String opt_config= cmd.getOptionValue( "h" );
////                System.out.println( "Heuristic: " + opt_config );
//
//                heuristic = opt_config;
//            }
//
//            if (cmd.hasOption( "check-consistent" )) {
//                consistent = true;
////                System.out.println( "Consistent: " + "true" );
//            }
//
//            if (cmd.hasOption( "check-optimistic" )) {
//                optimistic = true;
////                System.out.println( "Optimistic: " + "true" );
//            }
//
//        } catch (ParseException e) {
////            System.out.println( "Input error!" );
//            e.printStackTrace();
//            helper.printHelp( "UUI", options );
//            System.exit( 0 );
//        } catch (NumberFormatException e) {
////            System.out.println( "Please enter valid pat" );
//        }



        InitGraph initGraph = new InitGraph( space );
        InitHeuristic initHeuristic = null;


        if(heuristic.equals( "" ) == false) {
            initHeuristic = new InitHeuristic( heuristic, initGraph.getNodeList() );
        }

        if(algorithm.equals( "bfs" )) {
            BFS bfs = new BFS( initGraph );
            bfs.search(true, false);
        } else if(algorithm.equals( "astar" )) {
            ASTAR aStar = new ASTAR(initGraph, initHeuristic.getHeuristicMap(), heuristic);
            aStar.search(true);
        } else if(algorithm.equals( "ucs" )) {
             UCS ucs = new UCS(initGraph);
             ucs.search();
        } else if (optimistic) {
            HeuristicOptimistic heuristicOptimistic = new HeuristicOptimistic(initGraph, initHeuristic.getHeuristicMap(), heuristic);
            heuristicOptimistic.run();
        } else if (consistent) {
            HeuristicConsistent heuristicConsistent = new HeuristicConsistent(initGraph, initHeuristic.getHeuristicMap(), heuristic);
            heuristicConsistent.run();
        }

//        BFS bfs = new BFS( initGraph );
//        bfs.search(true, true);


//        BFS2 bfs = new BFS2( initGraph );
//        bfs.search(true);

//        HeuristicOptimistic heuristicOptimistic = new HeuristicOptimistic(initGraph, initHeuristic.getHeuristicMap(), heuristic);
//        heuristicOptimistic.run();

//        HeuristicConsistent heuristicConsistent = new HeuristicConsistent(initGraph, initHeuristic.getHeuristicMap(), heuristic);
//        heuristicConsistent.run();


    }
}