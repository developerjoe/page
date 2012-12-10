package org.terzieva.page.interpreter;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terzieva.page.domain.Term;

public class LoginInterpreter implements Interpreter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterpreter.class);
	
	@Override
	public String interpret(String message) {
		
		// tries to load a term with the key INTRO. If you have defined one in the
		// database it will be used.
		try
		{
			Term term = Term.findTermsByTermKeyEquals("INTRO").getSingleResult();
			return term.getText();
		}
		catch(NoResultException e)
		{
			logger.error("No term defined with the key INTRO", e);
		}
		
		return "";
	}
}
