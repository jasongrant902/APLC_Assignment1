package token;

/**
 * Token.java
 * 
 * This class represents a token object that is discovered and 
 * passed to it by the Lexical Analyzer.
 * 
 * Each token object represents a token from the analyzed code.
 * It can represent a data type, general structure/format, comparison 
 * operator, conditional operator, loop keyword, etc.
 * 
 * @author Dylane Cunningham
 * @version 06-10-2025
 * @since 04-10-2025
 */
public class Token {
	public final String type;
	public final String text;
	public final int index;
	
	// constructor
	public Token(String type, String text, int index) {
		this.type = type;
		this.text = text;
		this.index = index;
	}

	@Override
	public String toString() {
		return text + "  -  " + type;
	}
}



