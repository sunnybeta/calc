package io.sunnybeta.calc.evaluator;

/**
 * A simple algorithm for carrying out arithmetic expressions with the BODMAS (PEMDAS) rule
 * @author Sunny Beta
 * @version 1.0
 */
public class Cli{
	/** Main Method - Command Line Arguments
	 * @param args list of strings which are command line arguments
	 */
	public static void main(String[] args){
		if (args.length == 0) {
			help();
			return;
		}
		Evaluator obj = new Evaluator();
		System.out.println(obj.compute(args[0]));
	}

	private static void help() {
		String help = "Usage: calc [EXPRESSION]\n"
		+ "Evaluate an arithmetic EXPRESSION in the terminal.\n\n"
		+ "Example\n"
		+ "calc '2+3/4'\n\n"
		+ "Full documentation at: <https://sunnybeta.github.io/calc/docs>";
		System.out.println(help);
	}
}
