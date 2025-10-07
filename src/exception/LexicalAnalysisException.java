package exception;

/**
 * Class containing custom the exception for errors that occur during the lexical analysis phase.
 * 
 * @author Dylane Cunningham
 * @version 06-10-2025
 * @since 04-10-2025
 */
@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception {
    
    /**
     * Constructs a new LexicalAnalysisException with the specified detail message.
     * 
     * @param message String message with exception details.
     */
    public LexicalAnalysisException(String message) {
        super(message);
    }
}