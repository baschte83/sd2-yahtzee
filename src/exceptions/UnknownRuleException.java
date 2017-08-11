package exceptions;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 28. April 2017<br>
 * Purpose: solution to lab 02: Yahtzee game<br>
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class UnknownRuleException extends Exception {

    /**
     * Constructs a new UnknownRuleException.
     */
    public UnknownRuleException() {
        super();
    }

    /**
     * Constructs a new UnknownRuleException with the specified detail message.
     * @param message is the detail message as a string.
     */
    public UnknownRuleException(String message) {
        super(message);
    }

    /**
     * Constructs a new UnknownRuleException with the specified cause.
     * @param cause is the cause that caused the Exception.
     */
    public UnknownRuleException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UnknownRuleException with the specified message and the specified cause.
     * @param message is the detail message as a string.
     * @param cause is the cause that caused the Exception.
     */
    public UnknownRuleException(String message, Throwable cause) {
        super(message, cause);
    }

}