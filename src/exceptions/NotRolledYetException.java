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
public class NotRolledYetException extends Exception {

    /**
     * Constructs a new NotRolledYetException.
     */
    public NotRolledYetException() {
        super();
    }

    /**
     * Constructs a new NotRolledYetException with the specified detail message.
     * @param message is the detail message as a string.
     */
    public NotRolledYetException(String message) {
        super(message);
    }

    /**
     * Constructs a new NotRolledYetException with the specified cause.
     * @param cause is the cause that caused the Exception.
     */
    public NotRolledYetException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new NotRolledYetException with the specified message and the specified cause.
     * @param message is the detail message as a string.
     * @param cause is the cause that caused the Exception.
     */
    public NotRolledYetException(String message, Throwable cause) {
        super(message, cause);
    }
}
