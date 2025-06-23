package readandsort.util;

/**
 * The {@code Message} utility class serves as a message printer. It provides
 * four user-friendly and reusable printing methods to deal with dynamic needs -
 * prompts, warnings, successful sorts and result lists in a formatted style.
 *
 * <p>
 * The {@code ReadAndSortApp} and {@code SorterFactory} depend on this class to
 * display relevant information based on specific read-and-sort workflows.
 * </p>
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see readandsort.app.ReadAndSortApp
 * @see SorterFactory
 */
public class Message{

    /**
     * Prints a warning message with a warning prefix followed by given message.
     * @param message the warning message that needs to be printed.
     */
    public static void warning(String message) {
        System.out.println("\n[Warning]: " + message);
    }

    /**
     * Prints a success message with a success prefix followed by given message.
     * @param message the success message that needs to be printed.
     */
    public static void success(String message) {
        System.out.println("\n[Success]: " + message);
    }

    /**
     * Prints a prompt message for user input with prefix ">>> " followed by
     * given message.
     * @param message the prompt message that needs to be printed.
     */
    public static void prompt(String message) {
        System.out.print("\n>>> " + message);
    }

    /**
     * Prints a result message combined a customized prefix with the given
     * object.
     * @param prefix the descriptive prefix, typically indicating collection
     *               type of the result object or other important content.
     *
     * @param object the result object to print.
     */
    public static void result(String prefix, Object object) {
        System.out.println(prefix + object);
    }

    /*
    Reusability:
    Every method from this class can be fully reused.
    For example:
    Message.prompt("Please enter integers:");
    Message.warning("Invalid input occurred!");
    Message.success("Integer processed successfully.");
    Message.result("Sorted (LinkedList): ", sortedList)

    Especially, the result method uses the Object type to support any result
    type (such as collections, string) since it is the superclass of all classes
    in Java, maximizing the flexibility and reusability.
     */
}
