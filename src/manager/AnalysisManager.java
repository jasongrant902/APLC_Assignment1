package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import token.Token;

public class AnalysisManager {
	private static final Map<String, String> tokenMap;

	static {
		Map<String, String> tempMap = new HashMap<>();
		// --- Punctuation ---
		tempMap.put("[", "Left Bracket");
		tempMap.put("]", "Right Bracket");
	
		// --- General Keywords for Structure ---
		tempMap.put("program", "Program Keyword");
		tempMap.put("statement", "Statement Keyword");
		tempMap.put("expr", "Expression Keyword");
		tempMap.put("type", "Type Keyword");
		tempMap.put("operation", "Operation Keyword");
		tempMap.put("condition", "Condition Keyword");
		tempMap.put("identifier", "Identifier Keyword");
		tempMap.put("=", "Assignment Operator");
	
		// --- Data Type Keywords ---
		tempMap.put("int", "Integer Type");
		tempMap.put("string", "String Type");
		tempMap.put("double", "Double Type");
		tempMap.put("bool", "Boolean Type");
	
		// --- Mathematical and Logical Operators ---
		tempMap.put("+", "Plus Operator");
		tempMap.put("-", "Minus Operator");
		tempMap.put("/", "Slash Operator");
		tempMap.put("*", "Asterisk Operator");
		tempMap.put("in", "In Operator");
	
		// --- Conditional Operators ---
		tempMap.put(">", "Greater Than Operator");
		tempMap.put("<", "Less Than Operator");
		tempMap.put("<=", "Less Than or Equal Operator");
		tempMap.put(">=", "Greater Than or Equal Operator");
		tempMap.put("==", "Equal Operator");
		tempMap.put("===", "Triple Equal Operator");
	
		// --- Loop Keywords ---
		tempMap.put("loop-statement", "Loop Statement Keyword");
		tempMap.put("for-loop", "For Loop Keyword");
		tempMap.put("while-loop", "While Loop Keyword");
		tempMap.put("for-each-loop", "For Each Loop Keyword");
	
		// --- Conditional Statement Keywords & Literals ---
		tempMap.put("conditional-statement", "Conditional Statement Keyword");
		tempMap.put("if", "If Keyword");
		tempMap.put("else", "Else Keyword");
		tempMap.put("true", "Boolean True Literal");
		tempMap.put("false", "Boolean False Literal");
	
		// --- Logging Keywords ---
		tempMap.put("log-statement", "Log Statement Keyword");
		tempMap.put("characters", "Characters Keyword");
		
		tokenMap = Collections.unmodifiableMap(tempMap);
	}
	
	public AnalysisManager() {
		
	}
	
	public void parseCode(String input) {
		List<Token> tokens = new ArrayList<>();
		String type = null;
		String text = null;
		int index = 0;
		int count = 0;
		Character character = null;
	
		while (count <= input.length()-1) {
			character = input.charAt(count);
			
			if (tokenMap.containsKey(character.toString())) {
				type = tokenMap.get(character.toString());
				text = character.toString();
				index = count;
				count++;
			} else {
				index = count;
				text = "";
				while (character != '[' && character != ']') {
					// !tokenMap.containsKey(character.toString()) || 
					text += character.toString();
					count++;
					character = input.charAt(count);
				}
				if (tokenMap.containsKey(text)) {
					type = tokenMap.get(text);
				} else {
					type = "Identifier name";
				}
			}
			tokens.add(new Token(type, text, index));
		}
		
		System.out.println("Lexical Analysis of user input: " + input);
		for (Token token : tokens) {
			System.out.println(token.toString());
		}
	}

}
