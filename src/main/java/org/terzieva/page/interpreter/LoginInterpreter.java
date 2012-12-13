package org.terzieva.page.interpreter;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terzieva.page.domain.Player;
import org.terzieva.page.domain.Term;
import org.terzieva.page.game.Context;

public class LoginInterpreter extends AbstractInterpreter {

	private Context context;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LoginInterpreter.class);
	
	public LoginInterpreter()
	{
		context = new Context();
	}
	
	@Override
	public void start()
	{
		send(showIntro());
	}
	
	@Override
	public void interpret(String message) {
		send(handleEmail(message));
	}
	
	private String showIntro()
	{
		// tries to load a term with the key INTRO. If you have defined one in the
		// database it will be used.
		return Term.textFromKey("INTRO");
	}
	
	private String handleEmail(String email)
	{
		String message;
		boolean isEmailValid = EmailValidator.getInstance().isValid(email);
		
		if(!isEmailValid)
			return Term.textFromKey("INTRO_BADEMAIL");
		
		Player player = Player.findByEmail(email);
		
		if(player != null)
		{
			message = Term.textFromKey("INTRO_EMAIL_EXISTS");
			// transition to a new interpreter
			transitionInterpreter(player);
			return message;
		}
		
		// if you have not returned yet create a new player
		player = new Player();
		player.setEmail(email);
		player.persist();
		
		message = Term.textFromKey("INTRO_EMAIL_CREATING");
		
		// transition to a new interpreter
		transitionInterpreter(player);
		
		return message;
	}
	
	private void transitionInterpreter(Player player)
	{
		context.player = player;
		interpreter = new AreaInterpreter(context);
	}
	
}
