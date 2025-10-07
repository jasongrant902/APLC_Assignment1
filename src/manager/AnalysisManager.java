package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.LexicalAnalysisException;
import token.Token;

/**
 * AppDriver.java
 * 
 * This class represents the analysis manager of the program.
 * 
 * This class accepts the user input passed to it from the app driver
 * and processes the data. Once processed, a report is displayed to the user.
 * 
 * @author Dylane Cunningham
 * @version 06-10-2025
 * @since 04-10-2025
 */
public class AnalysisManager {
	private static final Map<String, String> tokenMap;

	static {
		Map<String, String> tempMap = new HashMap<>();
		
		// --- Punctuation ---
		tempMap.put("[", "Left Bracket");
		tempMap.put("]", "Right Bracket");
	
		// --- General Keywords ---
		tempMap.put("program", "Program Keyword");
		tempMap.put("statement", "Statement Keyword");
		tempMap.put("statements", "Statements Keyword");
		tempMap.put("expr", "Expression Keyword");
		tempMap.put("type", "Data Types Keyword");
		tempMap.put("operation", "Operation Keyword");
		tempMap.put("condition", "Condition Keyword");
		tempMap.put("identifier", "Identifier Keyword");
		tempMap.put("log-statement", "Log Statement");
		tempMap.put("characters", "Characters Keyword");
		tempMap.put("value", "Value Declaration");
	
		// --- Data Type Keywords ---
		tempMap.put("int", "Integer Data Type");
		tempMap.put("string", "String Data Type");
		tempMap.put("double", "Double Data Type");
		tempMap.put("float", "Float Data Type");
		tempMap.put("bool", "Boolean Data Type");
	
		// --- Conditional, Mathematical, and Logical Operators ---
		tempMap.put("+", "Concatenation/Addition Operator");
		tempMap.put("-", "Subtraction Operator");
		tempMap.put("/", "Division Operator");
		tempMap.put("*", "Multiplication Operator");
		tempMap.put("=", "Assignment/Equals Operator");
		tempMap.put(">", "Greater Than Operator");
		tempMap.put("<", "Less Than Operator");
		tempMap.put("<=", "Less Than or Equal Operator");
		tempMap.put(">=", "Greater Than or Equal Operator");
		tempMap.put("==", "Double Equal Operator");
		tempMap.put("===", "Triple Equal Operator");
	
		// --- Loop Keywords ---
		tempMap.put("loop-statement", "Loop Statement");
		tempMap.put("loop-type", "Loop Classification");
		tempMap.put("for-loop", "For Loop");
		tempMap.put("while-loop", "While Loop");
		tempMap.put("for-each-loop", "For Each Loop");
	
		// --- Conditional Statement Keywords & Literals ---
		tempMap.put("conditional-statement", "Conditional Statement");
		tempMap.put("conditional-keyword", "Condition Classification");
		tempMap.put("if", "If Keyword");
		tempMap.put("else", "Else Keyword");
		tempMap.put("true", "Boolean True Literal");
		tempMap.put("false", "Boolean False Literal");
		tempMap.put("in", "In Operator");

		
		tokenMap = Collections.unmodifiableMap(tempMap);
	}
	
	// Class constructor
	public AnalysisManager() {
		
	}
	 /**
	  * This method accepts the input from the user, processes it through a set of loops, creating a token object 
	  * for each token, and displays a report once it has completed the analysis process.
	  * 
	  * @param input User input passed into the method from the app driver.
	  */
	public void parseCode(String input) throws LexicalAnalysisException {
		List<Token> tokens = new ArrayList<>();
		int count = 0;
	
		// While loop that processes the input as long as the count is less than the length of the code.
		while (count < input.length()) {
			while (Character.isWhitespace(input.charAt(count))) {
				count++;
			}
			
			Character character = input.charAt(count);
			
			// If statement checks if the current character is either a "[" or "]". If it is, then it immediately
			// creates a token object and adds it to the token map. if not, it continues processing the input for the 
			// next valid keyword.
			if (character == '[' || character == ']') {
				tokens.add(new Token(tokenMap.get(character.toString()), character.toString(), count));
				count++;
			} else {
				int endIndex = -1;
				int i = count;
				char isBracket = 'n';
				
				// While loop that processes the input looking for the next square bracket.
				while (i < input.length() && isBracket == 'n') {
					if (input.charAt(i) == '[' || input.charAt(i) == ']') {
						endIndex = i;
						isBracket = 'y';
					} else {
						i++;
					}
				}
				
				// Error thrown if input does not contain a corresponding square bracket before the end of the input.
				if (endIndex == -1) {
					throw new LexicalAnalysisException("Error: found the start of a keyword, but no closing bracket was "
							+ "found before the end of the input.");
				}
				
				// Creation of a new token object and addition of the object to the map based on the substring from the input.
				String substring = input.substring(count, endIndex);
				tokens.add(new Token(tokenMap.getOrDefault(substring, "Unknown Keyword/Identifier"), substring, count));
				count = endIndex;
			}	
		}
		
		// Display of each token's information in order from the map.
		System.out.println("Lexical Analysis of user input: " + input);
		for (Token token : tokens) {
			System.out.println(token.toString());
		}
	}
}















