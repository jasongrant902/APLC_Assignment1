package appDomain;

import java.util.Scanner;

import exception.LexicalAnalysisException;
import manager.AnalysisManager;

/**
 * AppDriver.java
 * 
 * This class represents the main driving class of the program.
 * 
 * @author Dylane Cunningham
 * @version 06-10-2025
 * @since 04-10-2025
 */
public class AppDriver {

	/**
	 * This method creates a new scanner and AnalysisManager object, prompts the user for input, 
	 * confirms the input is valid, and passes the input to the analyzer.
	 * 
	 * @param args Arguments passed into the program from the CLI
	 */
	public static void main(String[] args) {
		// Creation of scanner and AnalysisManager object.
		Scanner scanner = new Scanner(System.in);
		AnalysisManager analyzer = new AnalysisManager();
		char programContinue = 'y';
		
		// while loop that will continue prompting the user for input until they exit.
		while (programContinue == 'y') {
			System.out.println("Please enter code for analysis or \"exit\" to quit: ");
			String userInput = scanner.nextLine();
			
			// input validation
			if (userInput.length() <1) {
				System.out.println("Invalid input. Please enter a new input.");
			} else if (userInput.equalsIgnoreCase("exit")) {
				programContinue = 'n';
			} else {		
				try {
					analyzer.parseCode(userInput);
				} catch (LexicalAnalysisException e) {
					System.err.println("Analysis Failed:\n");
					System.err.println(e.getMessage());
				}
			}
		}
		scanner.close();
	}
}
