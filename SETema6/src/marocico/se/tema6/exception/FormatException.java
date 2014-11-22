package marocico.se.tema6.exception;

/**
 * 
 * @author gby
 * 
 *         This class is used to catch and print the errors caused by the
 *         incorrect format of inputs.
 * 
 */
public class FormatException extends Exception {

	/**
	 * The constructor for the input exception
	 * 
	 * @param input
	 *            The input which started the exception
	 * @param errorMessage
	 *            The exception message for the bad format of input
	 */
	public FormatException(String errorSource, String errorMessage) {
		super("Input Format exception on \"" + errorSource + "\" : "
				+ errorMessage);
	}
}
