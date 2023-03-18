package ui.input.parse;

import org.apache.commons.cli.*;

public class InitComonsCli {
	
	public static Options init() {
		
		Options options = new Options();
		
	    Option alg = Option.builder("alg").longOpt("alg")
	            .argName("alg")
	            .hasArg()
	            .required(false) //NotRequired
	            .desc("abbreviation for state space search algorithm (values: bfs, ucs, or astar)").build();
	    options.addOption(alg);
	    
	    Option ss = Option.builder("ss").longOpt("ss")
	            .argName("count")
	            .hasArg()
	            .required(false)
	            .desc("path to state space descriptor file").build();
	    options.addOption(ss);


		Option h = Option.builder("h").longOpt("h")
				.argName("count")
				.hasArg()
				.required(false)
				.desc("path to heuristic descriptor file").build();
		options.addOption(h);

		Option optimistic = Option.builder("checkoptimistic").longOpt("check-optimistic")
				.argName("count")
				.hasArg()
				.required(false)
				.hasArg(false)
				.desc("path to heuristic descriptor file").build();
		options.addOption(optimistic);

		Option consistent = Option.builder("checkconsistent").longOpt("check-consistent")
				.argName("count")
				.hasArg()
				.required(false)
				.hasArg(false)
				.desc("path to heuristic descriptor file").build();
		options.addOption(consistent);
		
		return options;
	}

}
