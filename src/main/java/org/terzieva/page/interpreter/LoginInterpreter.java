package org.terzieva.page.interpreter;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terzieva.page.domain.Player;
import org.terzieva.page.domain.Term;

public class LoginInterpreter implements Interpreter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterpreter.class);
	
	private enum Stage { INTRO, EMAIL };
	private Stage stage;
	
	public LoginInterpreter()
	{
		stage = Stage.INTRO;
	}
	
	@Override
	public String interpret(String message) {
		if(stage == Stage.INTRO)
		{
			stage = Stage.EMAIL;
			return showIntro();
		}
		else if(stage == Stage.EMAIL)
		{
			return handleEmail(message);
		}
		else
		{
			return "Stage Not Implemented";
		}
	}
	
	private String showIntro()
	{
		// tries to load a term with the key INTRO. If you have defined one in the
		// database it will be used.
		return Term.textFromKey("INTRO");
	}
	
	private String handleEmail(String email)
	{
		boolean isEmailValid = EmailValidator.getInstance().isValid(email);
		
		if(!isEmailValid)
			return Term.textFromKey("INTRO_BADEMAIL");
		
		Player player = Player.findByEmail(email);
		
		if(player != null)
			return Term.textFromKey("INTRO_EMAIL_EXISTS");
		
		player = new Player();
		player.setEmail(email);
		player.persist();
		player.flush();
		
		return Term.textFromKey("INTRO_EMAIL_CREATING");
	}
}
