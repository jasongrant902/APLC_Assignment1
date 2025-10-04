package appDomain;

import java.util.Scanner;

import manager.AnalysisManager;

public class AppDriver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("User Input: ");
		String userInput = scanner.nextLine();
		
		if (userInput.length() <1) {
			System.out.println("Invalid input. Usage: java AppDriver <source_code_string>");
			return;
		}
		
		AnalysisManager analyzer = new AnalysisManager();
		analyzer.parseCode(userInput);
		scanner.close();
	}
}
