package token;

public class Token {
	public final String type;
	public final String text;
//	public final String category;
	public final int index;
	

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
