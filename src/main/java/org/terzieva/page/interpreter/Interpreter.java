package org.terzieva.page.interpreter;

public interface Interpreter {

	/**
	 * Interpret parses the passed in message and returns the
	 * message result.
	 * @param message
	 * @return
	 */
	public String interpret(String message);	
	
}
