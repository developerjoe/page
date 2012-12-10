package org.terzieva.page.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.terzieva.page.interpreter.Interpreter;

/**
 * Maintains information pertaining to a connected user's instance.
 * @author Joseph Terzieva
 *
 */
@Configurable
public class Instance implements Interpreter {
	
	@Autowired @Qualifier("startInterpreter") private Interpreter interpreter;
	
	@Override
	public String interpret(String message) {
		return this.interpreter.interpret(message);
	}
	
}
