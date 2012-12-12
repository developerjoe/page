package org.terzieva.page.command;

import org.terzieva.page.game.Context;

public interface Command {

	public String interpret(String input, Context context);
	
}
